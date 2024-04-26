package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Aliases {

	@Test
	public void aliasExample() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// SQL query with aliases
		String selectSql = "SELECT first_name AS 'First Name', last_name AS 'Last Name' FROM student";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {

			// Print the result with aliases
			System.out.println("Student Names:");
			System.out.println("------------------");
			while (rs.next()) {
				String firstName = rs.getString("First Name");
				String lastName = rs.getString("Last Name");
				System.out.println(firstName + " " + lastName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
