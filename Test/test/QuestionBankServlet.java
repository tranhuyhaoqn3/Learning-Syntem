package test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.Answer;
import DTO.Question;
import DTO.Subject;
import Model.AnswerModel;
import Model.QuestionModel;
import Model.SubjectModel;

@SuppressWarnings("serial")
@WebServlet(
        name = "questionAdminServlet",
        urlPatterns = {"/questionBank"},
        loadOnStartup = 1
)
@MultipartConfig
public class QuestionBankServlet extends HttpServlet {    
	private SubjectModel subjectModel;
	private QuestionModel questionModel;
	private AnswerModel answerModel;
    public QuestionBankServlet() {
        super();
        subjectModel = new SubjectModel();
        questionModel = new QuestionModel();
        answerModel = new AnswerModel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type == null) {
			type = "";
		}
		switch (type) {
		case "getQuestionBySubjectId":
			getQuestionBySubjectId(request,response);
			break;
		case "deleteQuestion":
			deleteQuestion(request, response);
			break;
		default:
			index(request,response);
			break;
		}
	}
	private void getQuestionBySubjectId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		ArrayList<Question> questions = questionModel.getBySubject(subjectId);
		if(questions.size() == 0) {
			response.getWriter().write("");
			return;
		}
		request.setAttribute("questions", questions);
		request.getRequestDispatcher("/admin/sub/partialQuestionBank.jsp").forward(request, response);
	}
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Subject> subjects = subjectModel.getAll();
		request.setAttribute("listSubject", subjects);
		request.getRequestDispatcher("/admin/main/question.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type == null) {
			type = "";
		}
		switch (type) {
		case "saveQuestionDetail":
			saveQuestionDetail(request,response);
			break;
		case "saveQuestion":
			saveQuestion(request, response);
			break;
		case "saveFile":
			saveFile(request,response);
			break;
		}
	}
	private void saveQuestionDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("data");
		ObjectMapper mapper = new ObjectMapper();
		int temp = 0;
		try {
			Question question = mapper.readValue(json, Question.class);
			for(Answer answer : question.getAnswers()) {
				if(answer.getID() == 0) {
					// add answer
					int rs = answerModel.Add(answer);
					if(rs <= 0 ) {
						//error
						temp = -1;
					}
				} else {
					if(answer.isDeleted()) {
						int rs = answerModel.Delete(answer);
						if(rs <= 0 ) {
							temp = -1;
						}
					} else {
						int rs = answerModel.Edit(answer);
						if(rs <= 0 ) {
							temp = -1;
						}	
					}
				}
				if(answer.isCorrect()) {
					//set correct
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			temp = -1;
		}
		response.setCharacterEncoding("utf8");
		if(temp == 0) {
			response.getWriter().write("Cập nhật câu trả lời thành công!");	
		} else {
			response.getWriter().write("Cập nhật câu trả lời không thành công!");
		}
		
	}
	
	private void saveQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("typeAction");
		ObjectMapper mapper = new ObjectMapper();
		String json = request.getParameter("data");
		Question question = mapper.readValue(json, Question.class);
		int i = -1;
		if(type.equals("add")) {
			i = questionModel.Add(question);
		} else if(type.equals("edit")) {
			i = questionModel.Edit(question);
		}
		response.setCharacterEncoding("utf8");
		String objectToReturn = "";
		if(i <= 0 ) {
			objectToReturn = "Lưu câu hỏi không thành công";
			response.getWriter().write(objectToReturn);
		} else {
			objectToReturn = "Lưu câu hỏi thành công";
			response.getWriter().write(objectToReturn);
		}	
	}
	private void deleteQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf8");
		String questionId = request.getParameter("id");
		if(questionId != "") {
			int rs = questionModel.Delete(Integer.parseInt(questionId));	
			if(rs <= 0) {
				response.getWriter().write("Xóa câu hỏi không thành công");
				return;
			}
			response.getWriter().write("Xóa câu hỏi thành công");
			return;
		}
		response.getWriter().write("Xóa câu hỏi không thành công");
	}

	private void saveFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletContext();
		String path = context.getRealPath("/WEB-INF/file_import/");

		Part filePart = request.getPart("file-question");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		InputStream fileContent = filePart.getInputStream();
		Path fullpath = (new File(path + fileName)).toPath();
		Files.copy(fileContent, fullpath);
	}

}
