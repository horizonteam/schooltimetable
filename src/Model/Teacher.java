package Model;
public class Teacher {

	private int id;
	private String name;
	private String lastname;
	private String fullname;
	
	public Teacher(String name,String lname) {
		this.setName(name);
		this.setLastname(lname);
		
		this.fullname = name+" "+lname;
	}
	
	@Override
	public String toString() {
		return fullname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
