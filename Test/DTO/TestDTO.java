package DTO;

import java.util.Date;
import java.util.List;

public class TestDTO {
	public TestDTO(int iD, String name, String time, int numberQuestion, Date timeStart, Date timeEnd) {
		super();
		this.iD = iD;
		this.name = name;
		this.time = time;
		this.numberQuestion = numberQuestion;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	private int iD;
	private String name;
	private String time;
	private int numberQuestion;
	private Date timeStart;
	private Date timeEnd;
	private int numberExamTest;
	private int numberUserExcuteTest;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getNumberQuestion() {
		return numberQuestion;
	}
	public void setNumberQuestion(int numberQuestion) {
		this.numberQuestion = numberQuestion;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public int getNumberExamTest() {
		return numberExamTest;
	}
	public void setNumberExamTest(int numberExamTest) {
		this.numberExamTest = numberExamTest;
	}
	public int getNumberUserExcuteTest() {
		return numberUserExcuteTest;
	}
	public void setNumberUserExcuteTest(int numberUserExcuteTest) {
		this.numberUserExcuteTest = numberUserExcuteTest;
	}

}
