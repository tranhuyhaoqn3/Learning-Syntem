package DTO;

import java.util.Date;

public class UserChildtestDTO {


	public UserChildtestDTO(int iDUser, int iDChildTest, float score, Date timeStart, Date timeEnd) {
		super();
		this.iDUser = iDUser;
		this.iDChildTest = iDChildTest;
		this.score = score;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	private int iDUser;
	private int iDChildTest;
	private float score;
	public int getiDUser() {
		return iDUser;
	}
	private Date timeStart;
	private Date timeEnd;
	public void setiDUser(int iDUser) {
		this.iDUser = iDUser;
	}
	public int getiDChildTest() {
		return iDChildTest;
	}
	public void setiDChildTest(int iDChildTest) {
		this.iDChildTest = iDChildTest;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	/**
	 * @return the timeEnd
	 */
	public Date getTimeEnd() {
		return timeEnd;
	}
	/**
	 * @param timeEnd the timeEnd to set
	 */
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	

}

