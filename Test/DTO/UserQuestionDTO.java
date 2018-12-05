package DTO;

public class UserQuestionDTO {
	public UserQuestionDTO(int iDUser, int iDQuestion, int iDChildtest, int iDAnswer) {
		super();
		this.iDUser = iDUser;
		this.iDQuestion = iDQuestion;
		this.iDChildtest = iDChildtest;
		this.iDAnswer = iDAnswer;
	}
	private int iDUser;
	private int iDQuestion;
	private int iDChildtest;
	private int iDAnswer;
	public int getiDUser() {
		return iDUser;
	}
	public void setiDUser(int iDUser) {
		this.iDUser = iDUser;
	}
	public int getiDQuestion() {
		return iDQuestion;
	}
	public void setiDQuestion(int iDQuestion) {
		this.iDQuestion = iDQuestion;
	}
	public int getiDChildtest() {
		return iDChildtest;
	}
	public void setiDChildtest(int iDChildtest) {
		this.iDChildtest = iDChildtest;
	}
	public int getiDAnswer() {
		return iDAnswer;
	}
	public void setiDAnswer(int iDAnswer) {
		this.iDAnswer = iDAnswer;
	}
}
