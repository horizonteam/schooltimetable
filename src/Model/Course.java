package Model;
public class Course {

	private String department_code;
	private int courseNumber;
	private int hour;
	private String fullname;
	private Teacher teacher;
	private Class classroom;

	public Course(String dept,int number,int hr) {
		
		this.setDepartment_code(dept);
		this.setCourseNumber(number);
		this.hour=hr;
		
		this.fullname = dept +" "+number;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void setClassroom(Class classroom) {
		this.classroom = classroom;
	}
	
	@Override
	public String toString() {
		
		return fullname;
	}
	
	public String toString1() throws NullPointerException{
		
		return fullname+"/"+teacher.toString();
	}

	public int getHour() {
		return hour;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public Class getClassroom() {
		return classroom;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getDepartment_code() {
		return department_code;
	}

	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}
}
