package com.bms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.RequestDispatcher;

import com.bms.bean.FacultyBean;import sun.security.action.GetIntegerAction;

public class FacultyDB {

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

	public ArrayList<FacultyBean> getFacultyClassDetails(int fac_id) {
		//select stud_t.student_id, stud_t.student_name, stud_sub.classes_cond, stud_sub.classes_attend from stud_t, stud_sub where stud_t.student_id = stud_sub.student_id and stud_t.class_id = 13 and stud_sub.sub_id = 2;
		//select stud_t.student_id, stud_t.student_name, stud_sub.classes_cond, stud_sub.classes_attend, subject_t.sub_name from stud_t, stud_sub, subject_t where stud_t.student_id = stud_sub.student_id and stud_t.class_id = 13 and stud_sub.sub_id = 2 and subject_t.sub_id = 2;
		Connection con = getConnection();
		String sql = "select c.semester, c.section, c.course, s.sub_name, s.sub_id, c.class_id from class_t c, subject_t s, faculty_sub_class_t fc where c.class_id = fc.class_id and fc.sub_id = s.sub_id and fc.fac_id = ?";		
		ArrayList<FacultyBean> facList = new ArrayList<FacultyBean>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fac_id);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				FacultyBean fb = new FacultyBean();
				fb.setFac_id(fac_id);
				fb.setSem(rs.getString(1));
				fb.setSection(rs.getString(2));
				fb.setCourse(rs.getString(3));
				fb.setSub_name(rs.getString(4));
				fb.setSub_id(rs.getInt(5));
				fb.setClass_id(rs.getInt(6));
				facList.add(fb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return facList;
	}

	public ArrayList<FacultyBean> getFacultyAttendance(int class_ID, int sub_ID) {

		Connection con = getConnection();
		String sql = "select stud_t.student_id, stud_t.student_name, stud_sub.classes_cond, stud_sub.classes_attend from stud_t, stud_sub where stud_t.student_id = stud_sub.student_id and stud_t.class_id = ? and stud_sub.sub_id = ? order by stud_t.student_name";		
		ArrayList<FacultyBean> facAttenList = new ArrayList<FacultyBean>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, class_ID);
			pstmt.setInt(2, sub_ID);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				FacultyBean fb = new FacultyBean();
				fb.setStudent_id(rs.getInt(1));
				fb.setStudent_name(rs.getString(2));
				fb.setClasses_cond(rs.getInt(3));
				fb.setClasses_attend(rs.getInt(4));
				facAttenList.add(fb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return facAttenList;
	}


	public ArrayList<FacultyBean> getFacultyMarks(int class_ID, int sub_ID) {

		Connection con = getConnection();
		String sql = "select stud_t.student_id, stud_t.student_name, stud_sub.cie1,stud_sub.cie2, stud_sub.cie3, stud_sub.lab from stud_t, stud_sub where stud_t.student_id = stud_sub.student_id and stud_t.class_id = ? and stud_sub.sub_id = ? order by stud_t.student_name";		
		ArrayList<FacultyBean> facMarksList = new ArrayList<FacultyBean>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, class_ID);
			pstmt.setInt(2, sub_ID);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				FacultyBean fb = new FacultyBean();
				fb.setStudent_id(rs.getInt(1));
				fb.setStudent_name(rs.getString(2));

				double cie1 = rs.getDouble(3);
				double cie2 = rs.getDouble(4);
				double cie3 = rs.getDouble(5);
				double lab = rs.getDouble(6);

				fb.setCie1(cie1);				
				fb.setCie2(cie2);
				fb.setCie3(cie3);
				fb.setLab(lab);

				facMarksList.add(fb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return facMarksList;
	}

	public FacultyBean getClassDetails(int class_id) {

		Connection con = getConnection();
		FacultyBean fb = new FacultyBean();
		String sql = "select semester, section, course from class_t where class_t.class_id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, class_id);			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				fb.setSem(rs.getString(1));
				fb.setSection(rs.getString(2));
				fb.setCourse(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fb;
	}

	public ArrayList<FacultyBean> addFacultyMarks(int class_ID, int sub_ID) {

		Connection con = getConnection();
		String sql = "select stud_t.student_id, stud_t.student_name from stud_t, stud_sub where stud_t.student_id = stud_sub.student_id and stud_t.class_id = ? and stud_sub.sub_id = ? order by stud_t.student_name";		
		ArrayList<FacultyBean> facMarksList = new ArrayList<FacultyBean>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, class_ID);
			pstmt.setInt(2, sub_ID);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				FacultyBean fb = new FacultyBean();
				fb.setStudent_id(rs.getInt(1));
				fb.setStudent_name(rs.getString(2));

				facMarksList.add(fb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return facMarksList;
	}

	public ArrayList<FacultyBean> addFacultyAttendance(int class_ID, int sub_ID) {

		Connection con = getConnection();
		String sql = "select stud_t.student_id, stud_t.student_name from stud_t, stud_sub where stud_t.student_id = stud_sub.student_id and stud_t.class_id = ? and stud_sub.sub_id = ?";		
		ArrayList<FacultyBean> facAttenList = new ArrayList<FacultyBean>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, class_ID);
			pstmt.setInt(2, sub_ID);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				FacultyBean fb = new FacultyBean();
				fb.setStudent_id(rs.getInt(1));
				fb.setStudent_name(rs.getString(2));
				facAttenList.add(fb);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return facAttenList;
	}

	public int addFacultyMarksValues(String intType, String[] marks, String[] ids, int sub_ID) {

		Connection con = getConnection();

		String sql1 = "update stud_sub set cie1 = ? where sub_id = ? and student_id = ?";
		String sql2 = "update stud_sub set cie2 = ? where sub_id = ? and student_id = ?";
		String sql3 = "update stud_sub set cie3 = ? where sub_id = ? and student_id = ?";
		String sql4 = "update stud_sub set lab = ? where sub_id = ? and student_id = ?";
		int rs = 0;
		
		try {			
			
			for(int i = 0; i < marks.length; i++) {
				
				if(intType.equals("cie1")) {
					
					PreparedStatement pstmt = con.prepareStatement(sql1);
					pstmt.setInt(3, Integer.parseInt(ids[i]));
					pstmt.setInt(2, sub_ID);
					pstmt.setFloat(1, Float.parseFloat(marks[i]));
					System.out.println("in db marks cie1 = "+Float.parseFloat(marks[i]));
					rs = pstmt.executeUpdate();
				}
				else if(intType.equals("cie2")) {

					PreparedStatement pstmt = con.prepareStatement(sql2);
					pstmt.setInt(3, Integer.parseInt(ids[i]));
					pstmt.setInt(2, sub_ID);
					pstmt.setFloat(1, Float.parseFloat(marks[i]));
					System.out.println("in db marks cie2 = "+marks[i]);
					rs = pstmt.executeUpdate();
				}
				else if(intType.equals("cie3")) {


					PreparedStatement pstmt = con.prepareStatement(sql3);
					pstmt.setInt(3, Integer.parseInt(ids[i]));
					pstmt.setInt(2, sub_ID);
					pstmt.setFloat(1, Float.parseFloat(marks[i]));
					System.out.println("in db marks cie3 = " + Float.parseFloat(marks[i]));
					rs = pstmt.executeUpdate();
				}
				else if(intType.equals("lab")) {

					PreparedStatement pstmt = con.prepareStatement(sql4);
					pstmt.setInt(3, Integer.parseInt(ids[i]));
					pstmt.setInt(2, sub_ID);
					pstmt.setFloat(1, Float.parseFloat(marks[i]));
					rs = pstmt.executeUpdate();
				}

				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	public int addFacultyAttendanceValues(String[] classesCond, String[] classesAttend, String[] ids, int sub_ID) {

		Connection con = getConnection();
		String sql = "update stud_sub set classes_cond = ?, CLASSES_ATTEND = ? where student_id = ? and sub_id = ?";
		int rs = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			for(int i = 0; i < classesAttend.length; i++) {

				pstmt.setInt(1, Integer.parseInt(classesCond[i]));
				pstmt.setInt(2, Integer.parseInt(classesAttend[i]));
				pstmt.setInt(3, Integer.parseInt(ids[i]));
				pstmt.setInt(4, sub_ID);

				rs = pstmt.executeUpdate();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}

	public void editFacultyMarks(int class_ID, int sub_ID, int student_ID) {
		
		Connection con = getConnection();
		String sql = "update stud_sub set classes_cond = ?, CLASSES_ATTEND = ? where student_id = ? and sub_id = ?";
		int rs = 0;

	}
}
