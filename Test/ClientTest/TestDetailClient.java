package ClientTest;

import java.io.IOException;
import java.time.Year;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.AnswerDTO;
import DTO.QuestionDTO;
import DTO.TestDTO;
import DTO.UserChildtestDTO;
import DTO.UserDTO;
import DTO.UserQuestionDTO;
import Model.QuestionModel;
import Model.TestModel;
import Model.UserChildTestModel;
import Model.UserModel;
import Model.UserQuestionModel;
import MyExtension.MyExtension;

@WebServlet(urlPatterns= {"/TestDetail"})
public class TestDetailClient extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		int iDChildtest=Integer.parseInt(req.getParameter("ID"));
		List<QuestionDTO>questionDTOsOfChildTest=QuestionModel.GetAllQuestionOfUserAndChildTest(userDTO.getiD(), iDChildtest);
		List<UserQuestionDTO>userQuestionDTOs=UserQuestionModel.GetAllUserQuestionOfUserAndChildtest(userDTO.getiD(), iDChildtest);
		if (userQuestionDTOs!=null&&userQuestionDTOs.size()>0) {
			for (UserQuestionDTO userQuestionDTO : userQuestionDTOs) {
				questionDTOsOfChildTest.stream().filter(x->x.getiD()==userQuestionDTO.getiDQuestion())
				.findAny().orElse(null).setiDUserChoose(userQuestionDTO.getiDAnswer());
			}
		}
		
		double scoreUser=questionDTOsOfChildTest.stream().
										filter(t->t.getAnswerDTOs().stream().anyMatch(x->x.getiD()==t.getiDUserChoose()&&x.isCorrect()==true)
										).mapToDouble(o->o.getScore()).sum();
										
		double scoreTest=questionDTOsOfChildTest.stream().mapToDouble(x->x.getScore()).sum();
		req.setAttribute("ScoreUser", scoreUser);
		req.setAttribute("ScoreTest", scoreTest);
		req.setAttribute("client-left", "Left.jsp");
		req.setAttribute("client-right", "RightScore.jsp");
		req.setAttribute("ListQuest", questionDTOsOfChildTest);
		req.getRequestDispatcher("/client/questiondetail.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
