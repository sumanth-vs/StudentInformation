package com.bms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Types;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.ClassBean;
import com.bms.bean.FacultyBean;
import com.bms.bean.StudentBean;

public class AdminDB {

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



	public ArrayList<StudentBean> activateStudentAccount(HttpServletRequest request, HttpServletResponse response) {

		Connection con = getConnection();		
		String sql = "select s.student_name, s.usn, s.stud_email, s.stud_mob, s.stud_address, s.father_name, s.father_mob, s.mother_name, s.mother_mob, s.class_id, u.user_flag from stud_t s,  user_t u where s.student_id = u.user_id and u.user_type = 3";
		ArrayList<StudentBean> studentList = new ArrayList<StudentBean>();


		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				StudentBean sb = new StudentBean();
				sb.setName(rs.getString(1));
				sb.setUsn(rs.getString(2));
				sb.setEmail(rs.getString(3));
				sb.setMob(rs.getString(4));
				sb.setAddress(rs.getString(5));
				sb.setFather_name(rs.getString(6));
				sb.setFather_mob(rs.getString(7));
				sb.setMother_name(rs.getString(8));
				sb.setMother_mob(rs.getString(9));
				sb.setClass_id(rs.getInt(10));
				sb.setStatus(rs.getInt(11));

				studentList.add(sb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return studentList;
	}



	public void addNewFaculty(FacultyBean fb) {

		Connection con = getConnection();

		int user_id = 0;
		String sql1 = "select user_id.nextval from dual";
		String sql2 = "insert into user_t values(?, ?, ?, ?, ?)";
		String sql3 = "insert into faculty_t values(?, ?, ?, ?)";

		try {
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			ResultSet rs = pstmt1.executeQuery();

			while(rs.next()) {
				user_id = rs.getInt(1);
			}


			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, user_id);
			pstmt2.setInt(2, 2); // USER TYPE FOR TEACHER IS 2
			pstmt2.setString(3, fb.getUsername());
			pstmt2.setString(4, fb.getPassword());
			pstmt2.setInt(5, 1); // SET USER FLAG TO 1

			int user_res = pstmt2.executeUpdate();



			PreparedStatement pstmt3 = con.prepareStatement(sql3);
			pstmt3.setInt(1, user_id);
			pstmt3.setString(2, fb.getFac_name());
			pstmt3.setString(3, fb.getMob());
			pstmt3.setString(4, fb.getEmail());

			int fac_res = pstmt3.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



	public void addNewSubject(FacultyBean fb) {

		Connection con = getConnection();

		int sub_id = 0;
		//wont work yet --> have to generate sequence
		String sql1 = "select sub_id.nextval from dual";
		String sql2 = "insert into subject_t values(?, ?, ?, ?)";

		try {
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			ResultSet rs = pstmt1.executeQuery();

			while(rs.next()) {
				sub_id = rs.getInt(1);
			}


			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, sub_id);
			pstmt2.setString(2, fb.getSub_name()); // USER TYPE FOR TEACHER IS 2
			pstmt2.setString(3, fb.getSub_short_name());
			pstmt2.setInt(4, 1);// SET USER FLAG TO 1

			int res = pstmt2.executeUpdate();



		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



	public void addNewClass(ClassBean cb) {

		Connection con = getConnection();

		int class_id = 0;
		//wont work yet --> have to generate sequence
		String sql1 = "select class_id.nextval from dual";
		String sql2 = "insert into class_t values(?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			ResultSet rs = pstmt1.executeQuery();

			while(rs.next()) {
				class_id = rs.getInt(1);
			}


			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, class_id);
			pstmt2.setString(2, cb.getSem()); // USER TYPE FOR TEACHER IS 2
			pstmt2.setString(3, cb.getSection());
			pstmt2.setString(4, cb.getCourse());
			pstmt2.setString(5, cb.getCourse_code());

			int res = pstmt2.executeUpdate();



		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void assignFaculty(FacultyBean fb) {

		Connection con = getConnection();

		String sql = "insert into faculty_sub_class_t values(?, ?, ?)";


		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fb.getFac_id());
			pstmt.setInt(2, fb.getSub_id());
			pstmt.setInt(3, fb.getClass_id());

			int res = pstmt.executeUpdate();



		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void assignSubject(StudentBean sb) {

		Connection con = getConnection();
	    int sqlType = Types.NULL;
		String sql = "insert into stud_sub values(?, ?, ?, ?, ?, ?, ?, ?)";


		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sb.getStdid());
			pstmt.setInt(2, sb.getSub_id());
			pstmt.setNull(3, sqlType);
			pstmt.setNull(4, sqlType);
			pstmt.setNull(5, sqlType);
			pstmt.setNull(6, sqlType);
			pstmt.setNull(7, sqlType);
			pstmt.setNull(8, sqlType);

			int res = pstmt.executeUpdate();



		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
