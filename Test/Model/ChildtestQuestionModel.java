package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.ChildtestQuestionDTO;
import DataAccess.DataAccess;

public class ChildtestQuestionModel {
	public static List<ChildtestQuestionDTO>GetAllByIDChildTest(int iDChildTest){
		
		ResultSet resultSet;
		try {
			List<ChildtestQuestionDTO>childtestQuestionDTOs=new ArrayList<ChildtestQuestionDTO>();
			resultSet=DataAccess.ExcuteQuery("Select * from childtest_question where IDChildTest=?", iDChildTest);
			while (resultSet.next()) {
				childtestQuestionDTOs.add(new ChildtestQuestionDTO(resultSet.getInt("IDChildTest"), resultSet.getInt("IdQuestion")));
			}
			return childtestQuestionDTOs;
		} catch (Exception e) {
			return null;
		}
	}
}
