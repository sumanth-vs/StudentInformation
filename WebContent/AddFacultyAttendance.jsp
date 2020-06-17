<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%
	ArrayList<FacultyBean> attList = (ArrayList<FacultyBean>) request.getAttribute("addAttL");
%>
<%
	Iterator itr = attList.iterator();
%>
<%
	UserBean ub = (UserBean) session.getAttribute("ub");
%>
<%int sub_ID = (int) request.getAttribute("subID"); %>
<%int class_ID = (int) request.getAttribute("classID"); %>

<%FacultyBean fb = (FacultyBean)request.getAttribute("fb"); %>




<html>

	<head>
		<title>Attendance</title>
		
		<link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
			
		<style>
			body {
				background: black;
			}
			
			
			th, td {
				color: white;
				text-align: left;
				padding: 20px;
			}
			
			tr:nth-child(even) {
				background-color: #0b0c0c;
			}
			
			
			.box input[type = "text"]{
			    background: none;
			    display: block;
			    margin: 5px auto;
			    text-align: center;
			    border: .5px solid white;
			    padding: 14px 10px;
			    width: 400px;
			    outline: none;
			    color: white;
			    transition: .25s ease;
			}
			
			.box input[type = "text"]:hover{
			    border-color: rgb(10, 165, 69);
			}
			
			.box input[type = "text"]:focus{
			    width: 280px;
			    border-color: rgb(12, 199, 37);
			    
			}
			
			
			.box input[type = "submit"]{
			    font-family: 'Bebas Neue', cursive;
			    font-size: 23px;
			    background: none;
			    text-align: center;
			    border: 2px solid white;
			    height: 50px;
			    width: 200px;
			    color: white;
			    transition: .25s;
			    cursor: pointer;
			}
			
			.box input[type = "submit"]:hover{
			
			    background:   rgb(26, 224, 115);
			    color: black;
			}
			
	
		</style>
	</head>
	
	<body>
	
		<h1
			style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px; margin: 25px;">
			Monitor Your Students' Attendance
		</h1>
		
		
		
		
		<div>
			<img
				style="max-width: 100px; position: absolute; left: 43%; border-radius: 20px"
				src="Assets/teacher.jpg" alt="SurajFail">
		</div>
	
	
	
	
	
		<div style="margin: 80px;">
			<h2
				style="font-family: Helvetica; color: red; position: absolute; top: 52%; left: 10%">
				Semester :
				<%=fb.getSem()%>
				| Section :
				<%=fb.getSection()%>
				|Branch :
				<%=fb.getCourse()%>
			</h2>
		</div>
	
	
	
	
	
		<form action="/StudentInformation/StudentServlet">
			<input type="hidden" name="action" value="addFacultyAttendanceValues">
			<input type="hidden" name="subID" value="<%=sub_ID%>">
			<input type="hidden" name="classID" value="<%=class_ID%>">
			<div style="overflow-x: auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute; top: 67%; left: 7%; width:90%;">
			
				<table>
		
					<tr style="background-color: #818181;">
						<th>Student Name</th>
						<th>Classes Conducted</th>
						<th>Classes Attended</th>
					</tr>
		
					<%
						while (itr.hasNext()) {
					%>
					<%
						FacultyBean fb1 = (FacultyBean) itr.next();
					%>
					<tr class="box">
		                <td><input type="text" value="<%=fb1.getStudent_name() %>" readonly="readonly"></td>
		                <td><input type="text" name="classesCond"></td>
		                <td><input type="text" name="classesAttend"></td>
		                <td><input type="hidden" name="stdID" value="<%=fb1.getStudent_id()%>"></td>
		            </tr>
					<%
						}
					%>
					
					
					
					
					
					<tr class="box"><td><input type="submit" value="Add Attendance"></td></tr>
				</table>
			
			</div>
		
		</form>
	</body>

</html>
