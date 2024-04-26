package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class In_Operator {

	@Test
	public void inOperatorExample() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// Define the list of ages to search for
		String ages = "(20, 21, 22)";

		// SQL query with IN operator
		String selectSql = "SELECT * FROM student WHERE age IN " + ages;

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {

			// Print the students whose age is 20, 21, or 22
			System.out.println("Students whose age is 20, 21, or 22:");
			System.out.println("-------------------------------------");
			while (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int age = rs.getInt("age");
				System.out.println(firstName + " " + lastName + " (Age: " + age + ")");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
