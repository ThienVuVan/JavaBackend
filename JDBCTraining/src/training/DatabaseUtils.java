package training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrainingDB_new",
															"root", "");
			return conn;										
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
