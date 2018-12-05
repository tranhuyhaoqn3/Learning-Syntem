package ClientTest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

@WebServlet(urlPatterns= {"/ClientTest"})
public class TestServlet extends HttpServlet{
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
		req.setAttribute("UserName", userDTO);
		Object idClass=req.getParameter("classID");
		if (idClass==null) {
			resp.sendRedirect("./LoginServlet");
			return;
		}
		List<TestDTO>testDTOs=TestModel.GetAllTestOfClassAndUser(userDTO.getiD(),Integer.parseInt((String) idClass));
		ClassDTO classDTO=ClassModel.GetClassByID(Integer.parseInt((String) idClass));
		req.setAttribute("ClassDTO", classDTO);
		req.setAttribute("ListTest", testDTOs);
		req.setAttribute("client-left", "Left.jsp");
		req.getRequestDispatcher("/client/tests.jsp").forward(req, resp);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("./LoginServlet");
	}
}
