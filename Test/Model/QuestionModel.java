package Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Answer;
import DTO.Question;
import DataAccess.DataAccess;;
public class QuestionModel {

	private AnswerModel answerModel;
	public QuestionModel() {
		answerModel = new AnswerModel();
		
	}
	public ArrayList<Question> getBySubject(int subjectId){
		ArrayList<Question> questions  = new ArrayList<>();
		ResultSet rSet;
		try {
			rSet = DataAccess.ExcuteQuery("SELECT * FROM question WHERE SubjectID = ? ",subjectId);
			while(rSet.next()) {
				ArrayList<Answer> answers = answerModel.getByQuestionId(rSet.getInt("ID"));
				questions.add(new Question(rSet.getInt("ID"),rSet.getString("QuestionText"),rSet.getFloat("Score"),rSet.getInt("SubjectID"),answers));
			}
			return questions;
		} catch (SQLException e) {
			return null;
		}
	}
	public int Add(Question question) {
		try {
			int rs = -1;
			rs = DataAccess.ExcuteNonQuery("INSERT INTO question (`QuestionText`,`Score`,`SubjectID`) VALUES(?,?,?)", question.getQuestionText(),question.getScore(),question.getSubjectID());
			return rs;
		} catch (SQLException e) {
			return -1;
		}
	}
	public int Edit(Question question) {
		try {
			int rs = -1;
			rs = DataAccess.ExcuteNonQuery("UPDATE question SET `QuestionText` = ? WHERE `ID` = ?",question.getQuestionText(),question.getID());
			return rs;
		} catch (SQLException e) {
			return -1;
		}
	}
	public int Delete(int questionId) {
		try {
			int rs = -1;
			rs = DataAccess.ExcuteNonQuery("DELETE FROM question WHERE ID = ?",questionId);
			return rs;
		} catch (SQLException e) {
			return -1;
		}
	} 
	

}
