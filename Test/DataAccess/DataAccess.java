package DataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataAccess {
	
	private static String portMYSQL="3306";
	private static String nameDataBase="doanweb";
	private static Connection conn;
	
	private static ResultSet ExcuteQuery(String query) throws SQLException {
		return ExcuteQuery(query,null);
	}
	public static ResultSet ExcuteQuery(String query,Object... paramater) throws SQLException{
		ResultSet rs = null;
		PreparedStatement statement;
		try {
			conn=OpenConnect();
			statement=conn.prepareStatement(query);
			if (paramater!=null) {
				int i=1;
				for (Object item : paramater) {
					statement.setObject(i, item);
					i++;
				}
			}
			rs=statement.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}
	private static int ExcuteNonQuery(String query) throws SQLException {
		return ExcuteNonQuery(query,null);
	}
	public static int ExcuteNonQuery(String query,Object... paramater) throws SQLException{
		int rs = -1;
		PreparedStatement statement;
		try {
			conn=OpenConnect();
			statement=conn.prepareStatement(query);
			if (paramater!=null) {
				int i=1;
				for (Object item : paramater) {
					statement.setObject(i, item);
					i++;
				}
			}
			rs=statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}
	
	
	private  static Connection OpenConnect() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:"+portMYSQL+"/"+nameDataBase+"";
		String user = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception er) {
			er.printStackTrace();
		}
		return con;
	}
}
