package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.Cpf;
import util.Email;
import util.Telephone;

public class EmployeeDAO {
private Connection connection;
	
	public EmployeeDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void addEmployee(Employee employee){
		String sql = "INSERT INTO Employee" + "(name, cpf, email, telephone, role)"
				+ " values(?,?,?,?,?,?)";
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getCpf().getCpf());
			preparedStatement.setString(3, employee.getEmail().getEmail());
			preparedStatement.setString(4, employee.getTelephone().getTelephone());
			preparedStatement.setString(5, employee.getRole());
			
			preparedStatement.execute();
			preparedStatement.close();
			
		} catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
	
	public Employee searchEmployeeByCode(Long code){
		String sql = "SELECT * FROM Employee WHERE id = ?";
		Employee employee = null;
		try{
			PreparedStatement prepareStatement = this.connection.prepareStatement(sql);
			prepareStatement.setLong(1, code);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()){
				employee = new Employee();
				employee.setCode(resultSet.getLong("id"));
				employee.setName(resultSet.getString("name"));
				employee.setCpf(new Cpf(resultSet.getString("cpf")));
				employee.setEmail(new Email(resultSet.getString("email")));
				employee.setTelephone(new Telephone(resultSet.getString("telephone")));
				employee.setRole(resultSet.getString("role"));
			} else {
				// Returns a null employee.
			}
			resultSet.close();
			prepareStatement.close();
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		return employee;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employeesList = new ArrayList<Employee>();
		
		try{
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");
			
			while(resultSet.next()){
				Employee employee = new Employee();
				employee.setCode(resultSet.getLong("id"));
				employee.setName(resultSet.getString("name"));
				employee.setCpf(new Cpf(resultSet.getString("cpf")));
				employee.setEmail(new Email(resultSet.getString("email")));
				employee.setTelephone(new Telephone(resultSet.getString("telephone")));
				employee.setRole(resultSet.getString("role"));
				
				employeesList.add(employee);
			}
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}
		return employeesList;
	}
	
	public void updateEmployee(Employee employee) {
		String sql = "UPDATE Employee SET name=?, cpf=?, email=?, telephone=?, role=?"
					+"WHERE id=?";
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getCpf().getCpf());
			preparedStatement.setString(3, employee.getEmail().getEmail());
			preparedStatement.setString(4, employee.getTelephone().getTelephone());
			preparedStatement.setString(5, employee.getRole());
			preparedStatement.setLong(10, employee.getCode());
			
			preparedStatement.executeUpdate();
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
	
	public void deleteEmployee(Long code){
		String sql = "DELETE FROM Employee WHERE id=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, code);
			preparedStatement.executeUpdate();
			
		} catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
}
