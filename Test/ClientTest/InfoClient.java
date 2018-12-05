package ClientTest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ClassDTO;
import DTO.UserDTO;
import Model.ClassModel;
import Model.UserModel;
import MyExtension.MyExtension;

@WebServlet(urlPatterns = { "/InfoClient" })
public class InfoClient extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idUser = req.getParameter("ID") == null ? -1 : Integer.parseInt(req.getParameter("ID"));
		if (!MyExtension.CheckSession(idUser, req)) {
			resp.sendRedirect("./LoginServlet");
			return;
		}
		UserDTO userDTO = null;
		if (idUser > 0) {
			userDTO = UserModel.GetUserByID(idUser);
		}
		if (userDTO != null) {
			req.setAttribute("client-left", "Left.jsp");
			req.setAttribute("UserName", userDTO);
			req.getRequestDispatcher("/client/userclient.jsp").forward(req, resp);
			return;
		} else {
			resp.sendRedirect("./LoginServlet");
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idUser = req.getParameter("ID") == null ? -1 : Integer.parseInt(req.getParameter("ID"));
		if (!MyExtension.CheckSession(idUser, req)) {
			resp.sendRedirect("./LoginServlet");
			return;
		}
		UserDTO userDTO = null;
		if (idUser > 0) {
			userDTO = UserModel.GetUserByID(idUser);
		}
		Date d2;
		try {
			d2 = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("DOB"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			d2=null;
		}
		UserDTO us2 = new UserDTO(idUser,
				req.getParameter("Name") == null ? userDTO.getName() : req.getParameter("Name"),
						d2==null ? userDTO.getdOB() :d2,
				req.getParameter("UserName") == null ? userDTO.getUserName() : req.getParameter("UserName"),
				req.getParameter("PassWord") == null ? userDTO.getPassWord() : req.getParameter("PassWord"), false,
				req.getParameter("Address") == null ? userDTO.getAddress() : req.getParameter("Address"),
				userDTO.getImage(), userDTO.getTypeAccount());
		int rs=UserModel.UpdateUserClient(us2);
		if (rs>0) {
			return;
		}else {
			resp.sendError(404, "Thất bại");
			return;
		}

	}
}
