package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.testng.annotations.Test;

public class CreateDatabase {

	@Test
	public void createDatabase() {

		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create a connection
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String password = "root";

			try (Connection con = DriverManager.getConnection(url, userName, password);
					Statement stmt = con.createStatement()) {

				// Check if connection is successful
				if (con != null && !con.isClosed()) {
					System.out.println("Connection Established.");

					// Drop the database if it exists
					String dbName = "test";
					String dropDbQuery = "DROP DATABASE IF EXISTS " + dbName;
					stmt.executeUpdate(dropDbQuery);
					System.out.println("Database dropped (if existed): " + dbName);

					// Create a new database
					String createDbQuery = "CREATE DATABASE " + dbName;
					stmt.executeUpdate(createDbQuery);
					System.out.println("Database created: " + dbName);
				} else {
					System.out.println("Failed to establish connection.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
