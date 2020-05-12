package com.bms.actions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.UserBean;
import com.bms.db.UserDB;

public class UserAction extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public UserBean verifyLogin(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username != null) {
			username = username.trim();
		}
		if(password != null) {
			password = password.trim();
		}

		UserBean ub = new UserBean();
		ub.setUserName(username);
		ub.setPassword(password);

		UserDB db = new UserDB();
		UserBean uBean = db.verifyLogin(ub);

		if(uBean.getGenErrFlag() == 1) {
			uBean.setGenErrMsg("Invalid Username/Password");
		}

		request.setAttribute("ub", ub);

		return uBean;
	}


}
