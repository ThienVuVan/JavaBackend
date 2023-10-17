package training;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestConect {
	
	public static void main(String[] args) throws SQLException {
		try(Connection con = DatabaseUtils.getConnection();
			Statement stm = con.createStatement();){
			ResultSet rs = stm.executeQuery("select course_id, title from course");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " - " + rs.getString(2));
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
