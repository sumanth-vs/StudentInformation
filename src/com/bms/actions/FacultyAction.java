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
}
