package com.bms.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.ClassBean;
import com.bms.bean.StudentBean;
import com.bms.db.StudentinfoDB;

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
		
		
		StudentinfoDB db = new StudentinfoDB();
		StudentBean sBean = db.registerStudentDetails(sb);
		
		
		if(sBean.getGenErr() == 1) {
			if(sBean.getUsnErr() == 1) {
				sb.setUsnErrMsg("USN Already Exists");
			}
			if(sBean.getUserNameErr() == 1) {
				sb.setUserNameErrMsg("UserName Already Exists");
			}
			ArrayList<ClassBean> cList = db.getCourse();
			request.setAttribute("cl", cList);
		}
		
		request.setAttribute("sb", sBean);
		
		return sBean;
	}

	public StudentBean getStudentAttendance(HttpServletRequest request, HttpServletResponse response) {
		
		int stdID = Integer.parseInt(request.getParameter("stdID"));
		StudentinfoDB db = new StudentinfoDB();
		StudentBean sBean = db.getStudentAttendance(stdID);
		
		return sBean;
		
	}
}
