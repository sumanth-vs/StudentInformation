package com.bms.bean;

public class UserBean {
	
	private int userID;
	private int userType;
	private String userName = "";
	private String password = "";
	private int userFlag;
	private String name = "";
	private String usn = "";
	private String sem = "";
	private String section = "";
	private String course = "";
	private int statusFlg;
	private String statusMsg = "";
	
	
	public int getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(int statusFlg) {
		this.statusFlg = statusFlg;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int genErrFlag;
	private String genErrMsg = "";
	
	private int unErrFlag;
	private String unErrMsg = "";

	private int passErrFlag;
	private String passErrMsg = "";
	
	public int getGenErrFlag() {
		return genErrFlag;
	}
	public void setGenErrFlag(int genErrFlag) {
		this.genErrFlag = genErrFlag;
	}
	public String getGenErrMsg() {
		return genErrMsg;
	}
	public void setGenErrMsg(String genErrMsg) {
		this.genErrMsg = genErrMsg;
	}
	public int getUnErrFlag() {
		return unErrFlag;
	}
	public void setUnErrFlag(int unErrFlag) {
		this.unErrFlag = unErrFlag;
	}
	public String getUnErrMsg() {
		return unErrMsg;
	}
	public void setUnErrMsg(String unErrMsg) {
		this.unErrMsg = unErrMsg;
	}
	public int getPassErrFlag() {
		return passErrFlag;
	}
	public void setPassErrFlag(int passErrFlag) {
		this.passErrFlag = passErrFlag;
	}
	public String getPassErrMsg() {
		return passErrMsg;
	}
	public void setPassErrMsg(String passErrMsg) {
		this.passErrMsg = passErrMsg;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(int userFlag) {
		this.userFlag = userFlag;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}	
}
