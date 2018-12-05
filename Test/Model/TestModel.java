package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.ClassTestDTO;
import DTO.TestDTO;
import DTO.UserChildtestDTO;
import DataAccess.DataAccess;


public class TestModel {
	
	public static List<TestDTO> GetAllTestOfClass(int iDClass) {
		ResultSet resultSet;
		List<TestDTO>testDTOs=null;
		try {
			List<ClassTestDTO>classTestDTOs=ClassTestModel.GetClassTestOfClass(iDClass);
			testDTOs=new ArrayList<TestDTO>();
			if (classTestDTOs!=null&&classTestDTOs.size()>0) {
				for (ClassTestDTO classTestDTO : classTestDTOs) {
					resultSet=DataAccess.ExcuteQuery("Select * from test where ID=?", classTestDTO.getiDTest());
				
					while(resultSet.next()) {
						TestDTO testDTO=new TestDTO(resultSet.getInt("ID"), resultSet.getString("Name")
								, resultSet.getString("Time"), resultSet.getInt("NumberQuestion")
								, resultSet.getTimestamp("TimeStart"), resultSet.getTimestamp("TimeEnd"));
						testDTO.setNumberExamTest(classTestDTO.getExamTime());
						testDTOs.add(testDTO);
						
					}
				}
			}
			return testDTOs;
			
		} catch (Exception e) {
			return null;
		}
	}
	public static List<TestDTO> GetAllTestOfClassHasTest(int iDClass){
		ResultSet resultSet;
		List<TestDTO>testDTOs=null;
		try {
			List<ClassTestDTO>classTestDTOs=ClassTestModel.GetAll(iDClass);
			testDTOs=new ArrayList<TestDTO>();
			if (classTestDTOs!=null&&classTestDTOs.size()>0) {
				for (ClassTestDTO classTestDTO : classTestDTOs) {
					resultSet=DataAccess.ExcuteQuery("Select * from test where ID=?", classTestDTO.getiDTest());
				
					while(resultSet.next()) {
						TestDTO testDTO=new TestDTO(resultSet.getInt("ID"), resultSet.getString("Name")
								, resultSet.getString("Time"), resultSet.getInt("NumberQuestion")
								, resultSet.getTimestamp("TimeStart"), resultSet.getTimestamp("TimeEnd"));
						testDTO.setNumberExamTest(classTestDTO.getExamTime());
						testDTOs.add(testDTO);
						
					}
				}
				
			}
			return testDTOs;
		} catch (Exception e) {
			return null;
		}
			
	}
	public static TestDTO GetTestById(int iDTest) {
		
		try {
			ResultSet resultSet=DataAccess.ExcuteQuery("Select * from test where ID=?", iDTest);
			while (resultSet.next()) {
				return new TestDTO(resultSet.getInt("ID"), resultSet.getString("Name")
						, resultSet.getString("Time"), resultSet.getInt("NumberQuestion"), resultSet.getTimestamp("TimeStart"), resultSet.getTimestamp("TimeEnd"));
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	public static List<TestDTO> GetAllTestOfClassAndUser(int iDClass,int iDUser) {
		ResultSet resultSet;
		List<TestDTO>testDTOs=GetAllTestOfClassHasTest(iDClass);
		try {
			if (testDTOs!=null&&testDTOs.size()>0) {
				for (TestDTO testDTO : testDTOs) {
					List<UserChildtestDTO>userChildtestDTOs=UserChildTestModel.GetUserChildTestOfUserAndTest(iDUser,testDTO.getiD());
					if (userChildtestDTOs!=null) {
						testDTO.setNumberUserExcuteTest(userChildtestDTOs.size());
					}
				}
			}
			return testDTOs;
			
		} catch (Exception e) {
			return null;
		}
	}
	public static TestDTO GetTestOfUserNotFinished(int iDUser) {
		ResultSet resultSet;
		try {
			UserChildtestDTO userChildtestDTO=UserChildTestModel.GetUserChildTestOfUserNotFinish(iDUser);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}
}
