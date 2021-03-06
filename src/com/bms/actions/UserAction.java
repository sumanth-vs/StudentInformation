package com.bms.actions;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
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
		else if(uBean.getGenErrFlag() == 2) {
			if(uBean.getStatusFlg() == 1) {
				uBean.setStatusMsg("Account Needs to be activated");
			}
		}
		
		request.setAttribute("ub", ub);

		return uBean;
	}

	public UserBean checkForgotUsername(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		UserDB db = new UserDB();
		UserBean ub = db.checkForgotUsername(username);
		
		if(ub.getGenErrFlag() == 1) {
			ub.setGenErrMsg("UserName does not exist");
		}
		
		return ub;
	}

	public UserBean getAdminHomepage(UserBean ub) {

		UserDB db = new UserDB();
		
		UserBean uBean = new UserBean();
		uBean.setUserID(ub.getUserID());
		ub = db.getAdminHomepage(ub);
		uBean.setUserName(ub.getUserName());
		
		return uBean;
	}


}
