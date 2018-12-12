package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Subject;
import Model.SubjectModel;

/**
 * Servlet implementation class CreateTest
 */
@WebServlet(urlPatterns= {"/CreateTest"})
public class CreateTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubjectModel subjectModel;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTest() {
        super();
        subjectModel = new SubjectModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		if(type == null) {
			type = "";
		}
		switch (type) {
		case "getTestBySubjectId":
			getAll(req,resp);
			break;
		default:
			getAll(req,resp);
			break;
		}
		
	}
	protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Subject> list = subjectModel.getAll();
		req.setAttribute("listSubject", list);
		req.getRequestDispatcher("/admin/main/createtest.jsp").forward(req, resp);
	}
	protected void getTestBySubjectId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Hello Wolrd");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
