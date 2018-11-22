package ClientClass;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.ClassDTO;
import DTO.UserDTO;
import Model.ClassModel;
import Model.UserModel;

@WebServlet(urlPatterns= {"/MyClass"})
public class ClientClass extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idUser=Integer.parseInt(req.getParameter("ID"));
		HttpSession session=req.getSession();
		int idSession=(int) session.getAttribute("IDUser");
		if (idUser!=idSession) {
			resp.sendRedirect("./LoginServlet");
			return;
		}
		UserDTO userDTO=null;
		if (idUser>0) {
			userDTO=UserModel.GetUserByID(idUser);
		}
		if (userDTO!=null) {
			//get class dang hoc
			List<ClassDTO>classDTOs=ClassModel.GetClassOfUser(userDTO.getiD());
			req.setAttribute("ListClass",classDTOs);
			req.setAttribute("UserName",userDTO.getName());
			req.getRequestDispatcher("/client/class.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
