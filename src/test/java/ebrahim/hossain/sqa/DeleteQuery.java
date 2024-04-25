package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DeleteQuery {

	@Test
	public void delete() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// Delete query
		String deleteSql = "DELETE FROM student WHERE department = 'Biology'";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement()) {

			// Execute the delete query
			int rowsAffected = stmt.executeUpdate(deleteSql);

			// Print the number of rows affected
			System.out.println("Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
