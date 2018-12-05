package DTO;

public class AnswerDTO {
	public AnswerDTO(int iD, String questionID, String name, boolean isCorrect) {
		super();
		this.iD = iD;
		this.questionID = questionID;
		this.name = name;
		this.isCorrect = isCorrect;
	}
	private int iD;
	private String questionID;
	private String name;
	private boolean isCorrect;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getQuestionID() {
		return questionID;
	}
	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public boolean isCorrect() {
		return isCorrect;
	}

}
