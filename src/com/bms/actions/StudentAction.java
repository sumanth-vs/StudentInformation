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
		//StudentBean sBean = null;

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

		Validator va = new Validator();

		if(!(va.isName(name) && va.isName(mother_name) && va.isName(father_name) && va.isName(proc_name))){
			sb.setGenErr(1);
			sb.setNameErr(1);
			sb.setNameErrMsg("Name must include only Alphabets");
		}
		if(!va.isUSN(usn)) {
			sb.setGenErr(1);
			sb.setUsnErr(1);
			sb.setUsnErrMsg("Invalid USN Format");
		}
		if(!va.isEmail(email)) {
			sb.setGenErr(1);
			sb.setEmailErr(1);
			sb.setEmailErrMsg("Email is not Valid");
		}
		if(!va.isMOB(mother_mob)) {
			sb.setGenErr(1);
			sb.setMotherMobErr(1);
			sb.setMotherMobErrMsg("Invalid Mother's Mobile Number");
		}
		if(!va.isMOB(father_mob)) {
			sb.setGenErr(1);
			sb.setFatherMobErr(1);
			sb.setFatherMobErrMsg("Inavlid Father's Mobile Number");
		}
		if(!va.isMOB(proc_mob)) {
			sb.setGenErr(1);
			sb.setProcMobErr(1);
			sb.setProcMobErrMsg("Invalid Proctorr Mobile Number");
		}
		if(!va.isMOB(mob)) {
			sb.setGenErr(1);
			sb.setMobErr(1);
			sb.setMobErrMsg("Invalid Mobile Number");
		}
		
		
		if(va.isName(name) && va.isUSN(usn) && va.isEmail(email) && va.isMOB(mob) && va.isMOB(mother_mob) && va.isMOB(father_mob) && va.isMOB(proc_mob)) {
			
			//System.out.println("before callling db....in action");
			StudentinfoDB db = new StudentinfoDB();
			sb = db.registerStudentDetails(sb);
			
			
			if(sb.getGenErr() == 1) {
				System.out.println("sb.getUSNErr = "+sb.getUsnErr());
				if(sb.getUsnErr() == 1) {
					System.out.println("usn already exists? = "+sb.getUsnErr());
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
				sb.setGenErr(1);
				sb.setGenErrMsg("Data Invalid");
			}
		}
		else {
			StudentinfoDB db = new StudentinfoDB();
			ArrayList<ClassBean> cList = db.getCourse();
			request.setAttribute("cl", cList);
		}

		request.setAttribute("sb", sb);

		return sb;
	}

	public StudentBean getStudentAttendance(HttpServletRequest request, HttpServletResponse response) {

		int stdID = Integer.parseInt(request.getParameter("stdID"));
		StudentinfoDB db = new StudentinfoDB();
		StudentBean sBean = db.getStudentAttendance(stdID);

		return sBean;

	}
	
	public void getAcademicDetails(HttpServletRequest request, HttpServletResponse response) {
		
		int stdID = Integer.parseInt(request.getParameter("stdID"));
		StudentinfoDB db = new StudentinfoDB();
		ArrayList<AcademicsBean> marksList = db.getAcademicDetails(stdID);
		request.setAttribute("ml",marksList);
	
	}
}
