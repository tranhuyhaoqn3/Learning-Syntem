package DTO;

import java.util.Date;

public class UserDTO {
	public UserDTO(int iD, String name, Date dOB, String userName, String passWord, boolean deleted, String address,
			String image, int typeAccount) {
		super();
		this.iD = iD;
		this.name = name;
		this.dOB = dOB;
		this.userName = userName;
		this.passWord = passWord;
		this.deleted = deleted;
		this.address = address;
		this.image = image;
		this.typeAccount = typeAccount;
	}
	private int iD;
	private String name;
	private Date dOB;
	private String userName;
	private String passWord;
	private boolean deleted;
	private String address;
	private String image;
	private int typeAccount;
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getdOB() {
		return dOB;
	}
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getTypeAccount() {
		return typeAccount;
	}
	public void setTypeAccount(int typeAccount) {
		this.typeAccount = typeAccount;
	}
	
}
