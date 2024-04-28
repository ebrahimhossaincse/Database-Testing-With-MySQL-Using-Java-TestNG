package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class CreateTable {

	@Test
	public void createTable() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement()) {
			// Check if the table exists
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet resultSet = meta.getTables(null, null, "student", null);
			if (resultSet.next()) {
				// Drop the table if it exists
				stmt.executeUpdate("DROP TABLE student");
				System.out.println("Student table dropped successfully.");
			}

			// Create the new table
			String sql = "CREATE TABLE student (" + "student_id INT AUTO_INCREMENT PRIMARY KEY," + "first_name VARCHAR(50),"
					+ "last_name VARCHAR(50)," + "age INT," + "gender VARCHAR(10)," + "address VARCHAR(100),"
					+ "city VARCHAR(50)," + "state VARCHAR(50)," + "country VARCHAR(50)," + "email VARCHAR(100),"
					+ "phone_number VARCHAR(20)," + "enrollment_date DATE," + "graduation_date DATE,"
					+ "department VARCHAR(50)," + "major VARCHAR(50)," + "minor VARCHAR(50)," + "gpa DECIMAL(3, 2),"
					+ "credits_completed INT," + "advisor VARCHAR(100)," + "thesis_topic VARCHAR(200)" + ")";
			stmt.executeUpdate(sql);
			System.out.println("Student table created successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
