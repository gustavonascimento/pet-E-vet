package dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Owner;
import util.Cpf;
import util.Email;
import util.Telephone;

public class OwnerDAO {
	
	private Connection connection;
	
	public OwnerDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void addOwner(Owner owner){
		String sql = "INSERT INTO Owner" + "(name, cpf, email, telephone, password)"
				+ " values(?,?,?,?,?)";
		
		String passwordSHA = owner.getPassword();
		
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = md.digest(passwordSHA.getBytes("UTF-8"));
			
			StringBuilder sb = new StringBuilder();
			
			for(byte b : messageDigest) {
				sb.append(String.format("%02X", 0xFF & b));
			}
			
			String passwordHex = sb.toString();
			
			preparedStatement.setString(1, owner.getName());
			preparedStatement.setString(2, owner.getCpf().getCpf());
			preparedStatement.setString(3, owner.getEmail().getEmail());
			preparedStatement.setString(4, owner.getTelephone().getTelephone());
			preparedStatement.setString(5, passwordHex);
			
			preparedStatement.execute();
			preparedStatement.close();
			
		} catch(SQLException sqlException){
			sqlException.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Owner searchOwnerByCode(Long code){
		String sql = "SELECT * FROM Owner WHERE id = ?";
		Owner owner = null;
		try{
			PreparedStatement prepareStatement = this.connection.prepareStatement(sql);
			prepareStatement.setLong(1, code);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()){
				owner = new Owner();
				owner.setCode(resultSet.getLong("id"));
				owner.setName(resultSet.getString("name"));
				owner.setCpf(new Cpf(resultSet.getString("cpf")));
				owner.setEmail(new Email(resultSet.getString("email")));
				owner.setTelephone(new Telephone(resultSet.getString("telephone")));
				owner.setPassword(resultSet.getString("passowrd"));
			} else {
				// Returns a null owner.
			}
			resultSet.close();
			prepareStatement.close();
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
		return owner;
	}
	
//	public Owner authentication(Owner owner){
//		Owner ownerReturn = null;
//		String sql = "SELECT * FROM Owner WHERE email = ? and password = ?";
//		
//		try{
//			PreparedStatement prepareStatement = this.connection.prepareStatement(sql);
//			prepareStatement.setLong(1, code);
//			
//			ResultSet resultSet = prepareStatement.executeQuery();
//			if(resultSet.next()){
//				owner = new Owner();
//				owner.setCode(resultSet.getLong("id"));
//				owner.setName(resultSet.getString("name"));
//				owner.setCpf(new Cpf(resultSet.getString("cpf")));
//				owner.setEmail(new Email(resultSet.getString("email")));
//				owner.setTelephone(new Telephone(resultSet.getString("telephone")));
//				owner.setPassword(resultSet.getString("senha"));
//			} else {
//				// Returns a null owner.
//			}
//			resultSet.close();
//			prepareStatement.close();
//		}catch(SQLException sqlException){
//			sqlException.printStackTrace();
//		}
//		return owner;
//	}
	
	public List<Owner> getAllOwners(){
		List<Owner> ownersList = new ArrayList<Owner>();
		
		try{
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Owner");
			
			while(resultSet.next()){
				Owner owner = new Owner();
				owner.setCode(resultSet.getLong("id"));
				owner.setName(resultSet.getString("name"));
				owner.setCpf(new Cpf(resultSet.getString("cpf")));
				owner.setEmail(new Email(resultSet.getString("email")));
				owner.setTelephone(new Telephone(resultSet.getString("telephone")));
				owner.setPassword(resultSet.getString("password"));
				
				ownersList.add(owner);
			}
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}
		return ownersList;
	}
	
	public void updateOwner(Owner owner) {
		String sql = "UPDATE Customer SET name=?, cpf=?, email=?, telephone=?,"
				+ "password"
				+"WHERE id=?";
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			
			preparedStatement.setString(1, owner.getName());
			preparedStatement.setString(2, owner.getCpf().getCpf());
			preparedStatement.setString(3, owner.getEmail().getEmail());
			preparedStatement.setString(4, owner.getTelephone().getTelephone());
			preparedStatement.setString(5, owner.getPassword());
			preparedStatement.setLong(10, owner.getCode());
			
			preparedStatement.executeUpdate();
		} catch (SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
	
	public void deleteOwner(Long code){
		String sql = "DELETE FROM Owner WHERE id=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, code);
			preparedStatement.executeUpdate();
			
		} catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
}
