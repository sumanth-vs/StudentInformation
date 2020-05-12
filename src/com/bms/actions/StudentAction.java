package com.bms.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.AcademicsBean;
import com.bms.bean.ClassBean;
import com.bms.bean.StudentBean;
import com.bms.db.StudentinfoDB;
import com.bms.validator.Validator;





public class StudentAction extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void getStudentInfo(HttpServletRequest request, HttpServletResponse response) {

		int stdId = Integer.parseInt(request.getParameter("stdID").trim());

		StudentinfoDB db = new StudentinfoDB();
		StudentBean sb = db.getStudentInfo(stdId);
		request.setAttribute("sb", sb);

	}

	public void getStudentHomepage(HttpServletRequest request, HttpServletResponse response) {

		int stdId = Integer.parseInt(request.getParameter("stdID").trim());

		StudentinfoDB db = new StudentinfoDB();
		StudentBean sb = db.getStudentHomepage(stdId);
		request.setAttribute("sb", sb);
	}

	public void getCourse(HttpServletRequest request, HttpServletResponse response) {

		StudentinfoDB db = new StudentinfoDB();
		ArrayList<ClassBean> courseList = db.getCourse();
		request.setAttribute("cl", courseList);

	}

	public StudentBean registerStudentDetails(HttpServletRequest request, HttpServletResponse response) {

		StudentBean sb = new StudentBean();
		StudentinfoDB db = new StudentinfoDB();
		
		//Just ensuring that error is false initially
		sb.setGenErr(0);
		sb.setGenErrMsg("");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("stud_name");
		String usn = request.getParameter("usn");
		String email = request.getParameter("email");
		String mob = request.getParameter("mob");
		String address = request.getParameter("address");
		String proc_name = request.getParameter("proc_name");
		String proc_mob = request.getParameter("proc_mob");
		String father_name = request.getParameter("father_name");
		String father_mob = request.getParameter("father_mob");
		String mother_name = request.getParameter("mother_name");
		String mother_mob = request.getParameter("mother_mob");
		int course_class_sec = Integer.parseInt(request.getParameter("course_class_sec"));

		sb.setUsername(username);
		sb.setPassword(password);
		sb.setName(name);
		sb.setEmail(email);
		sb.setUsn(usn);
		sb.setMob(mob);
		sb.setAddress(address);
		sb.setProc_name(proc_name);
		sb.setProc_mob(proc_mob);
		sb.setFather_name(father_name);
		sb.setFather_mob(father_mob);
		sb.setMother_name(mother_name);
		sb.setMother_mob(mother_mob);
		sb.setClass_id(course_class_sec);

		
		// Regex Validator
		Validator va = new Validator();

		if(!va.isName(name)) {
			sb.setGenErr(1);
			sb.setNameErr(1);
			sb.setNameErrMsg("Your Name is invalid");
		}
		if(!va.isName(proc_name)) {
			sb.setGenErr(1);
			sb.setNameErr(1);
			sb.setNameErrMsg("Proctor Name is invalid");
		}
		if(!va.isName(father_name)) {
			sb.setGenErr(1);
			sb.setFatherNameErr(1);
			sb.setFatherNameErrMsg("Father Name is invalid");
		}
		if(!va.isName(mother_name)) {
			sb.setGenErr(1);
			sb.setMotherNameErr(1);
			sb.setMotherNameErrMsg("Mother Name is invalid");
		}
		if(!va.isEmail(email)) {
			sb.setGenErr(1);
			sb.setEmailErr(1);
			sb.setEmailErrMsg("Email is invalid");
		}
		if(!va.isUSN(usn)) {
			sb.setGenErr(1);
			sb.setUsnErr(1);
			sb.setUsnErrMsg("USN is invalid");
		}
		if(!va.isMOB(mob)) {
			sb.setGenErr(1);
			sb.setMobErr(1);
			sb.setMobErrMsg("Mobile Number is invalid");
		}
		if(!va.isMOB(proc_mob)) {
			sb.setGenErr(1);
			sb.setProcMobErr(1);
			sb.setProcMobErrMsg("Proctor Mobile Number is invalid");
		}
		if(!va.isMOB(father_mob)) {
			sb.setGenErr(1);
			sb.setFatherMobErr(1);
			sb.setFatherMobErrMsg("Father Mobile Number is invalid");
		}
		if(!va.isMOB(mother_mob)) {
			sb.setGenErr(1);
			sb.setMotherMobErr(1);
			sb.setMotherMobErrMsg("Mother Mobile number is invalid");
		}
		
		// All entered data is valid
		else {
			
			sb = db.registerStudentDetails(sb);
			
			//This is to check for existing username/usn
			if(sb.getGenErr() == 1) {
				if(sb.getUsnErr() == 1) {
					sb.setUsnErrMsg("USN Already Exists");
				}
				if(sb.getUserNameErr() == 1) {
					sb.setUserNameErrMsg("UserName Already Exists");
				}
				ArrayList<ClassBean> cList = db.getCourse();
				request.setAttribute("cl", cList);
			}
			else {
				
				ArrayList<ClassBean> cList = db.getCourse();
				request.setAttribute("cl", cList);
			}
		}
		
		ArrayList<ClassBean> cList = db.getCourse();
		request.setAttribute("cl", cList);
		request.setAttribute("sb", sb);

		return sb;
	}

	public void getStudentAttendance(HttpServletRequest request, HttpServletResponse response) {

		int stdID = Integer.parseInt(request.getParameter("stdID"));
		StudentinfoDB db = new StudentinfoDB();
		ArrayList<AcademicsBean> attendanceList = db.getStudentAttendance(stdID);
		request.setAttribute("al",attendanceList);

	}

	public void getAcademicDetails(HttpServletRequest request, HttpServletResponse response) {

		int stdID = Integer.parseInt(request.getParameter("stdID"));
		StudentinfoDB db = new StudentinfoDB();
		ArrayList<AcademicsBean> marksList = db.getAcademicDetails(stdID);
		request.setAttribute("ml",marksList);

	}
}
