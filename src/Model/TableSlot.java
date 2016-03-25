package Model;



public class TableSlot {

	private Model.Class mClass;
	private Course mCourse;
	private Teacher mTeacher;
	private int time;
	private String day;
	
	public TableSlot(String d ,int t) {
		this.day = d;
		this.time = t;
	}
	
	public void setmClass(Model.Class mClass) {
		this.mClass = mClass;
	}
	
	public void setmCourse(Course mCourse) {
		this.mCourse = mCourse;
	}
	
	public void setmTeacher(Teacher mTeacher) {
		this.mTeacher = mTeacher;
	}
	
	public Model.Class getmClass() {
		return mClass;
	}
	
	public Teacher getmTeacher() {
		return mTeacher;
	}
	
	public Course getmCourse() {
		return mCourse;
	}
	
	public String getDay() {
		return day;
	}
	
	public int getTime() {
		return time;
	}
	
	
	@Override
	public String toString() {
		
		String text = day+" - "+String.valueOf(time)+" ";
		
		try {
			text += mClass.toString()+" "+mCourse.toString()+" "+mTeacher.toString();
		} catch (NullPointerException e) {
			
		}
		
		return text;
	}
	
	public String toString2() {
		
		String text = "";
		
		try {
			text += mCourse.toString()+" "+mTeacher.toString();
		} catch (NullPointerException e) {
			
		}
		
		return text;
	}
}
