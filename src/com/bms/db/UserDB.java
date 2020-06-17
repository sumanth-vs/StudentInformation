package com.bms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.UserBean;

public class UserDB {
	
	private Connection getConnection() {

		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sampleweb","sampleweb");
			//System.out.println("inDB con=" + con);
		} 
		catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} 
		catch (SQLException e) {			
			e.printStackTrace();
		}
		return con;			
	}
	
	public UserBean verifyLogin(UserBean ub) {
		
		String sql = "select count(user_id) from user_t where user_name = ? and password = ?";
		String sql1 = "select user_type, user_id from user_t where user_name = ? and password = ?";
		//String sql2 = "select student_name from student_t where student_id = ?";
		//String sql3 = "select fac_name from faculty_t where fac_id = ?";
		
		Connection con = getConnection();
		int count = 0;
		int user_id = 0, user_type = 0;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			PreparedStatement pstmt2 = con.prepareStatement("select fac_name, fac_id from faculty_t where fac_id = ?");
			PreparedStatement pstmt3 = con.prepareStatement("select student_name, usn, semester, section, course from stud_t s, class_t c where s.class_id = c.class_id and s.student_id = ?");
			PreparedStatement pstmtStatus = con.prepareStatement("select user_flag from user_t where user_name = ?");
			
			
			pstmt.setString(1,  ub.getUserName());
			pstmt.setString(2, ub.getPassword());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
			if(count == 0) {
				ub.setGenErrFlag(1);
			}
			else {
				ub.setGenErrFlag(0);
				
				pstmt1.setString(1,  ub.getUserName());
				pstmt1.setString(2,  ub.getPassword());
				ResultSet rs1 = pstmt1.executeQuery();
				
				while(rs1.next()) {
					user_type = rs1.getInt(1);
					user_id = rs1.getInt(2);
					ub.setUserType(user_type);
					ub.setUserID(user_id);
				}
				
				ResultSet rs2 = null;
				if(user_type == 2) {
					pstmt2.setInt(1,  ub.getUserID());
					rs2 = pstmt2.executeQuery();
					
					while(rs2.next()) {
						ub.setName(rs2.getString(1));
						ub.setUserID(rs2.getInt(2));
					}
				}
				else if(user_type == 3) {
					pstmtStatus.setString(1, ub.getUserName());
					ResultSet rStat = pstmtStatus.executeQuery();
					int status = 0;
					
					while(rStat.next()) {
						status = rStat.getInt(1);
					}
					
					if(status == 1) {
						pstmt3.setInt(1,  ub.getUserID());
						rs2 = pstmt3.executeQuery();
						
						while(rs2.next()) {
							ub.setName(rs2.getString(1));
							ub.setUsn(rs2.getString(2));
							ub.setSem(rs2.getString(3));
							ub.setSection(rs2.getString(4));
							ub.setCourse(rs2.getString(5));
						}
						
					}
					else {
						ub.setGenErrFlag(2);
						ub.setStatusFlg(1);
					}					
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ub;
	}

	public UserBean checkForgotUsername(String username) {
		
		Connection con = getConnection();		
		String sql = "select count(user_id) from user_t where user_name = ?";
		UserBean ub = new UserBean();
		
		int count = 1;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
			if(count == 0) {
				ub.setGenErrFlag(1);
			}
			else {
				ub.setGenErrFlag(0);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ub;
	}

	public UserBean getAdminHomepage(UserBean ub) {

		Connection con = getConnection();		
		String sql = "select user_name from user_t where user_id = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ub.getUserID());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ub.setUserName(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ub;
	}

}
