package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection(){
		String conexao = "jdbc:mysql://localhost/petevet";
		String login = "root";
		String senha = "gustavo123";

		try {
			new com.mysql.jdbc.Driver();
			return DriverManager.getConnection(conexao, login, senha);
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel conectar ao banco de dados" + e);
		}
	}
}
