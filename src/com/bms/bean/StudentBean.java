package com.bms.bean;

public class StudentBean {
	
	private int stdid;
	private String name="";
	private String usn="";
	private String email="";
	private String mob="";
	private String address="";
	private String proc_name="";
	private String proc_mob="";
	private String father_name="";
	private String father_mob="";
	private String mother_name="";
	private String mother_mob="";
	private int class_id;
	
	private int sub_id;
	private double cie1;
	private double cie2;
	private double cie3;
	private double lab;
	private int class_cond;
	private int class_attend;
	private String semester = "";
	private String section = "";
	private String course = "";
	private String username = "";
	private String password = "";	
	
	private int genErr;
	private String genErrMsg = "";
	
	private int userNameErr;
	private String userNameErrMsg = "";
	
	private int passwordErr;
	private String passwordErrMsg = "";
	
	private int nameErr;
	private String nameErrMsg = "";
	
	private int usnErr;
	private String usnErrMsg = "";
	
	private int emailErr;
	private String emailErrMsg = "";
	
	private int mobErr;
	private String mobErrMsg = "";
	
	private int addressErr;
	private String addressErrMsg = "";
	
	private int procNameeErr;
	private String procNameErrMsg = "";
	
	private int procMobErr;
	private String procMobErrMsg = "";
	
	private int fatherNameErr;
	private String FatherNameErrMsg = "";
	
	private int motherNameErr;
	private String motherNameErrMsg = "";
	
	private int fatherMobErr;
	private String fatherMobErrMsg = "";
	
	private int motherMobErr;
	private String motherMobErrMsg = "";
	
	
	// SETTER GETTER
	
	public int getGenErr() {
		return genErr;
	}
	public void setGenErr(int genErr) {
		this.genErr = genErr;
	}
	public String getGenErrMsg() {
		return genErrMsg;
	}
	public void setGenErrMsg(String genErrMsg) {
		this.genErrMsg = genErrMsg;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getPasswordErr() {
		return passwordErr;
	}
	public void setPasswordErr(int passwordErr) {
		this.passwordErr = passwordErr;
	}
	public String getPasswordErrMsg() {
		return passwordErrMsg;
	}
	public void setPasswordErrMsg(String passwordErrMsg) {
		this.passwordErrMsg = passwordErrMsg;
	}
	public int getNameErr() {
		return nameErr;
	}
	public void setNameErr(int nameErr) {
		this.nameErr = nameErr;
	}
	public String getNameErrMsg() {
		return nameErrMsg;
	}
	public void setNameErrMsg(String nameErrMsg) {
		this.nameErrMsg = nameErrMsg;
	}
	public int getUsnErr() {
		return usnErr;
	}
	public void setUsnErr(int usnErr) {
		this.usnErr = usnErr;
	}
	public String getUsnErrMsg() {
		return usnErrMsg;
	}
	public void setUsnErrMsg(String usnErrMsg) {
		this.usnErrMsg = usnErrMsg;
	}
	public int getEmailErr() {
		return emailErr;
	}
	public void setEmailErr(int emailErr) {
		this.emailErr = emailErr;
	}
	public String getEmailErrMsg() {
		return emailErrMsg;
	}
	public void setEmailErrMsg(String emailErrMsg) {
		this.emailErrMsg = emailErrMsg;
	}
	public int getMobErr() {
		return mobErr;
	}
	public void setMobErr(int mobErr) {
		this.mobErr = mobErr;
	}
	public String getMobErrMsg() {
		return mobErrMsg;
	}
	public void setMobErrMsg(String mobErrMsg) {
		this.mobErrMsg = mobErrMsg;
	}
	public int getAddressErr() {
		return addressErr;
	}
	public void setAddressErr(int addressErr) {
		this.addressErr = addressErr;
	}
	public String getAddressErrMsg() {
		return addressErrMsg;
	}
	public void setAddressErrMsg(String addressErrMsg) {
		this.addressErrMsg = addressErrMsg;
	}
	public int getProcNameeErr() {
		return procNameeErr;
	}
	public void setProcNameeErr(int procNameeErr) {
		this.procNameeErr = procNameeErr;
	}
	public String getProcNameErrMsg() {
		return procNameErrMsg;
	}
	public void setProcNameErrMsg(String procNameErrMsg) {
		this.procNameErrMsg = procNameErrMsg;
	}
	public int getProcMobErr() {
		return procMobErr;
	}
	public void setProcMobErr(int procMobErr) {
		this.procMobErr = procMobErr;
	}
	public String getProcMobErrMsg() {
		return procMobErrMsg;
	}
	public void setProcMobErrMsg(String procMobErrMsg) {
		this.procMobErrMsg = procMobErrMsg;
	}
	public int getFatherNameErr() {
		return fatherNameErr;
	}
	public void setFatherNameErr(int fatherNameErr) {
		this.fatherNameErr = fatherNameErr;
	}
	public String getFatherNameErrMsg() {
		return FatherNameErrMsg;
	}
	public void setFatherNameErrMsg(String fatherNameErrMsg) {
		FatherNameErrMsg = fatherNameErrMsg;
	}
	public int getMotherNameErr() {
		return motherNameErr;
	}
	public void setMotherNameErr(int motherNameErr) {
		this.motherNameErr = motherNameErr;
	}
	public String getMotherNameErrMsg() {
		return motherNameErrMsg;
	}
	public void setMotherNameErrMsg(String motherNameErrMsg) {
		this.motherNameErrMsg = motherNameErrMsg;
	}
	public int getFatherMobErr() {
		return fatherMobErr;
	}
	public void setFatherMobErr(int fatherMobErr) {
		this.fatherMobErr = fatherMobErr;
	}
	public String getFatherMobErrMsg() {
		return fatherMobErrMsg;
	}
	public void setFatherMobErrMsg(String fatherMobErrMsg) {
		this.fatherMobErrMsg = fatherMobErrMsg;
	}
	public int getMotherMobErr() {
		return motherMobErr;
	}
	public void setMotherMobErr(int motherMobErr) {
		this.motherMobErr = motherMobErr;
	}
	public String getMotherMobErrMsg() {
		return motherMobErrMsg;
	}
	public void setMotherMobErrMsg(String motherMobErrMsg) {
		this.motherMobErrMsg = motherMobErrMsg;
	}	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProc_name() {
		return proc_name;
	}
	public void setProc_name(String proc_name) {
		this.proc_name = proc_name;
	}
	public String getProc_mob() {
		return proc_mob;
	}
	public void setProc_mob(String proc_mob) {
		this.proc_mob = proc_mob;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getFather_mob() {
		return father_mob;
	}
	public void setFather_mob(String father_mob) {
		this.father_mob = father_mob;
	}
	public String getMother_name() {
		return mother_name;
	}
	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}
	public String getMother_mob() {
		return mother_mob;
	}
	public void setMother_mob(String mother_mob) {
		this.mother_mob = mother_mob;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
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
	public int getUserNameErr() {
		return userNameErr;
	}
	public void setUserNameErr(int userNameErr) {
		this.userNameErr = userNameErr;
	}
	public String getUserNameErrMsg() {
		return userNameErrMsg;
	}
	public void setUserNameErrMsg(String userNameErrMsg) {
		this.userNameErrMsg = userNameErrMsg;
	}
	
}
