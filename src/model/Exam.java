package model;

import java.util.Date;

public class Exam {

	private Date date;
	private int time;
	private String clinicalExamination;
	private String additionalExamination;
	
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
	public String getClinicalExamination() {
		return clinicalExamination;
	}
	public void setClinicalExamination(String clinicalExamination) {
		this.clinicalExamination = clinicalExamination;
	}
	public String getAdditionalExamination() {
		return additionalExamination;
	}
	public void setAdditionalExamination(String additionalExamination) {
		this.additionalExamination = additionalExamination;
	}
}
