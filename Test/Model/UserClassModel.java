package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.UserClassDTO;
import DataAccess.DataAccess;

public class UserClassModel {
	
	public static List<UserClassDTO> GetClassOfUser(int idUser) {
		ResultSet rSet;
		try {
			List<UserClassDTO>classDTOs=new ArrayList<UserClassDTO>();
			rSet = DataAccess.ExcuteQuery("Select * from user_class where IDUser=?", idUser);
			while(rSet.next()) {
				classDTOs.add(new UserClassDTO(rSet.getInt("IDUser"), rSet.getInt("IDClass")));
			}
			return classDTOs;
		} catch (Exception e) {
			return null;
		}
		
	}
}
