package com.bms.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.FacultyBean;
import com.bms.bean.StudentBean;
import com.bms.db.FacultyDB;
import com.bms.db.StudentinfoDB;

public class FacultyAction extends HttpServlet{

	public void getFacultyClassDetails(HttpServletRequest request, HttpServletResponse response) {


		int fac_id = Integer.parseInt(request.getParameter("facID"));
		FacultyDB db = new FacultyDB();
		ArrayList<FacultyBean> facList = db.getFacultyClassDetails(fac_id);
		request.setAttribute("fl", facList);
	}

	public ArrayList<FacultyBean> getFacultyAttendance(HttpServletRequest request, HttpServletResponse response) {


		int class_ID = Integer.parseInt(request.getParameter("classID"));
		int sub_ID = Integer.parseInt(request.getParameter("subID"));
		FacultyDB db = new FacultyDB();
		ArrayList<FacultyBean> attList = db.getFacultyAttendance(class_ID, sub_ID);
		request.setAttribute("attL", attList);
		
		return attList;
	}

	public ArrayList<FacultyBean> getFacultyMarks(HttpServletRequest request, HttpServletResponse response) {


		int class_ID = Integer.parseInt(request.getParameter("classID"));
		int sub_ID = Integer.parseInt(request.getParameter("subID"));
		FacultyDB db = new FacultyDB();
		ArrayList<FacultyBean> marksList = db.getFacultyMarks(class_ID, sub_ID);
		request.setAttribute("marksL", marksList);
		
		return marksList;
	}

	public void editFacultyAttendance(HttpServletRequest request, HttpServletResponse response) {
		
				
	}
	
	public void getClassDetails(HttpServletRequest request, HttpServletResponse response) {
		
		int class_id = Integer.parseInt(request.getParameter("classID"));
		FacultyDB db = new FacultyDB();
		FacultyBean fb = db.getClassDetails(class_id);
		
		request.setAttribute("fb", fb);
	}

	public ArrayList<FacultyBean> addFacultyMarks(HttpServletRequest request, HttpServletResponse response) {
		
		int class_ID = Integer.parseInt(request.getParameter("classID"));
		//System.out.println("In action classID = " + class_ID);
		int sub_ID = Integer.parseInt(request.getParameter("subID"));
		FacultyDB db = new FacultyDB();
		
		ArrayList<FacultyBean> marksList = db.addFacultyMarks(class_ID, sub_ID);
		request.setAttribute("addMarksL", marksList);
		request.setAttribute("subID", sub_ID);
		request.setAttribute("classID", class_ID);
		
		return marksList;
	}

	public ArrayList<FacultyBean> addFacultyAttendance(HttpServletRequest request, HttpServletResponse response) {

		int class_ID = Integer.parseInt(request.getParameter("classID"));
		int sub_ID = Integer.parseInt(request.getParameter("subID"));
		FacultyDB db = new FacultyDB();
		ArrayList<FacultyBean> attList = db.addFacultyAttendance(class_ID, sub_ID);
		request.setAttribute("addAttL", attList);
		request.setAttribute("subID", sub_ID);
		request.setAttribute("classID", class_ID);
		
		return attList;
		
	}

	public void editFacultyMarks(HttpServletRequest request, HttpServletResponse response) {
		
		int class_ID = Integer.parseInt(request.getParameter("classID"));
		int sub_ID = Integer.parseInt(request.getParameter("subID"));
		int student_ID = Integer.parseInt(request.getParameter("stdID"));
		
		FacultyDB db = new FacultyDB();
		
		db.editFacultyMarks(class_ID, sub_ID, student_ID);
		
	}

	public void addFacultyMarksValues(HttpServletRequest request, HttpServletResponse response) {
		
		String intType = request.getParameter("internalType");
		String[] marks = request.getParameterValues("internalMarks");
		String[] ids = request.getParameterValues("stdID");
		int sub_ID = Integer.parseInt(request.getParameter("subID"));
		
		FacultyDB db = new FacultyDB();
		
		int res = db.addFacultyMarksValues(intType, marks, ids, sub_ID);
	}

	public void addFacultyAttendanceValues(HttpServletRequest request, HttpServletResponse response) {
		
		String[] classesCond = request.getParameterValues("classesCond");
		String[] classesAttend = request.getParameterValues("classesAttend");		
		String[] ids = request.getParameterValues("stdID");
		int sub_ID = Integer.parseInt(request.getParameter("subID"));
		FacultyDB db = new FacultyDB();
		
		int res = db.addFacultyAttendanceValues(classesCond, classesAttend, ids, sub_ID);
	}
}
