package training;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testconnect {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stm = null;
		String sql = "select course_id, title from course";
		try {
			con = databaseutils.getConnection();
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " - " + rs.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(stm != null) {
				stm.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
}
