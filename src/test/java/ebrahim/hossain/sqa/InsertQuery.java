package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class InsertQuery {

	@Test
	public void insertStudentRecords() {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "root";

		// Sample student data for insertion
		String[][] studentData = {
				{ "John", "Doe", "22", "Male", "123 Main St", "Anytown", "CA", "USA", "john@example.com",
						"123-456-7890", "2022-01-01", "2025-05-01", "Computer Science", "Computer Engineering", null,
						"3.8", "120", "Dr. Smith", "Data Analytics" },
				{ "Jane", "Smith", "21", "Female", "456 Elm St", "Othertown", "NY", "USA", "jane@example.com",
						"987-654-3210", "2022-02-15", "2025-06-15", "Electrical Engineering", "Computer Science", null,
						"3.5", "110", "Dr. Johnson", "Machine Learning" },
				{ "Michael", "Johnson", "23", "Male", "789 Oak St", "Somewhere", "TX", "USA", "michael@example.com",
						"456-789-0123", "2021-12-20", "2024-12-20", "Biology", "Chemistry", null, "3.2", "100",
						"Dr. Brown", "Genetics" },
				{ "Emily", "Brown", "20", "Female", "321 Pine St", "Nowhere", "FL", "USA", "emily@example.com",
						"789-012-3456", "2023-03-10", "2026-07-10", "Mathematics", "Statistics", null, "3.9", "130",
						"Dr. Wilson", "Data Science" },
				{ "David", "Wilson", "24", "Male", "654 Cedar St", "Everywhere", "WA", "USA", "david@example.com",
						"012-345-6789", "2021-11-05", "2024-11-05", "Physics", "Astronomy", null, "3.6", "115",
						"Dr. Martinez", "Astrophysics" },
				{ "Sarah", "Martinez", "22", "Female", "987 Maple St", "Noway", "OR", "USA", "sarah@example.com",
						"345-678-9012", "2022-09-30", "2025-09-30", "Environmental Science", "Geology", null, "3.4",
						"105", "Dr. Lee", "Climate Change" },
				{ "Alex", "Kim", "23", "Male", "111 Oak St", "Anytown", "CA", "USA", "alex@example.com", "111-222-3333",
						"2021-10-15", "2024-10-15", "Computer Science", "Information Technology", null, "3.7", "125",
						"Dr. White", "Cybersecurity" },
				{ "Olivia", "Lee", "21", "Female", "222 Elm St", "Othertown", "NY", "USA", "olivia@example.com",
						"222-333-4444", "2022-03-20", "2025-03-20", "Electrical Engineering", "Computer Engineering",
						null, "3.6", "115", "Dr. Green", "Robotics" },
				{ "Daniel", "Taylor", "24", "Male", "333 Maple St", "Somewhere", "TX", "USA", "daniel@example.com",
						"333-444-5555", "2021-09-10", "2024-09-10", "Biology", "Neuroscience", null, "3.9", "130",
						"Dr. Adams", "Brain Research" },
				{ "Sophia", "Clark", "20", "Female", "444 Pine St", "Nowhere", "FL", "USA", "sophia@example.com",
						"444-555-6666", "2023-02-05", "2026-06-05", "Mathematics", "Applied Mathematics", null, "3.5",
						"110", "Dr. Turner", "Mathematical Modeling" },
				{ "Ethan", "Brown", "22", "Male", "555 Cedar St", "Everywhere", "WA", "USA", "ethan@example.com",
						"555-666-7777", "2022-11-30", "2025-11-30", "Physics", "Quantum Physics", null, "3.8", "120",
						"Dr. Harris", "Particle Physics" },
				{ "Ava", "Garcia", "21", "Female", "666 Oak St", "Noway", "OR", "USA", "ava@example.com",
						"666-777-8888", "2022-08-15", "2025-08-15", "Environmental Science", "Ecology", null, "3.3",
						"100", "Dr. Baker", "Biodiversity Conservation" },
				{ "William", "Rivera", "23", "Male", "777 Elm St", "Anytown", "CA", "USA", "william@example.com",
						"777-888-9999", "2021-07-20", "2024-07-20", "Computer Science", "Software Engineering", null,
						"3.4", "105", "Dr. Wright", "Web Development" },
				{ "Mia", "Lopez", "22", "Female", "888 Maple St", "Othertown", "NY", "USA", "mia@example.com",
						"888-999-0000", "2022-05-10", "2025-05-10", "Electrical Engineering", "Power Systems", null,
						"3.7", "125", "Dr. Fisher", "Renewable Energy" },
				{ "James", "Perez", "24", "Male", "999 Pine St", "Somewhere", "TX", "USA", "james@example.com",
						"999-000-1111", "2021-04-05", "2024-04-05", "Biology", "Genetics", null, "3.6", "115",
						"Dr. Murphy", "DNA Sequencing" },
				{ "Charlotte", "Ward", "20", "Female", "123 Elm St", "Nowhere", "FL", "USA", "charlotte@example.com",
						"123-456-7890", "2023-01-30", "2026-05-30", "Mathematics", "Statistics", null, "3.9", "130",
						"Dr. King", "Statistical Analysis" } };

		String insertSql = "INSERT INTO student (first_name, last_name, age, gender, address, city, state, country, email, phone_number, enrollment_date, graduation_date, department, major, minor, gpa, credits_completed, advisor, thesis_topic) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(url, userName, password);
				PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
			for (String[] data : studentData) {
				pstmt.setString(1, data[0]); // first_name
				pstmt.setString(2, data[1]); // last_name
				pstmt.setInt(3, Integer.parseInt(data[2])); // age
				pstmt.setString(4, data[3]); // gender
				pstmt.setString(5, data[4]); // address
				pstmt.setString(6, data[5]); // city
				pstmt.setString(7, data[6]); // state
				pstmt.setString(8, data[7]); // country
				pstmt.setString(9, data[8]); // email
				pstmt.setString(10, data[9]); // phone_number
				pstmt.setString(11, data[10]); // enrollment_date
				pstmt.setString(12, data[11]); // graduation_date
				pstmt.setString(13, data[12]); // department
				pstmt.setString(14, data[13]); // major
				pstmt.setString(15, data[14]); // minor
				pstmt.setDouble(16, Double.parseDouble(data[15])); // gpa
				pstmt.setInt(17, Integer.parseInt(data[16])); // credits_completed
				pstmt.setString(18, data[17]); // advisor
				pstmt.setString(19, data[18]); // thesis_topic

				pstmt.executeUpdate(); // Execute insert
			}
			System.out.println("Student records inserted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
