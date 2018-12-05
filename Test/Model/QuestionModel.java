package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.AnswerDTO;
import DTO.ChildTestDTO;
import DTO.ChildtestQuestionDTO;
import DTO.QuestionDTO;
import DataAccess.DataAccess;

public class QuestionModel {
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
}
