package ClientTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.UserDTO;
import Model.ChildTestModel;
import Model.UserChildTestModel;
import Model.UserModel;
import MyExtension.MyExtension;

@WebServlet(urlPatterns= {"/FinishedTest"})
public class FinishTest extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if (MyExtension.GetIDUserSession(req)==-1) {
				resp.sendRedirect("./LoginServlet");
				return;
			}
			UserDTO userDTO=UserModel.GetUserByID(MyExtension.GetIDUserSession(req));
			if (userDTO==null) {
				resp.sendRedirect("./LoginServlet");
				return;
			}
			int iDChildtest=Integer.parseInt(req.getParameter("IDChildtest"));
			int kq=UserChildTestModel.UpdateTimeEnd(userDTO.getiD(),iDChildtest);
			if (kq>0) {
				HttpSession session=req.getSession();
				session.removeAttribute("IDChildtest");
				resp.sendRedirect("./TestDetail?ID="+iDChildtest);
				return;
			}
			else {
				resp.sendRedirect("./LoginServlet");
			}
			
		} catch (Exception e) {
			resp.sendRedirect("./LoginServlet");
			return;
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("./LoginServlet");
	}
}
