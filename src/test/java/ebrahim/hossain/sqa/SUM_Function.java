package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;

public class SUM_Function {

	@Test
	public void sum() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// SQL query with SUM() function
		String selectSql = "SELECT SUM(credits_completed) AS total_credits_completed FROM student";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {

			// Print the total credits completed by students
			System.out.println("Total Credits Completed by Students:");
			System.out.println("-------------------------------------");
			if (rs.next()) {
				int totalCreditsCompleted = rs.getInt("total_credits_completed");
				System.out.println("Total Credits Completed: " + totalCreditsCompleted);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
