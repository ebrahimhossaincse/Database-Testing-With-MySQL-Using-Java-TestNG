package ebrahim.hossain.sqa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SelectDistinct {
	
	@Test
	public void selectDistinct() {
        String url = "jdbc:mysql://localhost:3306/test";
        String userName = "root";
        String password = "root";
        String columnName = "department";

        String selectSql = "SELECT DISTINCT " + columnName + " FROM student";

        try (Connection conn = DriverManager.getConnection(url, userName, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSql)) {

            // Print the distinct values retrieved from the department column
            System.out.println("Distinct Departments:");
            System.out.println("--------------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getString(columnName));
            }
            System.out.println("--------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
