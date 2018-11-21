package test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UserDTO;
import DataAccess.DataAccess;

@WebServlet(urlPatterns= {"/LoginSubmit"})
public class LoginSubmit extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("UserName");
		String passWord=req.getParameter("PassWord");
		try {
			List<UserDTO>userDTOs=new ArrayList<UserDTO>();
			ResultSet rSet=DataAccess.ExcuteQuery("Select * from user where UserName=? And PassWord=?", userName,passWord);
			while(rSet.next()) {
				userDTOs.add(new UserDTO(rSet.getInt("ID"),rSet.getString("Name"),rSet.getInt("Age"),userName,passWord,rSet.getInt("TypeAccount")));
			}
			if (userDTOs.size()>0) {
				switch (userDTOs.get(0).TypeAccount) {
				case 0://Thi sinh
					req.setAttribute("ID", userDTOs.get(0).ID);
					resp.sendRedirect("./Test?ID="+userDTOs.get(0).ID+"");
					return;

				default:
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.doPost(req, resp);
	}
}
