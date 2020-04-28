package transfer_object;

public class Attending {
	private int id;
	private int courseId;
	private int studentId;
	
	public Attending(int id, int courseId, int studentId) {
		this.id = id;
		this.courseId = courseId;
		this.studentId = studentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getcourseId() {
		return courseId;
	}
	public void setcourseId(int courseId) {
		this.courseId = courseId;
	}
	public double getstudentId() {
		return studentId;
	}
	public void setstudentId(int studentId) {
		this.studentId = studentId;
	}
}
