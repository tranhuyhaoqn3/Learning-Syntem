package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {
	
	@JsonProperty("answerID")
	private int iD;
	@JsonProperty("answerText")
	private String name;
	private int questionID;
	@JsonProperty("isCorrect")
	private boolean isCorrect;
	private boolean deleted;
	
	public Answer(int id, String name, int questionId, boolean iscorrect) {
		this.iD = id;
		this.name = name;
		this.questionID = questionId;
		this.isCorrect = iscorrect;
	}
	public Answer() {
		
	}
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

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	

}
