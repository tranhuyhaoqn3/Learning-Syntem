package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.ClassTestDTO;
import DataAccess.DataAccess;
import MyExtension.MyExtension;

public class ClassTestModel {
	public static List<ClassTestDTO> GetAll(int iDClass){
		ResultSet resultSet;
		List<ClassTestDTO>classTestDTOs=new ArrayList<ClassTestDTO>();
		try {
			resultSet=DataAccess.ExcuteQuery("SELECT * FROM class_test,test WHERE IDClass=? AND IDTest=test.`ID` ", iDClass);
			while (resultSet.next()) {
				classTestDTOs.add(new ClassTestDTO(resultSet.getInt("IDClass"), resultSet.getInt("IDTest"), resultSet.getInt("ExamTime")));
			}
			return classTestDTOs;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static List<ClassTestDTO> GetClassTestOfClass(int iDClass) {
		ResultSet resultSet;
		List<ClassTestDTO>classTestDTOs=new ArrayList<ClassTestDTO>();
		try {
			Date date=new Date();
			resultSet=DataAccess.ExcuteQuery("SELECT * FROM class_test,test\r\n" + 
											"WHERE IDClass=? AND IDTest=test.`ID`"
											+ "And TimeStart<=? And TimeEnd>=?"
											, iDClass,MyExtension.GetDateTimeNow(date),MyExtension.GetDateTimeNow(date));
			while (resultSet.next()) {
				classTestDTOs.add(new ClassTestDTO(resultSet.getInt("IDClass"), resultSet.getInt("IDTest"), resultSet.getInt("ExamTime")));
			}
			return classTestDTOs;
		} catch (Exception e) {
			return null;
		}
	}
}
