package DTO;

public class ChildtestQuestionDTO {
	public ChildtestQuestionDTO(int iDChildtest, int idQuestion) {
		super();
		this.iDChildtest = iDChildtest;
		this.idQuestion = idQuestion;
	}
	public int iDChildtest;
	public int idQuestion;
	public int getiDChildtest() {
		return iDChildtest;
	}
	public void setiDChildtest(int iDChildtest) {
		this.iDChildtest = iDChildtest;
	}
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
}
