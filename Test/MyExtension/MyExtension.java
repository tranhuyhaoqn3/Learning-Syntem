package MyExtension;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyExtension {
	public static String GetDateTimeNow() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	public static Date StringToDate(String date) {
		try {
			Date date1=new SimpleDateFormat("yyy/MM/dd HH:mm:ss").parse(date);
			return date1;
		} catch (ParseException e) {
			return new Date();
		}  
		
	}
	public static String GetDateTimeNow(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(date);
	}
	public static int GetIDUserSession(HttpServletRequest req) {
		HttpSession session=req.getSession();
		if (session.getAttribute("IDUser")==null) {
			return -1;
		}
		else {
			return (int) session.getAttribute("IDUser");
		}
	}
	public static boolean CheckSession(int iDUSer, HttpServletRequest req) {
		HttpSession session=req.getSession();
		if (session.getAttribute("IDUser")==null) {
			return false;
		}
		int idSession=(int) session.getAttribute("IDUser");
		if (iDUSer!=idSession) {
			return false;
		}
		return true;
	}
}
