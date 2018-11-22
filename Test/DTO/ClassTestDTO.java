package DTO;

public class ClassTestDTO {
	public ClassTestDTO(int iDClass, int iDTest, int examTime) {
		super();
		this.iDClass = iDClass;
		this.iDTest = iDTest;
		this.examTime = examTime;
	}
	private int iDClass;
	private int iDTest;
	private int examTime;
	public int getiDClass() {
		return iDClass;
	}
	public void setiDClass(int iDClass) {
		this.iDClass = iDClass;
	}
	public int getiDTest() {
		return iDTest;
	}
	public void setiDTest(int iDTest) {
		this.iDTest = iDTest;
	}
	public int getExamTime() {
		return examTime;
	}
	public void setExamTime(int examTime) {
		this.examTime = examTime;
	}
}
