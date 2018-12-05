package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import DTO.UserChildtestDTO;
import DataAccess.DataAccess;
import MyExtension.MyExtension;

public class UserChildTestModel {
	public static List<UserChildtestDTO>GetUserChildTestOfUser(int idUser){
		try {
			ResultSet resultSet=DataAccess.ExcuteQuery("Select * from user_childtest where IDUser=?", idUser);
			List<UserChildtestDTO>userChildtestDTOs=new ArrayList<UserChildtestDTO>();
			while (resultSet.next()) {
				userChildtestDTOs.add(new UserChildtestDTO(resultSet.getInt("IDUser")
						, resultSet.getInt("IDChildTest"), resultSet.getFloat("Score")
						, resultSet.getTimestamp("TimeStart"), resultSet.getTimestamp("TimeEnd")));
				
			}
			return userChildtestDTOs;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	public static UserChildtestDTO CheckUserChildTestExcute(int iDUser,int iDChildTest) {
		try {
			ResultSet resultSet=DataAccess.ExcuteQuery("Select * from user_childtest where IDUser=? And IDChildTest=?", iDUser,iDChildTest);
			while (resultSet.next()) {
				return new UserChildtestDTO(resultSet.getInt("IDUser")
						, resultSet.getInt("IDChildTest"), resultSet.getFloat("Score")
						, resultSet.getTimestamp("TimeStart"), resultSet.getTimestamp("TimeEnd"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return null;
	}

	public static List<UserChildtestDTO> GetUserChildTestOfUserAndTest(int iDUser, int iDTest) {
		try {
			String query="SELECT * FROM user_childtest,test,`childtest` \r\n" + 
					"WHERE IDUser=? AND `test`.`ID`=? AND `user_childtest`.`IDChildTest`=`childtest`.`ID` "
					+ "AND `childtest`.`IDTest`=`test`.`ID`";
			ResultSet resultSet=DataAccess.ExcuteQuery(query, iDUser,iDTest);
			List<UserChildtestDTO>userChildtestDTOs=new ArrayList<UserChildtestDTO>();
			while (resultSet.next()) {
				userChildtestDTOs.add(new UserChildtestDTO(resultSet.getInt("IDUser")
						, resultSet.getInt("IDChildTest"), resultSet.getFloat("Score")
						, resultSet.getTimestamp("TimeStart"), resultSet.getTimestamp("TimeEnd")));
			}
			return userChildtestDTOs;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public static UserChildtestDTO GetUserChildTestOfUserNotFinish(int iDUser) {
		String query="Select * from user_childtest where IDUser=? And TimeEnd IS Null";
		try {
			ResultSet resultSet=DataAccess.ExcuteQuery(query, iDUser);
			while (resultSet.next()) {
				return new UserChildtestDTO(resultSet.getInt("IDUser")
						, resultSet.getInt("IDChildTest"), resultSet.getFloat("Score")
						, resultSet.getTimestamp("TimeStart"), resultSet.getTimestamp("TimeEnd"));
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	public static int UpdateTimeStart(int iDUser, int iDChildtest) {
		try {
			 return DataAccess.ExcuteNonQuery("Update user_childtest Set TimeStart=? where IDUser=? And IDChildtest=?"
								, MyExtension.GetDateTimeNow(),iDUser,iDChildtest);
		} catch (Exception e) {
			return -1;
		}
		
	}
	public static int Add(int iDUser, int iDChildtest) {
		try {
			String query="INSERT INTO user_childtest (`IDUser`,`IDChildTest`,`Score`,`TimeStart`)\r\n" + 
													"VALUES(?,?,?,?)";
			return DataAccess.ExcuteNonQuery(query, iDUser,iDChildtest,0,MyExtension.GetDateTimeNow());
		} catch (Exception e) {
			return -1;
		}
	}
	public static int UpdateTimeEnd(int iDUser, int iDChildtest) {
		try {
			return DataAccess.ExcuteNonQuery("{CALL CountScoreUser(?,?,?)}"
											,iDChildtest,iDUser,MyExtension.GetDateTimeNow());
		} catch (Exception e) {
			return -1;
		}
		
	}

}
