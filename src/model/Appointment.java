package model;

import java.util.Date;

public class Appointment {
	
	private Date date;
	private int time;
	private String complaint;
	private String prescribedTreatment;
	private boolean needForExamination;
	
	public Date getDate() {
	   	return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getPrescribedTreatment() {
		return prescribedTreatment;
	}
	public void setPrescribedTreatment(String prescribedTreatment) {
		this.prescribedTreatment = prescribedTreatment;
	}
	public boolean isNeedForExamination() {
		return needForExamination;
	}
	public void setNeedForExamination(boolean needForExamination) {
		this.needForExamination = needForExamination;
	}
	
	

}
