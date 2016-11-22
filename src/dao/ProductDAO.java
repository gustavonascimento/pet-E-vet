package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;


public class ProductDAO {
	
private Connection connection;
	
	public ProductDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void addProducts(Product products){
		String sql = "INSERT INTO Products (name, value,  quantity, description) "
				+ " values(?,?,?,?)";
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			
			preparedStatement.setString(1, products.getName());
			preparedStatement.setBigDecimal(2, products.getValue());
			preparedStatement.setInt(3, products.getQuantity());
			preparedStatement.setString(4, products.getDescription());
			preparedStatement.execute();
			
			preparedStatement.close();
			
		} catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
	
	public Product searchProductsByCode(Long code){
		String sql = "SELECT * FROM Products WHERE id = ?";
		Product products = null;
		try{
			PreparedStatement prepareStatement = this.connection.prepareStatement(sql);
			prepareStatement.setLong(1, code);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()){
				products = new Product();
				products.setCode(resultSet.getLong("id"));
				products.setName(resultSet.getString("name"));
				products.setValue(resultSet.getBigDecimal("value"));
				products.setQuantity(resultSet.getInt("quantity"));
				products.setDescription(resultSet.getString("description"));

			} else {
				
			}
			resultSet.close();
			prepareStatement.close();
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		return products;
	}
	
	public List<Product> getAllProducts(){
		List<Product> productsList = new ArrayList<Product>();
		
		try{
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
			
			while(resultSet.next()){
				Product products = new Product();
				products.setCode(resultSet.getLong("id"));
				products.setName(resultSet.getString("name"));
				products.setValue(resultSet.getBigDecimal("value"));
				products.setQuantity(resultSet.getInt("quantity"));
				products.setDescription(resultSet.getString("description"));
				
				productsList.add(products);
			}
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}
		return productsList;
	}
	
	public void updateProducts(Product products) {
		String sql = "UPDATE Products SET name=?, value=?,  quantity=?, description=?"
				+"WHERE id=?";
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			
			preparedStatement.setString(1, products.getName());
			preparedStatement.setBigDecimal(2, products.getValue());
			preparedStatement.setInt(3, products.getQuantity());
			preparedStatement.setString(4, products.getDescription());
			preparedStatement.setLong(5, products.getCode());
			
			preparedStatement.executeUpdate();
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
	
	public void deleteProducts(Long code){
		String sql = "DELETE FROM Products WHERE id=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, code);
			preparedStatement.executeUpdate();
			
		} catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
}
