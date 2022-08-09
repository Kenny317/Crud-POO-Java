package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private final String base = "tienda";
	private final String user = "root";
	private final String password = "Tripa317";
	private final String url = "jdbc:mysql://localhost:3306/" + base;
	private Connection con = null;
	
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(this.url,this.user,this.password);
		}catch (SQLException | ClassNotFoundException e) {
			System.err.println(e);
		}
		return con;
	}

}
