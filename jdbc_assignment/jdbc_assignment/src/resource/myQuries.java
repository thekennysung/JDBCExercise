package resource;

public class myQuries {
	public final static String insertStudent = "insert into student values (?, ?, ?, ?, ?, ?)";
	public final static String getStudentById = "select * from student where student_id = ?";
	
	public final static String insertCourse = "insert into course values (?, ?, ?)";
	public final static String getCourseById = "select * from course where course_id = ?";
}
