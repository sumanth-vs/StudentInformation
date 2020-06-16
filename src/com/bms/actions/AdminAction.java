package com.bms.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.ClassBean;
import com.bms.bean.FacultyBean;
import com.bms.bean.StudentBean;
import com.bms.db.AdminDB;

public class AdminAction {

	public void activateStudentAccount(HttpServletRequest request, HttpServletResponse response) {
		
		AdminDB db = new AdminDB();
		ArrayList<StudentBean> studentList = db.activateStudentAccount(request, response);
		
		request.setAttribute("sList", studentList);
	}

	public void addNewFaculty(HttpServletRequest request, HttpServletResponse response) {
		
		AdminDB db = new AdminDB();
		FacultyBean fb = new FacultyBean();
		
		fb.setUsername(request.getParameter("username"));
		fb.setPassword(request.getParameter("password"));
		fb.setFac_name(request.getParameter("fName"));
		fb.setMob(request.getParameter("fMob"));
		fb.setEmail(request.getParameter("fEmail"));
		
		db.addNewFaculty(fb);
	}

	public void addNewSubject(HttpServletRequest request, HttpServletResponse response) {
		
		AdminDB db = new AdminDB();
		FacultyBean fb = new FacultyBean();
		
		fb.setSub_name(request.getParameter("sub_name"));
		fb.setSub_short_name(request.getParameter("sub_s_name"));
		
		db.addNewSubject(fb);
	}

	public void addNewClass(HttpServletRequest request, HttpServletResponse response) {
		
		AdminDB db = new AdminDB();
		ClassBean cb = new ClassBean();
		
		cb.setSem(request.getParameter("sem"));
		cb.setSection(request.getParameter("section"));
		cb.setCourse(request.getParameter("course"));
		cb.setCourse_code(request.getParameter("course_code"));
		
		db.addNewClass(cb);
	}
}
