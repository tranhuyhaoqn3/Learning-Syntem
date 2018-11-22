package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.UserDTO;
import DataAccess.DataAccess;

public class UserModel {
	public static UserDTO GetUserByID (int idUser) {
	
		ResultSet rSet;
		try {
			rSet = DataAccess.ExcuteQuery("Select * from user where Id=?", idUser);
			while(rSet.next()) {
				return new UserDTO(rSet.getInt("ID"),rSet.getString("Name"),rSet.getDate("DOB"),
						rSet.getString("UserName"),rSet.getString("PassWord"),rSet.getBoolean("Deleted"),
						rSet.getString("Image"),rSet.getString("Address"),rSet.getInt("TypeAccount"));
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}
	
	
	public static List<UserDTO> GetUser(String userName,String passWord) {
		List<UserDTO>userDTOs=new ArrayList<UserDTO>();
		ResultSet rSet;
		try {
			rSet = DataAccess.ExcuteQuery("Select * from user where UserName=? And PassWord=?", userName,passWord);
			while(rSet.next()) {
				userDTOs.add(new UserDTO(rSet.getInt("ID"),rSet.getString("Name"),rSet.getDate("DOB"),
						rSet.getString("UserName"),rSet.getString("PassWord"),rSet.getBoolean("Deleted"),
						rSet.getString("Image"),rSet.getString("Address"),rSet.getInt("TypeAccount")));
			}
			return userDTOs;
		} catch (SQLException e) {
			return null;
		}
	}
}
