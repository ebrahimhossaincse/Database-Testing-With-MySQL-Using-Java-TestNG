package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class MIN_Function {

	@Test
	public void max() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// SQL query with MAX() function
		String selectSql = "SELECT MAX(age) AS max_age FROM student";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {

			System.out.println("Maximum Age of Students:");
			System.out.println("-------------------------");
			if (rs.next()) {
				int maxAge = rs.getInt("max_age");
				System.out.println("Maximum Age: " + maxAge);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
