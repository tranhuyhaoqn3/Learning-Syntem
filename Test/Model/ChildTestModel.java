package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DTO.ChildTestDTO;
import DTO.UserChildtestDTO;
import DataAccess.DataAccess;

public class ChildTestModel {
	public static List<ChildTestDTO>GetChildTestOfTest(int iDTest) {
		ResultSet resultSet;
		try {
			List<ChildTestDTO>childTestDTOs=new ArrayList<ChildTestDTO>();
			resultSet=DataAccess.ExcuteQuery("Select * from childtest where IDTest=?", iDTest);
			while (resultSet.next()) {
				childTestDTOs.add(new ChildTestDTO(resultSet.getInt("ID"), resultSet.getString("Name"), resultSet.getInt("IDTest")));
			}
			return childTestDTOs;
		} catch (Exception e) {
			return null;
		}
	}
	public static ChildTestDTO GetChildTestExcute(int iDUser,int iDTest) {
		List<ChildTestDTO>childTestDTOs=GetChildTestOfTest(iDTest);
		if (childTestDTOs.size()>0) {
			int iDran=0;
			int[] random=new int[childTestDTOs.size()];
			for (int i = 0; i < childTestDTOs.size(); i++) {
				random[i]=childTestDTOs.get(i).getiD();
			}
			Random rand = new Random();
			boolean check=false;
			
			while (!check) {
				iDran=random[rand.nextInt(random.length)];
				//check user excute child test
				UserChildtestDTO userChildtestDTO=UserChildTestModel.CheckUserChildTestExcute(iDUser, iDran);
				if (userChildtestDTO==null) {
					check=true;
				}
			}
			int t=iDran;
			return childTestDTOs.stream().filter(x->x.getiD()==t).findAny().orElse(null);
			
		}
		return null;
	}
	
}
