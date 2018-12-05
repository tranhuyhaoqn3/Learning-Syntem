package DTO;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Question {
	@JsonProperty("questionID")
	private int iD;
	private String questionText;
	private float score;
	private int subjectID;
	@JsonProperty("answer")
	private ArrayList<Answer> answers;
	public Question(int id, String questionText, float score , int subjectID,ArrayList<Answer> answers) {
		this.iD = id;
		this.questionText = questionText;
		this.score = score;
		this.subjectID = subjectID;
		this.answers = answers;
	}
	public Question() {
		
	}
	public int getID() {
		return iD;
	}
	public void setID(int iD) {
		this.iD = iD;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
}
