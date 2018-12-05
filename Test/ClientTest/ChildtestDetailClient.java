package ClientTest;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.TestDTO;
import DTO.UserChildtestDTO;
import DTO.UserDTO;
import Model.TestModel;
import Model.UserChildTestModel;
import Model.UserModel;
import MyExtension.MyExtension;

@WebServlet(urlPatterns= {"/ChildtestDetail"})
public class ChildtestDetailClient extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (MyExtension.GetIDUserSession(req)==-1) {
			resp.sendRedirect("./LoginServlet");
			return;
		}
		UserDTO userDTO=UserModel.GetUserByID(MyExtension.GetIDUserSession(req));
		if (userDTO==null) {
			resp.sendRedirect("./LoginServlet");
			return;
		}
		int iDTest=Integer.parseInt(req.getParameter("IDTest"));
		TestDTO testDTO=TestModel.GetTestById(iDTest);
		if (testDTO!=null) {
			List<UserChildtestDTO>userChildtestDTOs=UserChildTestModel.GetUserChildTestOfUserAndTest(userDTO.getiD(), testDTO.getiD());
			if (userChildtestDTOs!=null&&userChildtestDTOs.size()>0) {
				req.setAttribute("client-left", "Left.jsp");
				req.setAttribute("UserName", userDTO);
				req.setAttribute("TestDTO", testDTO);
				req.setAttribute("ListChildtest", userChildtestDTOs);
				req.getRequestDispatcher("/client/testdetail.jsp").forward(req, resp);
				return;
			}
		}
		resp.sendRedirect("./LoginServlet");
		return;
	}
}
