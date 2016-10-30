package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Animal;

public class AnimalDAO {
	private Connection connection;

	public AnimalDAO(){
		this.connection = ConnectionFactory.getConnection();
	}

	public void addAnimal(Animal animal){
		String sql = "INSERT INTO Animal (id, name, breed, age, sex)"
				+" values(?,?,?,?,?)";
		try{
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

			preparedStatement.setLong(1, animal.getCode());
			preparedStatement.setString(2, animal.getName());
			preparedStatement.setString(3, animal.getBreed());
			preparedStatement.setInt(4, animal.getAge());
			preparedStatement.setString(5, String.valueOf(animal.getSex()));

			preparedStatement.execute();
			preparedStatement.close();

		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
	}

	public List<Animal> listAnimalsForACustomer(Long code){
		List<Animal> animalsList = new ArrayList<Animal>();
		String sql = "SELECT id, name,breed,age,sex FROM Animal WHERE id =?";
		
		try{
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, code);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				Animal animal = new Animal();
				animal.setCode(code);
				animal.setName(resultSet.getString("name"));
				animal.setBreed(resultSet.getString("breed"));
				animal.setAge(resultSet.getInt("age"));
				animal.setSex(resultSet.getString("sex").charAt(0));

				animalsList.add(animal);
			}
		}catch (SQLException sqlException){
			sqlException.printStackTrace();
		}

		return animalsList;
	}

	public void deleteAnimal(String name){
		String sql = "DELETE FROM Animal WHERE name=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();

		} catch(SQLException sqlException){
			sqlException.printStackTrace();
		}
	}
}
