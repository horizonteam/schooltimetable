package Model;
public class Course {

	private String department_code;
	private int courseNumber;
	private int hour;
	private String fullname;
	private Teacher teacher;
	private Class classroom;

	public Course(String dept,int number,int hr) {
		
		this.department_code = dept;
		this.courseNumber = number;
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
		// TODO Auto-generated method stub
		return fullname;
	}
	
	public String toString1() throws NullPointerException{
		// TODO Auto-generated method stub
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
}
