package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import util.Address;
import util.Cpf;
import util.Email;
import util.Telephone;

public class CustomerDAO {
	private Connection connection;
	
	public CustomerDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void addCustumer(Customer customer){
		String sql = "INSERT INTO Customer (name, cpf, email, telephone,"
				+ "date_of_birth, address, neighborhood, city, cep)"
				+ " values(?,?,?,?,STR_TO_DATE(?,  \"%d/%m/%Y\"),?,?,?,?)";
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getCpf().getCpf());
			preparedStatement.setString(3, customer.getEmail().getEmail());
			preparedStatement.setString(4, customer.getTelephone().getTelephone());
			preparedStatement.setString(5, customer.getDate_of_birth());
			preparedStatement.setString(6, customer.getAddress().getAddress());
			preparedStatement.setString(7, customer.getAddress().getNeighborhood());
			preparedStatement.setString(8, customer.getAddress().getCity());
			preparedStatement.setString(9, customer.getAddress().getCep());
			
			preparedStatement.execute();
			preparedStatement.close();
			
		} catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
	
	public Customer searchCustomerByCode(Long code){
		String sql = "SELECT * FROM Customer WHERE id = ?";
		Customer customer = null;
		try{
			PreparedStatement prepareStatement = this.connection.prepareStatement(sql);
			prepareStatement.setLong(1, code);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()){
				customer = new Customer();
				customer.setCode(resultSet.getLong("id"));
				customer.setName(resultSet.getString("name"));
				customer.setCpf(new Cpf(resultSet.getString("cpf")));
				customer.setEmail(new Email(resultSet.getString("email")));
				customer.setTelephone(new Telephone(resultSet.getString("telephone")));
				customer.setDate_of_birth(resultSet.getString("date_of_birth"));
				customer.setAddress(new Address(resultSet.getString("address"),
				                                                		resultSet.getString("neighborhood"),
				                                                		resultSet.getString("city"),
				                                                		resultSet.getString("cep")));
			} else {
				// Returns a null customer.
			}
			resultSet.close();
			prepareStatement.close();
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		return customer;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> customersList = new ArrayList<Customer>();
		
		try{
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer");
			
			while(resultSet.next()){
				Customer customer = new Customer();
				customer.setCode(resultSet.getLong("id"));
				customer.setName(resultSet.getString("name"));
				customer.setCpf(new Cpf(resultSet.getString("cpf")));
				customer.setEmail(new Email(resultSet.getString("email")));
				customer.setTelephone(new Telephone(resultSet.getString("telephone")));
				customer.setDate_of_birth(resultSet.getString("date_of_birth"));
				customer.setAddress(new Address(resultSet.getString("address"),
				                                                		resultSet.getString("neighborhood"),
				                                                		resultSet.getString("city"),
				                                                		resultSet.getString("cep")));
				customersList.add(customer);
			}
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}
		return customersList;
	}
	
	public void updateCustomer(Customer customer) {
		String sql = "UPDATE Customer SET name=?, cpf=?, email=?, telephone=?,"
				+ "date_of_birth=?, address=?, neighborhood=?, city=?, cep=?"
				+"where id=?";
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(3, customer.getEmail().getEmail());
			preparedStatement.setString(4, customer.getTelephone().getTelephone());
			preparedStatement.setString(5, customer.getDate_of_birth());
			preparedStatement.setString(6, customer.getAddress().getAddress());
			preparedStatement.setString(7, customer.getAddress().getNeighborhood());
			preparedStatement.setString(8, customer.getAddress().getCity());
			preparedStatement.setString(9, customer.getAddress().getCep());
			preparedStatement.setLong(10, customer.getCode());
			
			preparedStatement.executeUpdate();
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
}
