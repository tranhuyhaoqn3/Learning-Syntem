package DTO;

public class ChildTestDTO {
	public ChildTestDTO(int iD, String name, int iDTest) {
		super();
		this.iD = iD;
		this.name = name;
		this.iDTest = iDTest;
	}
	private int iD;
	private String name;
	private int iDTest;
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getiDTest() {
		return iDTest;
	}
	public void setiDTest(int iDTest) {
		this.iDTest = iDTest;
	}
}
