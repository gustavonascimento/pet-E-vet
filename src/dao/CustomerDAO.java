package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Customer;
import dao.ConnectionFactory;

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
			preparedStatement.setString(4, customer.getTelephoneNumber().getTelephoneNumber());
			preparedStatement.setString(5, customer.getDateOfBirth());
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
}
