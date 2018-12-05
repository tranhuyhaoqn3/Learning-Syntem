package ClientQuestion;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.ChildTestDTO;
import DTO.QuestionDTO;
import DTO.TestDTO;
import DTO.UserChildtestDTO;
import DTO.UserDTO;
import Model.ChildTestModel;
import Model.QuestionModel;
import Model.TestModel;
import Model.UserChildTestModel;
import Model.UserModel;
import MyExtension.MyExtension;

@WebServlet(urlPatterns= {"/ClientQuestion"})
public class QuestionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("./LoginServlet");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
		if (MyExtension.GetIDUserSession(req)==-1) {
			resp.sendRedirect("./LoginServlet");
			return;
		}
		UserDTO userDTO=UserModel.GetUserByID(MyExtension.GetIDUserSession(req));
		if (userDTO==null) {
			resp.sendRedirect("./LoginServlet");
			return;
		}
		if (session.getAttribute("IDChildtest")!=null) {
			int idUserChildtest=(int) session.getAttribute("IDChildtest");
			int rs=UserChildTestModel.UpdateTimeEnd(userDTO.getiD(),idUserChildtest);
			session.removeAttribute("IDChildtest");
			resp.sendRedirect("./TestDetail");
			return;
		}
		req.setAttribute("UserName", userDTO);
		String idTest=req.getParameter("IDTest");
		
		//check test con hieu luc
		TestDTO testDTO=TestModel.GetTestById(Integer.parseInt(idTest));
		if (testDTO!=null) {
			Date datenow=new Date();
			if (datenow.compareTo(testDTO.getTimeStart())<0) {
				req.setAttribute("Error", "Bài kiểm tra chưa được mở. Bạn không thể làm bài!");
				req.getRequestDispatcher("/client/error.jsp").forward(req, resp);
				return;
			}
			if (datenow.compareTo(testDTO.getTimeEnd())>0) {
				req.setAttribute("Error", "Bài kiểm tra đã hết hạn. Bạn không thể làm bài!");
				req.getRequestDispatcher("/client/error.jsp").forward(req, resp);
				return;
			}
		}
		ChildTestDTO childTestDTO=ChildTestModel.GetChildTestExcute(userDTO.getiD(),testDTO.getiD());
		if (childTestDTO==null) {
			req.setAttribute("Error", "Bài kiểm tra chưa được soạn!");
			req.getRequestDispatcher("/client/error.jsp").forward(req, resp);
			return;
		}
		List<QuestionDTO>ListQuest=QuestionModel.GetAllQuestionOfUserAndChildTest(userDTO.getiD(),childTestDTO.getiD());
		if (ListQuest!=null&&ListQuest.size()>0) {
			//bắt đầu tính giờ làm bài
			int rs=UserChildTestModel.Add(userDTO.getiD(),childTestDTO.getiD());
			if (rs>0) {
				session.setAttribute("IDChildtest", childTestDTO.getiD());
				req.setAttribute("ChildTestDTO", childTestDTO);
				req.setAttribute("TestDTO", testDTO);
				req.setAttribute("ListQuest", ListQuest);
				req.setAttribute("client-right", "Right.jsp");
				req.getRequestDispatcher("/client/question.jsp").forward(req, resp);
				return;
			}
		}
		else {
			req.setAttribute("Error", "Bài kiểm tra chưa được soạn!");
			req.getRequestDispatcher("/client/error.jsp").forward(req, resp);
			return;
		}
	}
}
