package controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import dao.ProductDAO;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/product.jsp";
    private static String LIST_PRODUCT = "/listProduct.jsp";
	private ProductDAO productDao; 
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        productDao = new ProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			Long code = Long.parseLong(request.getParameter("code"));
			productDao.deleteProducts(code);
			forward = LIST_PRODUCT;
			request.setAttribute("productList", productDao.getAllProducts());
		}else if(action.equalsIgnoreCase("edit")){
			forward = INSERT_OR_EDIT;
			Long code = Long.parseLong(request.getParameter("code"));
			Product product = productDao.searchProductsByCode(code);
			request.setAttribute("product", product);
		} else if(action.equalsIgnoreCase("listProduct")){
			forward = LIST_PRODUCT;
			request.setAttribute("productList", productDao.getAllProducts());
		} else {
			forward = INSERT_OR_EDIT;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		
		product.setName(request.getParameter("name"));
		product.setDescription(request.getParameter("description"));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		product.setValue(BigDecimal.valueOf(Long.parseLong(request.getParameter("value"))));
		
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()){
			productDao.addProducts(product);
		} else {
			product.setCode(Long.parseLong(code));
			productDao.updateProducts(product);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(LIST_PRODUCT);
		request.setAttribute("productList", productDao.getAllProducts());
		dispatcher.forward(request, response);
	}

}
