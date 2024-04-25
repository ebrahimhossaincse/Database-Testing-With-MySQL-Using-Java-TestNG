package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class AVG_Function {

	@Test
	public void avg() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// SQL query with AVG() function
		String selectSql = "SELECT AVG(gpa) AS avg_gpa FROM student";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {

			// Print the average age of students
			System.out.println("Average GPA of Students:");
			System.out.println("-------------------------");
			if (rs.next()) {
				double avg_gpa = rs.getDouble("avg_gpa");
				System.out.println("Average GPA: " + avg_gpa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
