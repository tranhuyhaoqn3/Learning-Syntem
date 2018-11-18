package test;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.abcdDTO;

@WebServlet(urlPatterns= {"/User"})
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("client-left", "Left.jsp");
		
		ArrayList<abcdDTO>testList = null;
		try {
			int testData= DataAccess.ExcuteNonQuery("Insert into abcd values(?,?,?,?)", "C",5,false,new Date());

			testList=new ArrayList<>();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(!testList.isEmpty()) {
			int a=1;
		}
		req.getRequestDispatcher("/client/tests.jsp").forward(req, resp);
	}
}
