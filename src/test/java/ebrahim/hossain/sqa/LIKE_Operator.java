package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class LIKE_Operator {

	@Test(priority = 0)
	public void likeExample1() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// Search for students whose first name starts with 'J'
		String selectSql = "SELECT * FROM student WHERE first_name LIKE 'J%'";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {

			// Print the students whose first name starts with 'J'
			System.out.println("Students whose first name starts with 'J':");
			System.out.println("------------------------------------------");
			while (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				System.out.println(firstName + " " + lastName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void likeExample2() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// Search for students whose last name contains 'Brown'
		String selectSql = "SELECT * FROM student WHERE last_name LIKE '%Brown%'";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {

			// Print the students whose last name contains 'Brown'
			System.out.println("Students whose last name contains 'Brown':");
			System.out.println("--------------------------------------------");
			while (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				System.out.println(firstName + " " + lastName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
