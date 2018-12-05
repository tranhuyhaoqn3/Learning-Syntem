package DTO;

import java.util.Date;
import java.util.List;

public class ClassDTO {
	public ClassDTO(int iD, String fullName, String shortName, Date startDate, Date endDate, boolean deleted) {
		this.iD = iD;
		this.fullName = fullName;
		this.shortName = shortName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deleted = deleted;
	}
	private int iD;
	private String fullName;
	private String shortName;
	private Date startDate;
	private Date endDate;
	private boolean deleted;
	private List<ClassTestDTO> classTestDTO;
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public List<ClassTestDTO> getClassTestDTO() {
		return classTestDTO;
	}
	public void setClassTestDTO(List<ClassTestDTO> classTestDTO) {
		this.classTestDTO = classTestDTO;
	}
	
	

	
}
