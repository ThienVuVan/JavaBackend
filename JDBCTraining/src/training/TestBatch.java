package training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class TestBatch {
	
	public static boolean saveBatch(List<Course> courses) {
		String sql = "insert into course value(?,?,?)";
		int[] result = null;
		try (Connection conn = DatabaseUtils.getConnection();
			 PreparedStatement preStm = conn.prepareStatement(sql);) {
			conn.setAutoCommit(false);
			for(Course course : courses) {
				preStm.setInt(1, course.getId());
				preStm.setString(2, course.getTitle());
				preStm.setFloat(3, course.getPrice());
				
				preStm.addBatch();
			}
			result = preStm.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result.length);
		return (result.length == courses.size());
	}
	
	public static void main(String[] args) {
		Course course1 = new Course(7,"CPP",23.6f);
		Course course2 = new Course(8,"RUBY",9.6f);
		
		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		
		boolean resultSave = saveBatch(courses);
		System.out.println(resultSave);
	}
}
