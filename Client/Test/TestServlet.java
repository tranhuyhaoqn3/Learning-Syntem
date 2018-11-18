package Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;

import test.DataAccess;
@WebServlet(urlPatterns= {"/Test"})
public class TestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("client-left", "Left.jsp");
		
		try {
			int testData= DataAccess.ExcuteNonQuery("INSERT INTO account (UserName, PassWord,Type)\r\n" + 
													"VALUES (?,?,?);","qldethi","123456",2);

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/client/tests.jsp").forward(req, resp);
	}
}
