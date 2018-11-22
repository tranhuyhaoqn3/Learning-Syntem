package DTO;

public class UserClassDTO {
	public UserClassDTO(int iDUser, int iDClass) {
		super();
		this.iDUser = iDUser;
		this.iDClass = iDClass;
	}
	private int iDUser;
	private int iDClass;
	public int getiDUser() {
		return iDUser;
	}
	public void setiDUser(int iDUser) {
		this.iDUser = iDUser;
	}
	public int getiDClass() {
		return iDClass;
	}
	public void setiDClass(int iDClass) {
		this.iDClass = iDClass;
	}
	
}
