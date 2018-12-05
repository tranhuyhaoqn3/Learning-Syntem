package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.UserQuestionDTO;
import DataAccess.DataAccess;

public class UserQuestionModel {
	
	public static UserQuestionDTO GetUserChildTestByIDUserQuestionChildtest
	(int iDUser,int iDChildtest, int iDQuestion) {
		try {
			ResultSet resultSet;
			resultSet=DataAccess.ExcuteQuery("Select * from user_question where IDUser=? And IDQuestion=? And IDChildtest=?"
											, iDUser,iDQuestion,iDChildtest);
			while (resultSet.next()) {
				return new UserQuestionDTO(resultSet.getInt("IDUser"), resultSet.getInt("IDQuestion")
										,resultSet.getInt("IDChildtest"), resultSet.getInt("IDAnswer"));
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public static int Update(int iDuser, int iDQuestion, int iDChiltest, int iDAnswer) {
		try {
			String query="UPDATE user_question\r\n" + 
					"SET IDAnswer=?\r\n" + 
					"WHERE IDuser=? And IDQuestion=? And IDChildtest=?";
			return DataAccess.ExcuteNonQuery(query, iDAnswer,iDuser,iDQuestion,iDChiltest);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static int Insert(int iDUser, int iDQuestion, int iDChiltest, int iDAnswer) {
		try {
			String query="INSERT INTO user_question\r\n" + 
					"(IDUser,IDQuestion,IDChildtest,IDAnswer)\r\n" + 
					"VALUES (?,?,?,?)";
			return DataAccess.ExcuteNonQuery(query, iDUser,iDQuestion,iDChiltest,iDAnswer);
		} catch (Exception e) {
			return -1;
		}
		
	}
	public static List<UserQuestionDTO>GetAllUserQuestionOfUserAndChildtest(int iDUser,int iDChildtest){
		try {
			ResultSet resultSet;
			resultSet=DataAccess.ExcuteQuery("Select * from user_question where IDUser=? And IDChildtest=?", iDUser,iDChildtest);
			List<UserQuestionDTO>userQuestionDTOs=new ArrayList<UserQuestionDTO>();
			while (resultSet.next()) {
				userQuestionDTOs.add(new UserQuestionDTO(resultSet.getInt("IDUser"),
									resultSet.getInt("IDQuestion"),
									resultSet.getInt("IDChildtest"), resultSet.getInt("IDAnswer")));
			}
			return userQuestionDTOs;
		} catch (Exception e) {
			return null;
		}
	}


}
