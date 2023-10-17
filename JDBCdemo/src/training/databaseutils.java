package training;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseutils {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrainingDB_new","root","");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
