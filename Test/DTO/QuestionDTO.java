package DTO;

import java.util.List;

public class QuestionDTO {
	public QuestionDTO(int iD, String questionText, float score) {
		super();
		this.iD = iD;
		this.questionText = questionText;
		this.setScore(score);
	}
	private List<AnswerDTO>answerDTOs;
	private int iD;
	private String questionText;
	private float score;
	private int iDUserChoose;
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<AnswerDTO> getAnswerDTOs() {
		return answerDTOs;
	}
	public void setAnswerDTOs(List<AnswerDTO> answerDTOs) {
		this.answerDTOs = answerDTOs;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getiDUserChoose() {
		return iDUserChoose;
	}
	public void setiDUserChoose(int iDUserChoose) {
		this.iDUserChoose = iDUserChoose;
	}
}
