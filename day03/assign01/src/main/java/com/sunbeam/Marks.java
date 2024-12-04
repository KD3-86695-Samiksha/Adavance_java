package com.sunbeam;

public class Marks {
	private double Marks;
	private  String subject;
	public Marks(String subject,double marks) {
		
		this.Marks = marks;
		this.subject = subject;
	}
	public double getMarks() {
		return Marks;
	}
	public void setMarks(double marks) {
		Marks = marks;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	

}
