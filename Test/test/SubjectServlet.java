package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Subject;
import Model.SubjectModel;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private SubjectModel subjectModel;
    public SubjectServlet() {
        super();
        subjectModel = new SubjectModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type == null) {
			type = "";
		}
		switch (type) {
		case "addNew":
			addNew(request,response);
			break;
		}
	}
	private void addNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectName = request.getParameter("txt-question-type");
		Subject subject = new Subject();
		subject.setName(subjectName);
		int rs = subjectModel.Add(subject);
		response.sendRedirect("questionBank?success="+rs);
	}

}
