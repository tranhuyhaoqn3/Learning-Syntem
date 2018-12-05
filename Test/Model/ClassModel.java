package Model;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.ClassDTO;
import DTO.ClassTestDTO;
import DTO.UserClassDTO;
import DataAccess.DataAccess;
import MyExtension.MyExtension;

public class ClassModel {
	
	public static ClassDTO GetClassByID(int iDClass) {
		ResultSet resultSet=null;
		try {
			Date date=new Date();
			resultSet=DataAccess.ExcuteQuery("Select * from class where ID=? And StartDate<=? And EndDate>=?"
											, iDClass,MyExtension.GetDateTimeNow(date),MyExtension.GetDateTimeNow(date));
			while (resultSet.next()) {
				
				ClassDTO classDTO= new ClassDTO(resultSet.getInt("ID"), resultSet.getString("FullName"), resultSet.getString("ShortName")
						, resultSet.getDate("StartDate"), resultSet.getDate("EndDate"), resultSet.getBoolean("Deleted"));
				//get bai kiem tra cua khoa hoc
				List<ClassTestDTO> classTestDTO=ClassTestModel.GetClassTestOfClass(classDTO.getiD());
				if (classTestDTO!=null&&classTestDTO.size()>0) {
					classDTO.setClassTestDTO(classTestDTO);
				}
				return classDTO;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
		
	}
	public static List<ClassDTO> GetClassOfUser(int idUser) {
		
		try {
			
			List<ClassDTO>classDTOs=new ArrayList<ClassDTO>();
			List<UserClassDTO>userClassDTOs=UserClassModel.GetClassOfUser(idUser);
			if (userClassDTOs!=null&&userClassDTOs.size()>0) {
				for (UserClassDTO userClassDTO : userClassDTOs) {
					ClassDTO classDTO=GetClassByID(userClassDTO.getiDClass());
					if (classDTO!=null) {
						classDTOs.add(classDTO);
					}
					
				}
			}
			return classDTOs;	
		} catch (Exception e) {
			return null;
		}
		
	}
}
