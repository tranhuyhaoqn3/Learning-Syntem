package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Answer;
import DataAccess.DataAccess;

public class AnswerModel {

	public AnswerModel() {
	}
	public ArrayList<Answer> getByQuestionId(int questionId){
		ArrayList<Answer> answers  = new ArrayList<>();
		ResultSet rSet;
		try {
			rSet = DataAccess.ExcuteQuery("SELECT * FROM answer WHERE QuestionID = ? ",questionId);
			while(rSet.next()) {
				answers.add(new Answer(rSet.getInt("ID"),rSet.getString("Name"),rSet.getInt("QuestionID"),rSet.getBoolean("IsCorrect")));
			}
			return answers;
		} catch (SQLException e) {
			return null;
		}
	}
	public int Add(Answer answer) {
		try {
			int rs = -1;
			rs = DataAccess.ExcuteNonQuery("INSERT INTO answer (`QuestionID`,`Name`,`IsCorrect`) VALUES(?,?,?)", answer.getQuestionID(),answer.getName(),answer.isCorrect());
			return rs;
		} catch (SQLException e) {
			return -1;
		}
	}
	public int Edit(Answer answer) {
		try {
			int rs = -1;
			rs = DataAccess.ExcuteNonQuery("UPDATE answer SET `Name` = ?,`IsCorrect` = ? WHERE `ID` = ?",answer.getName(),answer.isCorrect(),answer.getID());
			return rs;
		} catch (SQLException e) {
			return -1;
		}
	}
	public int Delete(Answer answer) {
		try {
			int rs = -1;
			rs = DataAccess.ExcuteNonQuery("DELETE FROM answer WHERE ID = ?",answer.getID());
			return rs;
		} catch (SQLException e) {
			return -1;
		}
	} 

}
