package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SelectQuery {
	
	@Test
	 public void fetchStudentInfo() {
	        String url = "jdbc:mysql://localhost:3306/test";
	        String userName = "root";
	        String password = "root";

	        String selectSql = "SELECT * FROM student";

	        try (Connection conn = DriverManager.getConnection(url, userName, password);
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(selectSql)) {

	            // Iterate through the result set and print each field value of each student
	            while (rs.next()) {
	                System.out.println("Student Information:");
	                System.out.println("--------------------------------------------");
	                System.out.println("ID: " + rs.getInt("student_id"));
	                System.out.println("First Name: " + rs.getString("first_name"));
	                System.out.println("Last Name: " + rs.getString("last_name"));
	                System.out.println("Age: " + rs.getInt("age"));
	                System.out.println("Gender: " + rs.getString("gender"));
	                System.out.println("Address: " + rs.getString("address"));
	                System.out.println("City: " + rs.getString("city"));
	                System.out.println("State: " + rs.getString("state"));
	                System.out.println("Country: " + rs.getString("country"));
	                System.out.println("Email: " + rs.getString("email"));
	                System.out.println("Phone Number: " + rs.getString("phone_number"));
	                System.out.println("Enrollment Date: " + rs.getString("enrollment_date"));
	                System.out.println("Graduation Date: " + rs.getString("graduation_date"));
	                System.out.println("Department: " + rs.getString("department"));
	                System.out.println("Major: " + rs.getString("major"));
	                System.out.println("Minor: " + rs.getString("minor"));
	                System.out.println("GPA: " + rs.getDouble("gpa"));
	                System.out.println("Credits Completed: " + rs.getInt("credits_completed"));
	                System.out.println("Advisor: " + rs.getString("advisor"));
	                System.out.println("Thesis Topic: " + rs.getString("thesis_topic"));
	                System.out.println("--------------------------------------------");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
