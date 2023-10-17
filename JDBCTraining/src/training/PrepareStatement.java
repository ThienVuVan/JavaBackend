package training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatement {
	public static void main(String[] args) {
		String sql = "insert into course value(?,?,?)";
		try (Connection conn = DatabaseUtils.getConnection();
			PreparedStatement preStm = conn.prepareStatement(sql);){
			conn.setAutoCommit(false);
			preStm.setInt(1, 5);
			preStm.setString(2, "javaCore");
			preStm.setFloat(3, 50f);
			preStm.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
