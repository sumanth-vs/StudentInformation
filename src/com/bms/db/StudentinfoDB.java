package com.bms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.bms.bean.AcademicsBean;
import com.bms.bean.ClassBean;
import com.bms.bean.StudentBean;

public class StudentinfoDB {

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
	
	
	
	public StudentBean getStudentInfo(int stdId) {
		
		String sql = "select * from stud_t, class_t where stud_t.class_id = class_t.class_id and stud_t.student_id = ?";
		Connection con = getConnection();
		StudentBean sb = new StudentBean();
		sb.setStdid(stdId);
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sb.setName(rs.getString(2));
				sb.setUsn(rs.getString(3));
				sb.setEmail(rs.getString(4));
				sb.setMob(rs.getString(5));
				sb.setAddress(rs.getString(6));
				sb.setProc_name(rs.getString(7));
				sb.setProc_mob(rs.getString(8));
				sb.setFather_name(rs.getString(9));
				sb.setFather_mob(rs.getString(10));
				sb.setMother_name(rs.getString(11));
				sb.setMother_mob(rs.getString(12));
				//sb.setClass_id(rs.getInt(13));
				sb.setSemester(rs.getString(15));
				sb.setSection(rs.getString(16));
				sb.setCourse(rs.getString(17));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return sb;
	}
	
	
	public StudentBean getStudentHomepage(int stdId) { 
		String sql = "select student_name from stud_t where student_id = ?";
		Connection con = getConnection();
		StudentBean sb = new StudentBean();
		sb.setStdid(stdId);
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sb.setName(rs.getString(2));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return sb;
	}
	
	public ArrayList<ClassBean> getCourse() {
		
		Connection con = getConnection();
		ClassBean cb = null;
		ArrayList<ClassBean> courseList = new ArrayList<ClassBean>();
		String sql = "select * from class_t";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cb = new ClassBean();
				cb.setClassID(rs.getInt(1));
				cb.setSem(rs.getString(2));
				cb.setSection(rs.getString(3));
				cb.setCourse_code(rs.getString(5));
				cb.setCourse(rs.getString(4));
				
				courseList.add(cb);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return courseList;
	}



	public StudentBean registerStudentDetails(StudentBean sb) {
		
		Connection con = getConnection();
		String sql1 = "select count(user_name) from user_t where user_name = ?";
		String sql2 = "select count(usn) from stud_t where usn = ?";
		String sql3 = "select user_id.nextval from dual";
		String sql4 = "insert into user_t values(?, ?, ?, ?, ?)";
		String sql5 = "insert into stud_t values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int unCount = 0;
		int usnCount = 0;
		int user_id = 0;
		int count = 0;
		
		
		try {
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			
			pstmt1.setString(1, sb.getUsername());
			pstmt2.setString(1, sb.getUsn());
			
			ResultSet rs1 = pstmt1.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();
			
			while(rs1.next()) {
				unCount = rs1.getInt(1);
			}
			while(rs2.next()) {
				usnCount = rs2.getInt(1);
				//System.out.println("in db usnCOUNT = "+usnCount);
			}
			
			if(unCount == 0 && usnCount ==0) {
				PreparedStatement pstmt3 = con.prepareStatement(sql3);
				ResultSet rs3 = pstmt3.executeQuery();
				
				while(rs3.next()) {
					user_id = rs3.getInt(1);
				}
				PreparedStatement pstmt4 = con.prepareStatement(sql4);
				pstmt4.setInt(1, user_id);
				pstmt4.setInt(2, 3);
				pstmt4.setString(3, sb.getUsername());
				pstmt4.setString(4, sb.getPassword());
				//set flag to 1 for now
				pstmt4.setInt(5, 1);
				
				count = pstmt4.executeUpdate();
				
				if(count == 1) {
					PreparedStatement pstmt5 = con.prepareStatement(sql5);
					pstmt5.setInt(1, user_id);
					pstmt5.setString(2, sb.getName());
					pstmt5.setString(3, sb.getUsn());
					pstmt5.setString(4, sb.getEmail());
					pstmt5.setString(5, sb.getMob());
					pstmt5.setString(6, sb.getAddress());
					pstmt5.setString(7, sb.getProc_name());
					pstmt5.setString(8, sb.getProc_mob());
					pstmt5.setString(9, sb.getFather_name());
					pstmt5.setString(10, sb.getFather_mob());
					pstmt5.setString(11, sb.getMother_name());
					pstmt5.setString(12, sb.getMother_mob());
					pstmt5.setInt(13, sb.getClass_id());
					
					//System.out.println("before inserting into std_t");
					int count2 = pstmt5.executeUpdate();
					//System.out.println("after inserting into std_t");					
				}
				else {
					sb.setGenErr(1);
					sb.setUsnErr(1);
					
				}
			}
			else {
				sb.setGenErr(1);
				if(unCount == 1) {
					sb.setUserNameErr(1);
				}
				if(usnCount == 1) {
					sb.setUsnErr(1);
				}
				
			}
			
			
			//System.out.println("");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sb;
	}


	//ATTENDANCE
	public ArrayList<AcademicsBean> getStudentAttendance(int stdID) {
		
		System.out.println("in DB, stdID = " + stdID);
		Connection con = getConnection();
		ArrayList<AcademicsBean> attendanceList = new ArrayList<AcademicsBean>();
		
		String sql = "select sub_name, classes_cond, classes_attend from subject_t, stud_sub where stud_sub.sub_id = subject_t.sub_id and stud_sub.student_id = ?";
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stdID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				AcademicsBean aBean = new AcademicsBean();
				aBean.setSubject(rs.getString(1));
				aBean.setClass_cond(rs.getInt(2));
				aBean.setClass_attend(rs.getInt(3));
				
				attendanceList.add(aBean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return attendanceList;
	}
	
	// MARKS
	public ArrayList<AcademicsBean> getAcademicDetails(int stdID) {
		
		
		Connection con = getConnection();
		ArrayList<AcademicsBean> marksList = new ArrayList<AcademicsBean>();
		
		String sql = "select sub_name, cie1, cie2, cie3, lab from subject_t, stud_sub where stud_sub.sub_id = subject_t.sub_id and stud_sub.student_id = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stdID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				AcademicsBean aBean = new AcademicsBean();
				aBean.setSubject(rs.getString(1));
				aBean.setCie1(rs.getInt(2));
				aBean.setCie2(rs.getInt(3));
				aBean.setCie3(rs.getInt(4));
				aBean.setLab(rs.getInt(5));
				
				marksList.add(aBean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return marksList;
	}
	
}
