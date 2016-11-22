package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection instance = null;
	
	public static synchronized Connection getConnection(){
		
		String connection = "jdbc:mysql://localhost/petevet";
		String login = "root";
		String password = "root";
		
		
		try {
			if (instance == null){
				new com.mysql.jdbc.Driver();
				instance =  DriverManager.getConnection(connection, login, password);
			}
			return instance;
			
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel conectar ao banco de dados" + e);
		}
	}
}
