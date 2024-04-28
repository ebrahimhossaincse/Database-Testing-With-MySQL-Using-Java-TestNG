package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class INNER_JOIN {

	@Test
	public void innerJoin() {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT s.first_name, s.last_name, c.course_name, c.instructor " + "FROM student s "
					+ "INNER JOIN student_course sc ON s.student_id = sc.student_id "
					+ "INNER JOIN course c ON sc.course_id = c.course_id";

			try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					String courseName = rs.getString("course_name");
					String instructor = rs.getString("instructor");

					System.out.println("Student: " + firstName + " " + lastName + ", Course: " + courseName
							+ ", Instructor: " + instructor);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
