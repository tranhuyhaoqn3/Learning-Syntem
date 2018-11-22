package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.UserDTO;
import Model.UserModel;


@WebServlet(urlPatterns= {"/LoginSubmit"})
public class LoginSubmit extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userName=req.getParameter("UserName");
			String passWord=req.getParameter("PassWord");
			List<UserDTO>userDTOs=UserModel.GetUser(userName, passWord);
			if (userDTOs!=null&&userDTOs.size()>0) {
				HttpSession session=req.getSession();
				session.setAttribute("IDUser",userDTOs.get(0).getiD() );
				switch (userDTOs.get(0).getTypeAccount()) {
				case 0://Thi sinh
//					req.setAttribute("ID", userDTOs.get(0).ID);
//					req.getRequestDispatcher("./MyClass").forward(req, resp);
					resp.sendRedirect("./MyClass?ID="+userDTOs.get(0).getiD());
					return;

				default:
					break;
				}
			}
			//Sai tai khoan
			resp.sendRedirect("./LoginServlet");
		} catch (Exception e) {
			resp.sendRedirect("./LoginServlet");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("./LoginServlet");
	}
}
