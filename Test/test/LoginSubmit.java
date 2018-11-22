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
import Model.UserModel;

@WebServlet(urlPatterns= {"/LoginSubmit"})
public class LoginSubmit extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userName=req.getParameter("UserName");
			String passWord=req.getParameter("PassWord");
			List<UserDTO>userDTOs=UserModel.GetUser(userName, passWord);
			if (userDTOs.size()>0) {
				switch (userDTOs.get(0).TypeAccount) {
				case 0://Thi sinh
					req.setAttribute("ID", userDTOs.get(0).ID);
					req.getRequestDispatcher("./MyClass").forward(req, resp);
					return;

				default:
					break;
				}
			}
		} catch (Exception e) {
			resp.sendRedirect("./LoginServlet");
		}
		
		
	}
}
