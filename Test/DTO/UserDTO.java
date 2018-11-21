package DTO;

public class UserDTO {
	public UserDTO(int id,String name,int age,String uname,String pword,int tp) {
		this.ID=id;
		this.Name=name;
		this.Age=age;
		this.UserName=uname;
		this.PassWord=pword;
		this.TypeAccount=tp;
		
	}
	public int ID;
	public String Name;
	public int Age;
	public String UserName;
	public String PassWord;
	public int TypeAccount;

}
