package Model;
public class Teacher {

	private int id;
	private String name;
	private String lastname;
	private String fullname;
	
	public Teacher(String name,String lname) {
		this.name = name;
		this.lastname = lname;
		
		this.fullname = name+" "+lname;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fullname;
	}
}
