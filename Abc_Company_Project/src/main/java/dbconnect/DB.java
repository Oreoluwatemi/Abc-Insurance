package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	private static Connection connection;
	
	private DB() {
		
	}
	
	public static Connection getConnection() throws Exception {
		if(connection == null || connection.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/abc_company_db", "root", "Oreoluwa8");
		}
		return connection;
	}

}
