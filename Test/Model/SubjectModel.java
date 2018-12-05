package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Answer;
import DTO.Subject;
import DataAccess.DataAccess;

public class SubjectModel {

	public SubjectModel() {
		
	}
	public ArrayList<Subject> getAll(){
		ArrayList<Subject> subjects  = new ArrayList<>();
		ResultSet rSet;
		try {
			rSet = DataAccess.ExcuteQuery("Select * from subject");
			while(rSet.next()) {
				subjects.add(new Subject(rSet.getInt("ID"), rSet.getString("Name")));
			}
			return subjects;
		} catch (SQLException e) {
			return null;
		}
	}
	public int Add(Subject subject) {
		try {
			int rs = -1;
			rs = DataAccess.ExcuteNonQuery("INSERT INTO subject(`Name`) VALUES(?)", subject.getName());
			return rs;
		} catch (SQLException e) {
			return -1;
		}
	}
}
