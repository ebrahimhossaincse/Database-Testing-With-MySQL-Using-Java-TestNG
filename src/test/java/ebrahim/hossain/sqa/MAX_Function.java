package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class MAX_Function {

	@Test
	public void min() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// SQL query with MIN() function
		String selectSql = "SELECT MIN(age) AS min_age FROM student";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {

			// Print the minimum age of students
			System.out.println("Minimum Age of Students:");
			System.out.println("-------------------------");
			if (rs.next()) {
				int minAge = rs.getInt("min_age");
				System.out.println("Minimum Age: " + minAge);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
