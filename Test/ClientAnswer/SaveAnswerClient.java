package ClientAnswer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UserChildtestDTO;
import DTO.UserDTO;
import DTO.UserQuestionDTO;
import DataAccess.DataAccess;
import Model.UserModel;
import Model.UserQuestionModel;
import MyExtension.MyExtension;

@WebServlet(urlPatterns= {"/SaveAnswerClient"})
public class SaveAnswerClient extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if (MyExtension.GetIDUserSession(req)==-1) {
				resp.sendRedirect("./LoginServlet");
				return ;
			}
			UserDTO userDTO=UserModel.GetUserByID(MyExtension.GetIDUserSession(req));
			if (userDTO==null) {
				resp.sendRedirect("./LoginServlet");
				return;
			}
			int IDQuestion=Integer.parseInt(req.getParameter("IDQuestion"));
			int IDChiltest=Integer.parseInt(req.getParameter("IDChiltest"));
			int IDAnswer=Integer.parseInt(req.getParameter("IDAnswer"));
			//Check xem đã chon chưa
			UserQuestionDTO userQuestionDTO=UserQuestionModel.GetUserChildTestByIDUserQuestionChildtest(userDTO.getiD(), IDChiltest, IDQuestion);
			if (userQuestionDTO!=null&&IDAnswer!=userQuestionDTO.getiDAnswer()) {
				//update
				UserQuestionModel.Update(userDTO.getiD(),IDQuestion,IDChiltest,IDAnswer);
				return;
			}else {
				if (userQuestionDTO!=null&&IDAnswer==userQuestionDTO.getiDAnswer()) {
					resp.setContentType("text/html;charset=UTF-8");
					resp.getWriter().write("Error");
					return;
				}
				UserQuestionModel.Insert(userDTO.getiD(),IDQuestion,IDChiltest,IDAnswer);
				return;
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
