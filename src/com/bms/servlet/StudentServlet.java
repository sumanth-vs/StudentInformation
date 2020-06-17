package com.bms.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.actions.FacultyAction;
import com.bms.actions.StudentAction;
import com.bms.actions.AdminAction;
import com.bms.actions.UserAction;
import com.bms.bean.FacultyBean;
import com.bms.bean.StudentBean;
import com.bms.bean.UserBean;

public class StudentServlet extends HttpServlet {

	private HttpSession session = null;

	private static final long serialVersionUID = 1L;

	private String action;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		action = request.getParameter("action");

		if (action != null) {
			action = action.trim();

			System.out.println("action = " + action);

			if (action.equals("getLoginPage")) {
				getLoginPage(request, response);
			} else if (action.equals("verifyLogin")) {
				verifyLogin(request, response);
			} else if (action.equals("logout")) {
				logout(request, response);
			} else if (action.equals("registerStudentPage")) {
				registerStudentPage(request, response);
			} else if (action.equals("registerStudentDetails")) {
				registerStudentDetails(request, response);
			} else if (action.equals("getStudentInfo")) {
				getStudentInfo(request, response);
			} else if (action.equals("getStudentHomepage")) {
				getStudentHomepage(request, response);
			} else if (action.equals("getStudentAttendance")) {
				getStudentAttendance(request, response);
			} else if (action.equals("getAcademicDetails")) {
				getAcademicDetails(request, response);
			} else if (action.equals("getStudentProjects")) {
				getStudentProjects(request, response);
			} else if (action.equals("aboutPage")) {
				aboutPage(request, response);
			} else if (action.equals("aboutPageNoLogin")) {
				aboutPageNoLogin(request, response);
			} else if (action.equals("aboutPageFaculty")) {
				aboutPageFaculty(request, response);
			} else if (action.equals("getFacultyClassDetails")) {
				getFacultyClassDetails(request, response);
			} else if (action.equals("getStudentList")) {
				getStudentList(request, response);
			} else if (action.equals("getFacultyHomepage")) {
				getFacultyHomepage(request, response);
			} else if (action.equals("getFacultyAttendance")) {
				getFacultyAttendance(request, response);
			} else if (action.equals("getFacultyMarks")) {
				getFacultyMarks(request, response);
			} else if (action.equals("editFacultyAttendance")) {
				editFacultyAttendance(request, response);
			} else if (action.equals("editFacultyMarks")) {
				editFacultyMarks(request, response);
			} else if (action.equals("backToStudentHomepage")) {
				backToStudentHomepage(request, response);
			} else if (action.equals("backToFacultyHomepage")) {
				backToFacultyHomepage(request, response);
			} else if (action.equals("backToHomepage")) {
				backToHomepage(request, response);
			} else if (action.equals("forgotPassword")) {
				forgotPassword(request, response);
			} else if (action.equals("checkForgotUsername")) {
				checkForgotUsername(request, response);
			} else if (action.equals("addFacultyAttendance")) {
				addFacultyAttendance(request, response);
			} else if (action.equals("addFacultyAttendanceValues")) {
				addFacultyAttendanceValues(request, response);
			} else if (action.equals("addFacultyMarks")) {
				addFacultyMarks(request, response);
			} else if (action.equals("addFacultyMarksValues")) {
				addFacultyMarksValues(request, response);
			}
			else if(action.equals("getAdminHoepage")) {
				getAdminHomepage(request, response);
			}
			else if(action.equals("activateStudentAccount")) {
				activateStudentAccount(request, response);
			}
			else if(action.equals("getNewFacultyPage")) {
				getNewFacultyPage(request, response);
			}
			else if(action.equals("addNewFaculty")) {
				addNewFaculty(request, response);
			}
			else if(action.equals("getAddNewSubjectPage")) {
				getAddNewSubjectPage(request, response);
			}
			else if(action.equals("addNewSubject")) {
				addNewSubject(request, response);
			}
			else if(action.equals("getAddNewClassPage")) {
				getAddNewClassPage(request, response);
			}
			else if(action.equals("addNewClass")) {
				addNewClass(request, response);
			}
			else if(action.equals("getAssignFacultyPage")) {
				getAssignFacultyPage(request, response);
			}
			else if(action.equals("assignFaculty")) {
				assignFaculty(request, response);
			}
			else if(action.equals("getAssignSubjectPage")) {
				getAssignSubjectPage(request, response);
			}
			else if(action.equals("assignSubject")) {
				assignSubject(request, response);
			}
		} 
		
		else {
		}
	}

	private void assignSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		AdminAction aa = new AdminAction();
		aa.assignSubject(request, response);
		// Should -> Home Page
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AssignSubjectPage.jsp");
		rd.forward(request, response);
	}

	private void getAssignSubjectPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AssignSubjectPage.jsp");
		rd.forward(request, response);
	}

	private void assignFaculty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		AdminAction aa = new AdminAction();
		aa.assignFaculty(request, response);
		// Should -> Home Page
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AssignFacultyPage.jsp");
		rd.forward(request, response);
	}

	private void getAssignFacultyPage(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AssignFacultyPage.jsp");
		rd.forward(request, response);
	}

	private void getAddNewClassPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddNewClassPage.jsp");
		rd.forward(request, response);

	}

	private void getNewFacultyPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddNewFacultyPage.jsp");
		rd.forward(request, response);
	}
	private void getAddNewSubjectPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddNewSubjectPage.jsp");
		rd.forward(request, response);
	}

	private void addNewClass(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		AdminAction aa = new AdminAction();
		aa.addNewClass(request, response);
		// Should -> Home Page
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddNewClassPage.jsp");
		rd.forward(request, response);
	}

	private void addNewSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		AdminAction aa = new AdminAction();
		aa.addNewSubject(request, response);
		// Should -> Home Page
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddNewSubjectPage.jsp");
		rd.forward(request, response);
	}

	private void addNewFaculty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		AdminAction aa = new AdminAction();
		aa.addNewFaculty(request, response);
		// Should -> Home Page
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddNewFacultyPage.jsp");
		rd.forward(request, response);
	}

	private void activateStudentAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		AdminAction aa = new AdminAction();
		aa.activateStudentAccount(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminAccountStatus.jsp");
		rd.forward(request, response);
	}

	private void getAdminHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	private void addFacultyMarksValues(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FacultyAction fa = new FacultyAction();
		fa.addFacultyMarksValues(request, response);

		// Call this to display values in facultyMarks
		ArrayList<FacultyBean> marksList = fa.getFacultyMarks(request, response);
		request.setAttribute("marksL", marksList);
		fa.getClassDetails(request, response);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FacultyMarks.jsp");
		rd.forward(request, response);
	}

	private void addFacultyAttendanceValues(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FacultyAction fa = new FacultyAction();
		fa.addFacultyAttendanceValues(request, response);

		//Call this to display values in facultyAttendance

		fa.getFacultyAttendance(request, response); 
		fa.getClassDetails(request,response);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FacultyAttendance.jsp");
		rd.forward(request, response);
	}

	private void addFacultyMarks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FacultyAction fa = new FacultyAction();
		fa.addFacultyMarks(request, response);
		fa.getClassDetails(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddFacultyMarks.jsp");
		rd.forward(request, response);
	}

	private void addFacultyAttendance(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FacultyAction fa = new FacultyAction();
		fa.addFacultyAttendance(request, response);
		fa.getClassDetails(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddFacultyAttendance.jsp");
		rd.forward(request, response);
	}

	private void checkForgotUsername(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		UserAction ua = new UserAction();
		UserBean ub = ua.checkForgotUsername(request, response);

		if (ub.getGenErrFlag() == 1) {
			request.setAttribute("ub", ub);
			rd = getServletContext().getRequestDispatcher("/ForgotPassword.jsp");
		} else {
			rd = getServletContext().getRequestDispatcher("/ForgotPasswordEmail.jsp");
		}
		rd.forward(request, response);
	}

	private void forgotPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("ub", new UserBean());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ForgotPassword.jsp");
		rd.forward(request, response);
	}

	private void backToFacultyHomepage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FacultyHomepage.jsp");
		rd.forward(request, response);
	}

	private void backToHomepage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	private void backToStudentHomepage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentHomepage.jsp");
		rd.forward(request, response);
	}

	private void editFacultyAttendance(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FacultyAction fa = new FacultyAction();
		fa.editFacultyAttendance(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FacultyAttendance.jsp");
		rd.forward(request, response);
	}

	private void editFacultyMarks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FacultyAction fa = new FacultyAction();
		fa.editFacultyMarks(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FacultyAttendance.jsp");
		rd.forward(request, response);
	}

	private void getFacultyMarks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FacultyAction fa = new FacultyAction();
		fa.getFacultyMarks(request, response);
		fa.getClassDetails(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FacultyMarks.jsp");
		rd.forward(request, response);
	}

	private void getFacultyAttendance(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FacultyAction fa = new FacultyAction();
		fa.getFacultyAttendance(request, response);
		fa.getClassDetails(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FacultyAttendance.jsp");
		rd.forward(request, response);
	}

	private void getFacultyHomepage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FacultyHomepage.jsp");
		rd.forward(request, response);
	}

	private void getStudentList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("");
		rd.forward(request, response);
	}

	private void getFacultyClassDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FacultyAction fa = new FacultyAction();
		fa.getFacultyClassDetails(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/FacultyClass.jsp");
		rd.forward(request, response);
	}

	private void aboutPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/About.jsp");
		rd.forward(request, response);
	}

	private void aboutPageNoLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AboutNoLogin.jsp");
		rd.forward(request, response);
	}

	private void aboutPageFaculty(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AboutFaculty.jsp");
		rd.forward(request, response);
	}

	private void getStudentProjects(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Projects.jsp");
		rd.forward(request, response);
	}

	private void getAcademicDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// System.out.println("inside servlet getacademics");
		StudentAction sa = new StudentAction();
		sa.getAcademicDetails(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Academics.jsp");
		rd.forward(request, response);
	}

	private final void getStudentAttendance(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// if you are a newly registered student then your records are not available yet
		StudentAction sa = new StudentAction();
		sa.getStudentAttendance(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Attendance.jsp");
		rd.forward(request, response);
	}

	private final void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("ub", new UserBean());
		session.removeAttribute("ub");
		session.invalidate();

		session = null;
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
		rd.forward(request, response);
	}

	private final void getStudentHomepage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentAction sa = new StudentAction();
		sa.getStudentInfo(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentHomepage.jsp");
		rd.forward(request, response);
	}

	private final void getStudentInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentAction sa = new StudentAction();
		sa.getStudentInfo(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentInfo.jsp");
		rd.forward(request, response);
	}

	private final void getLoginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("ub", new UserBean());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
		rd.forward(request, response);
	}

	private final void verifyLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserAction ua = new UserAction();
		UserBean ub = ua.verifyLogin(request, response);
		RequestDispatcher rd = null;

		if (ub.getGenErrFlag() == 1) {
			rd = getServletContext().getRequestDispatcher("/Login.jsp");
		} 

		else if(ub.getGenErrFlag() == 2) {
			rd = getServletContext().getRequestDispatcher("/Login.jsp");
		}

		else {
			session = request.getSession(true);
			session.setAttribute("ub", ub);

			if (ub.getUserType() == 1) {
				rd = getServletContext().getRequestDispatcher("/AdminHomepage.jsp");
			} else if (ub.getUserType() == 2) {
				rd = getServletContext().getRequestDispatcher("/FacultyHomepage.jsp");
			} else {
				StudentBean sb = new StudentBean();
				sb.setName(ub.getName());
				sb.setStdid(ub.getUserID());
				request.setAttribute("sb", sb);
				rd = getServletContext().getRequestDispatcher("/StudentHomepage.jsp");
			}
		}
		rd.forward(request, response);
	}

	private final void registerStudentPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentAction sa = new StudentAction();
		sa.getCourse(request, response);
		request.setAttribute("sb", new StudentBean());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/NewUser.jsp");
		rd.forward(request, response);
	}

	private final void registerStudentDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		StudentAction sa = new StudentAction();
		StudentBean sBean = sa.registerStudentDetails(request, response);

		if (sBean.getGenErr() == 1) {
			rd = getServletContext().getRequestDispatcher("/NewUser.jsp");
		} else {
			request.setAttribute("ub", new UserBean());
			rd = getServletContext().getRequestDispatcher("/Login.jsp");
		}
		rd.forward(request, response);
	}
}
