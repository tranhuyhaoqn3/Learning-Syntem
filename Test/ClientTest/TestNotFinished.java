package ClientTest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ClassDTO;
import DTO.TestDTO;
import DTO.UserDTO;
import Model.ClassModel;
import Model.TestModel;
import Model.UserModel;
import MyExtension.MyExtension;

public class TestNotFinished extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idUser=Integer.parseInt(req.getParameter("ID"));
		if (!MyExtension.CheckSession(idUser, req)) {
			resp.sendRedirect("./LoginServlet");
			return;
		}
		UserDTO userDTO=null;
		if (idUser>0) {
			userDTO=UserModel.GetUserByID(idUser);
		}
		if (userDTO!=null) {
			//get test of user not finish
			TestDTO testDTO=TestModel.GetTestOfUserNotFinished(userDTO.getiD());
		}
	}
}
