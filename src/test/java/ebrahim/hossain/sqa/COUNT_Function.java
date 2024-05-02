package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class COUNT_Function {

	@Test
	public void count() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// SQL query with COUNT() function
		String selectSql = "SELECT COUNT(student_id) AS total_students FROM student";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {

			// Print the total number of students
			System.out.println("Total Number of Students:");
			System.out.println("-------------------------");
			if (rs.next()) {
				int totalStudents = rs.getInt("total_students");
				System.out.println("Total Students: " + totalStudents);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
