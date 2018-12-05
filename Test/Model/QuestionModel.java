package Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Answer;
import DTO.ChildtestQuestionDTO;
import DTO.Question;
import DTO.QuestionDTO;
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
	public static QuestionDTO GetQuestionByID(int iDQuestion) {
		try {
			ResultSet resultSet = DataAccess.ExcuteQuery("Select * from question where ID=?", iDQuestion);
			while (resultSet.next()) {
				QuestionDTO questionDTO = new QuestionDTO(resultSet.getInt("ID"),
						resultSet.getString("QuestionText"), resultSet.getFloat("Score"));
				questionDTO.setAnswerDTOs(AnswerModel.GetAllAnswerOfQuestion(questionDTO.getiD()));
				return questionDTO;
			}
		} catch (Exception e) {
			return null;
		}
		return null;

	}
	public static List<QuestionDTO> GetAllQuestionOfUserAndChildTest(int iDUser, int iDChiltest) {
		List<QuestionDTO> questionDTOs = null;
		questionDTOs = new ArrayList<QuestionDTO>();
		List<ChildtestQuestionDTO> childtestQuestionDTOs = ChildtestQuestionModel
				.GetAllByIDChildTest(iDChiltest);
		if (childtestQuestionDTOs != null && childtestQuestionDTOs.size() > 0) {
			for (ChildtestQuestionDTO childtestQuestionDTO : childtestQuestionDTOs) {
				questionDTOs.add(GetQuestionByID(childtestQuestionDTO.getIdQuestion()));
			}
		}

		return questionDTOs;

	}
}
