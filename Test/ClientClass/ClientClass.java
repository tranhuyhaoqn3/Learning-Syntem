package ClientClass;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UserDTO;
import Model.UserModel;

@WebServlet(urlPatterns= {"/MyClass"})
public class ClientClass extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idUser= (int) req.getAttribute("ID");
		UserDTO userDTO=null;
		if (idUser>0) {
			userDTO=UserModel.GetUserByID(idUser);
		}
		if (userDTO!=null) {
			req.setAttribute("UserName",userDTO.Name);
			req.getRequestDispatcher("/client/class.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
