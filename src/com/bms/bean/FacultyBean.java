package com.bms.bean;

public class FacultyBean {

	private int fac_id;
	private String fac_name = "";
	private String course = "";
	private String sem = "";
	private String section = "";
	private String sub_name = "";
	private String sub_short_name = "";
	private int sub_id;
	private int class_id;
	private int student_id;
	private String student_name = "";
	private int classes_cond;
	private int classes_attend;
	private double cie1;
	private double cie2;
	private double cie3;
	private double lab;
	private String mob = "";
	private String email = "";
	private String username = "";
	private String password = "";
	
	
	public String getSub_short_name() {
		return sub_short_name;
	}
	public void setSub_short_name(String sub_short_name) {
		this.sub_short_name = sub_short_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getClasses_cond() {
		return classes_cond;
	}
	public void setClasses_cond(int classes_cond) {
		this.classes_cond = classes_cond;
	}
	public int getClasses_attend() {
		return classes_attend;
	}
	public void setClasses_attend(int classes_attend) {
		this.classes_attend = classes_attend;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	//SG
	public int getFac_id() {
		return fac_id;
	}
	public void setFac_id(int fac_id) {
		this.fac_id = fac_id;
	}
	public String getFac_name() {
		return fac_name;
	}
	public void setFac_name(String fac_name) {
		this.fac_name = fac_name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
}
