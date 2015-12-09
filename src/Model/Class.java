package Model;
public class Class {

	private int id;
	private String block_code;
	private int classNumber;
	private String fullname;
	
	public Class(String block, int number) {
		
		this.block_code = block;
		this.classNumber = number;
		
		this.fullname = block + String.valueOf(number);
	}
	
	@Override
	public String toString() {
		return fullname;
	}
}