<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> attList = (ArrayList<FacultyBean>)request.getAttribute("addAttL"); %>
<%Iterator itr = attList.iterator(); %>
<%UserBean ub = (UserBean) session.getAttribute("ub"); %>




<html>

<head>
<title>Attendance</title>
<style>
body {
	background: black;
}

table {
	margin: 75px;
	border-collapse: collapse;
	width: 90%;
}

th, td {
	color: white;
	text-align: left;
	padding: 20px;
}

tr:nth-child(even) {
	background-color: #0b0c0c;
}
</style>
</head>

<body>

	<h1
		style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px; margin: 25px;">
		Monitor Your Students' Attendance
		</h2>
		<div>
			<img
				style="max-width: 100px; position: absolute; left: 43%; border-radius: 20px"
				src="Assets/teacher.jpg" alt="SurajFail">
		</div>
		<!-- <div style="margin: 80px;">
        <p style="font-family: Helvetica; color: white;">* Minimum attendance for eligibility is 85% in each course</p>
        <p style="font-family: Helvetica; color: white;">* Students with attendance above 75% must apply for condonation</p>
        <p style="font-family: Helvetica; color: white;">* Students with attendance below 75% are NOT ELIGIBLE to write the Semester End Examinations</p>
    </div> -->

		<div style="margin: 80px;">
			<h2
				style="font-family: Helvetica; color: white; position: absolute; top: 52%;">
				Semester :
				<%=ub.getSem() %>
				| Section :
				<%=ub.getSection() %>
				|Branch :
				<%=ub.getCourse() %>
			</h2>
		</div>

		<div
			style="overflow-x: auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute; top: 57%; left: 18%;">
			<table>

				<tr style="background-color: #818181;">
					<th>Student Name</th>
					<th>Classes Conducted</th>
					<th>Classes Attended</th>
				</tr>

				<%while(itr.hasNext()){ %>
				<%FacultyBean fb = (FacultyBean)itr.next(); %>
				<tr>
					<font color="white">
					<td><%=fb.getStudent_name() %></td>
					</font>
					
					<font color="white">
					<td><input type="text" name="classes_cond"></td>
					</font>
					
					<font color="white">
					<td><input type="text" name="classes_attend"></td>
					</font>					
				</tr>
				<%} %>
			</table>
		</div>
</body>

</html>
