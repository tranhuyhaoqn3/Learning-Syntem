package DTO;

public class Subject {

	private int iD;
	private String name;
	private int count;
	public int getID() {
		return iD;
	}
	
	public void setID(int iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public Subject(int iD,String name,int count) {
		this.iD = iD;
		this.name = name;
		this.count = count;
	}
	public Subject(int iD,String name) {
		this.iD = iD;
		this.name = name;
	}
	public Subject() {
		
	}
}
