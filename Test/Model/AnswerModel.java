package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.AnswerDTO;
import DataAccess.DataAccess;

public class AnswerModel {
	public static List<AnswerDTO>GetAllAnswerOfQuestion(int iDQuestion){
		try {
			ResultSet resultSet=DataAccess.ExcuteQuery("Select * from answer where QuestionID=?", iDQuestion);
			List<AnswerDTO>answerDTOs=new ArrayList<AnswerDTO>();
			while (resultSet.next()) {
				answerDTOs.add(new AnswerDTO(resultSet.getInt("ID"), resultSet.getString("QuestionID")
						, resultSet.getString("Name"), resultSet.getBoolean("IsCorrect")));
			}
			return answerDTOs;
		} catch (Exception e) {
			return null;
		}
		
	}
}
