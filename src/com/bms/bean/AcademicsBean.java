package com.bms.bean;

public class AcademicsBean {
	
	private int stdID;
	private int subID;
	private double cie1;
	private double cie2;
	private double cie3;
	private double lab;
	private int class_cond;
	private int class_attend;
	private String subject="";
	
	
	//SETTER GETTERS
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getStdID() {
		return stdID;
	}
	public void setStdID(int stdID) {
		this.stdID = stdID;
	}
	public int getSubID() {
		return subID;
	}
	public void setSubID(int subID) {
		this.subID = subID;
	}
	public double getCie1() {
		return cie1;
	}
	public void setCie1(double cie1) {
		this.cie1 = cie1;
	}
	public double getCie2() {
		return cie2;
	}
	public void setCie2(double cie2) {
		this.cie2 = cie2;
	}
	public double getCie3() {
		return cie3;
	}
	public void setCie3(double cie3) {
		this.cie3 = cie3;
	}
	public double getLab() {
		return lab;
	}
	public void setLab(double lab) {
		this.lab = lab;
	}
	public int getClass_cond() {
		return class_cond;
	}
	public void setClass_cond(int class_cond) {
		this.class_cond = class_cond;
	}
	public int getClass_attend() {
		return class_attend;
	}
	public void setClass_attend(int class_attend) {
		this.class_attend = class_attend;
	}
	
}
