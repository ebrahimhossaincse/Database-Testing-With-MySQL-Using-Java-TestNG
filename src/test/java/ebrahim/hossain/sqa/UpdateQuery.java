package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class UpdateQuery {

	@Test
	public void update() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// Update query
		String updateSql = "UPDATE student SET gpa = 4.0 WHERE department = 'Computer Science'";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement()) {

			// Execute the update query
			int rowsAffected = stmt.executeUpdate(updateSql);

			// Print the number of rows affected
			System.out.println("Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
