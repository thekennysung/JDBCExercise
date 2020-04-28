package data_access_object;

import java.sql.DriverManager;
import java.util.ArrayList;
import connection.OracleConnection;
import transfer_object.Course;
import transfer_object.Student;

public class StudentDAO extends OracleConnection {
	public void registerStudentToCourse(Course c, Student s) {
		// This method registers a specific Student to a Course on the database
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Connectig the database...");
//			con = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Inserting the values...");
			st = con.createStatement();
			String sql = "INSERT ALL "
					+ "INTO ATTENDING (attending_id,course_id,student_id) values (4, 3, 1)"
					+ "INTO ATTENDING (attending_id,course_id,student_id) values (4, 3, 1)"
					+ "INTO TEST_Registration (id,age,first,last) values (102, 33, 'Babe', 'Ruth')"
					+ "INTO TEST_Registration (id,age,first,last) values (103, 40, 'Wayne', 'Gretzky')"
					+ "INTO TEST_Registration (id,age,first,last) values (104, 27, 'Michelle', 'Kwan')"
					+ "INTO TEST_Registration (id,age,first,last) values (105, 35, 'Steffi', 'Graf')"
					+ "SELECT 1 FROM DUAL";
			st.executeUpdate(sql);
			System.out.println("Values inserted successfully...");
			con.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}	
	}
	
	public ArrayList<Course> getAllCoursesForStudent(Student s) {
		ArrayList<Course> courses = new ArrayList<Course>();
		// This method will populate the List of Courses in the Student Object related to the student in the database.
		return courses;
	}
	
	public void insertStudent(Student s) throws Exception {
		dbConnection();
		ps = con.prepareStatement(resource.myQuries.insertStudent);
		ps.setInt(1, s.getId());
		ps.setString(2, s.getName());
		ps.setString(3, s.getEmail());
		ps.setDouble(4, s.getGpa());
		ps.setString(5, s.getPassword());
		ps.setInt(6, s.getRole());
		
		ps.executeUpdate();
	}
	
	public Student getStudentById(int id) throws Exception {
		dbConnection();
		ps = con.prepareStatement(resource.myQuries.getStudentById);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		rs.next();
		Student s = new Student(id, rs.getString("full_name"), rs.getString("email"), rs.getDouble("gpa"), rs.getString("pass"), rs.getInt("student_role"));
		return s;
	}
}
