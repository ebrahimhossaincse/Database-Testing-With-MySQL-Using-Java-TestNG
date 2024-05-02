package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class WhereClause {
	@Test
	public void whereCondition() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// Condition for WHERE clause
		String condition = "department = 'Computer Science'";

		String selectSql = "SELECT * FROM student WHERE " + condition;

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSql)) {

			// Print student records satisfying the condition
			System.out.println("Student Records:");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-4s %-10s %-10s %-4s %-6s %-40s %-20s %-10s %-10s %-30s %-15s %-15s %-30s %-30s %-30s %-4s %-16s %-30s %-100s\n", 
					"ID", "First Name", "Last Name", "Age", "Gender", "Address", "City", "State", "Country", "Email", "Phone Number", "Enrollment Date", "Graduation Date", "Department", "Major", "Minor", "GPA", "Credits Completed", "Advisor", "Thesis Topic");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.printf("%-4s %-10s %-10s %-4s %-6s %-40s %-20s %-10s %-10s %-30s %-15s %-15s %-30s %-30s %-30s %-4.2f %-16s %-30s %-100s\n",
						rs.getInt("student_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"),
						rs.getString("gender"), rs.getString("address"), rs.getString("city"), rs.getString("state"),
						rs.getString("country"), rs.getString("email"), rs.getString("phone_number"),
						rs.getString("enrollment_date"), rs.getString("graduation_date"), rs.getString("department"),
						rs.getString("major"), rs.getString("minor"), rs.getDouble("gpa"),
						rs.getInt("credits_completed"), rs.getString("advisor"), rs.getString("thesis_topic"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
