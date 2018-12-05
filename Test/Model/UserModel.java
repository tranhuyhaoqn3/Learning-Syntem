package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import DTO.UserDTO;
import DataAccess.DataAccess;

public class UserModel {
	public static UserDTO GetUserByID (int idUser) {
	
		ResultSet rSet;
		try {
			rSet = DataAccess.ExcuteQuery("Select * from user where ID=?", idUser);
			while(rSet.next()) {
				return new UserDTO(rSet.getInt("ID"),rSet.getString("Name"),rSet.getDate("DOB"),
						rSet.getString("UserName"),rSet.getString("PassWord"),rSet.getBoolean("Deleted"),
						rSet.getString("Address"),rSet.getString("Image"),rSet.getInt("TypeAccount"));
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	
	public static List<UserDTO> GetUser(String userName,String passWord) {
		List<UserDTO>userDTOs=new ArrayList<UserDTO>();
		ResultSet rSet;
		try {
			rSet = DataAccess.ExcuteQuery("Select * from user where UserName=? And PassWord=?", userName,passWord);
			while(rSet!=null&&rSet.next()) {
				userDTOs.add(new UserDTO(rSet.getInt("ID"),rSet.getString("Name"),rSet.getDate("DOB"),
						rSet.getString("UserName"),rSet.getString("PassWord"),rSet.getBoolean("Deleted"),
						rSet.getString("Image"),rSet.getString("Address"),rSet.getInt("TypeAccount")));
			}
			return userDTOs;
		} catch (Exception e) {
			return null;
		}
	}


	public static int UpdateUserClient(UserDTO us2) {
		try {
			String query="UPDATE \r\n" + 
					"  `doanweb`.`user` \r\n" + 
					"SET\r\n" + 
					"  `Name` = ?,\r\n" + 
					"  `DOB` = ?,\r\n" + 
					"  `UserName` = ?,\r\n" + 
					"  `PassWord` = ?,\r\n" + 
					"  `TypeAccount` = ?,\r\n" + 
					"  `Deleted` = ?,\r\n" + 
					"  `Address` = ?,\r\n" + 
					"  `Image` = ? \r\n" + 
					"WHERE `ID` = ? ;\r\n" + 
					"\r\n" + 
					"";
			return DataAccess.ExcuteNonQuery(query, us2.getName(),us2.getdOB(),
								us2.getUserName(),us2.getPassWord(),us2.getTypeAccount(),
								us2.isDeleted(),us2.getAddress(),us2.getImage(),us2.getiD());
		} catch (Exception e) {
			return -1;
		}

	}
}
