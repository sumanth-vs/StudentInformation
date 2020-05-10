package com.bms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.actions.StudentAction;
import com.bms.actions.UserAction;
import com.bms.bean.StudentBean;
import com.bms.bean.UserBean;

public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String action;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		action = request.getParameter("action");

		if(action != null) {
			action = action.trim();

			System.out.println("action = " + action);

			if(action.equals("getLoginPage")) {
				getLoginPage(request, response);
			}
			else if(action.equals("verifyLogin")) {
				verifyLogin(request, response);
			}
			else if(action.equals("logout")) {
				logout(request, response);
			}
			else if(action.equals("forgotPassword")) {

			}
			else if(action.equals("registerStudentPage")) {
				registerStudentPage(request, response);
			}
			else if(action.equals("registerStudentDetails")) {
				registerStudentDetails(request, response);
			}
			else if(action.equals("getStudentInfo")) {
				getStudentInfo(request, response);
			}
			else if(action.equals("getStudentHomepage")) {
				getStudentHomepage(request, response);
			}
			else if(action.equals("getStudentAttendance")) {
				getStudentAttendance(request, response);
			}
		}		
		else {			
		}
	}

	private final void getStudentAttendance(HttpServletRequest request, HttpServletResponse response) {
		
		// if you are a newly registered student then your records are not available yet
		StudentAction sa = new StudentAction();
		StudentBean sb = sa.getStudentAttendance(request, response);
		//request.setAttribute("sb", sb);
	}

	private final void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("ub", new UserBean());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
		rd.forward(request, response);
	}

	private final void getStudentHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentAction sa = new StudentAction();
		sa.getStudentInfo(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentHomepage.jsp");
		rd.forward(request, response);
	}

	private final void getStudentInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

		StudentAction sa = new StudentAction();
		sa.getStudentInfo(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentInfo.jsp");
		rd.forward(request, response);
	}

	private final void getLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("ub", new UserBean());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
		rd.forward(request, response);
	}

	private final void verifyLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserAction ua = new UserAction();
		UserBean ub = ua.verifyLogin(request, response);
		RequestDispatcher rd = null;

		if(ub.getGenErrFlag() == 1) {
			rd = getServletContext().getRequestDispatcher("/Login.jsp");
		}
		else {
			if(ub.getUserType() == 1) {
				rd = getServletContext().getRequestDispatcher("/AdminHomepage.jsp");
			}
			else if(ub.getUserType() == 2) {
				rd = getServletContext().getRequestDispatcher("/FacultyHomepage.jsp");
			}
			else {
				StudentBean sb = new StudentBean();
				sb.setName(ub.getName());
				sb.setStdid(ub.getUserID());
				System.out.println("name= "+sb.getName());
				request.setAttribute("sb", sb);
				rd = getServletContext().getRequestDispatcher("/StudentHomepage.jsp");
			}
		}		
		rd.forward(request, response);
	}

	private final void registerStudentPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentAction sa = new StudentAction();
		sa.getCourse(request, response);
		request.setAttribute("sb", new StudentBean());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/NewUser.jsp");
		rd.forward(request, response);
	}

	private final void registerStudentDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		StudentAction sa = new StudentAction();
		StudentBean sBean = sa.registerStudentDetails(request, response);
		
		if(sBean.getGenErr() == 1) {
			rd = getServletContext().getRequestDispatcher("/NewUser.jsp");
		}
		else {
			request.setAttribute("ub", new UserBean());
			rd = getServletContext().getRequestDispatcher("/Login.jsp");
		}
		
		rd.forward(request, response);
	}
}
