package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.testng.annotations.Test;

public class CourseTable {

	@Test
	public void course() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		try (Connection conn = DriverManager.getConnection(url, userName, password)) {
			// Create the course table
			createCourseTable(conn);

			insertCourse(conn, "Java Programming", "John Smith", "Computer Science", "2024-09-01", "2024-12-15",
					"Room 101", 3, null, "Java Programming Textbook", null);

			insertCourse(conn, "Database Management", "Jane Doe", "Information Technology", "2024-10-01", "2024-12-30",
					"Room 102", 3, null, "Database Management Textbook", null);

			insertCourse(conn, "Web Development", "Michael Johnson", "Computer Science", "2024-11-15", "2025-03-15",
					"Room 103", 4, null, "Web Development Textbook", null);

			insertCourse(conn, "Data Structures", "Sarah Martinez", "Computer Science", "2024-09-15", "2024-12-30",
					"Room 104", 3, null, "Data Structures Textbook", null);

			insertCourse(conn, "Artificial Intelligence", "David Wilson", "Computer Science", "2025-01-10",
					"2025-05-10", "Room 105", 4, null, "Artificial Intelligence Textbook", null);

			insertCourse(conn, "Software Engineering", "Emily Brown", "Computer Science", "2024-10-15", "2025-02-28",
					"Room 106", 4, null, "Software Engineering Textbook", null);

			insertCourse(conn, "Network Security", "Michael Johnson", "Information Technology", "2024-11-01",
					"2025-04-01", "Room 107", 3, null, "Network Security Textbook", null);

			System.out.println("Course records inserted.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void createCourseTable(Connection conn) throws SQLException {
	    String dropSql = "DROP TABLE IF EXISTS course";
	    try (PreparedStatement dropPstmt = conn.prepareStatement(dropSql)) {
	        dropPstmt.executeUpdate();
	        System.out.println("Existing course table dropped successfully.");
	    }

	    String createSql = "CREATE TABLE course (" +
	            "course_id INT AUTO_INCREMENT PRIMARY KEY," +
	            "course_name VARCHAR(100)," +
	            "instructor VARCHAR(100)," +
	            "department VARCHAR(50)," +
	            "start_date DATE," +
	            "end_date DATE," +
	            "room_number VARCHAR(20)," +
	            "credits INT," +
	            "prerequisite_course VARCHAR(100)," +
	            "textbook VARCHAR(200)," +
	            "syllabus_url VARCHAR(200)" +
	            ")";
	    try (PreparedStatement createPstmt = conn.prepareStatement(createSql)) {
	        createPstmt.executeUpdate();
	        System.out.println("Course table created successfully.");
	    }
	}

	private static void insertCourse(Connection conn, String courseName, String instructor, String department,
			String startDate, String endDate, String roomNumber, int credits, String prerequisiteCourse,
			String textbook, String syllabusUrl) throws SQLException {
		String sql = "INSERT INTO course (course_name, instructor, department, start_date, end_date, "
				+ "room_number, credits, prerequisite_course, textbook, syllabus_url) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, courseName);
			pstmt.setString(2, instructor);
			pstmt.setString(3, department);
			pstmt.setString(4, startDate);
			pstmt.setString(5, endDate);
			pstmt.setString(6, roomNumber);
			pstmt.setInt(7, credits);
			pstmt.setString(8, prerequisiteCourse);
			pstmt.setString(9, textbook);
			pstmt.setString(10, syllabusUrl);
			pstmt.executeUpdate();
		}
	}
}
