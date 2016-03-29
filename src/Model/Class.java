package Model;
public class Class {

	private int id;
	private String block_code;
	private int classNumber;
	private String fullname;
	
	public Class(String block, int number) {
		
		this.setBlock_code(block);
		this.setClassNumber(number);
		
		this.fullname = block + String.valueOf(number);
	}
	
	@Override
	public String toString() {
		return fullname;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public String getBlock_code() {
		return block_code;
	}

	public void setBlock_code(String block_code) {
		this.block_code = block_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}