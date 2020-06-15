package com.bms.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.StudentBean;
import com.bms.db.UserDB;

public class AdminAction {

	public void activateStudentAccount(HttpServletRequest request, HttpServletResponse response) {
		
		UserDB db = new UserDB();
		ArrayList<StudentBean> studentList = db.activateStudentAccount(request, response);
		
		request.setAttribute("sList", studentList);
	}
}
