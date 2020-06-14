<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> attList = (ArrayList<FacultyBean>)request.getAttribute("addMarksL"); %>
<%Iterator itr = attList.iterator(); %>
<%FacultyBean fb = (FacultyBean)request.getAttribute("fb"); %>
<%int sub_ID = (int) request.getAttribute("subID"); %>
<%int class_ID = (int) request.getAttribute("classID"); %>

<!DOCTYPE html>
<html>

<head>
    <title>Marks</title>
    <style>
        body{
            background-color: black;
        }
        table {
            margin: 75px;
            border-collapse: collapse;
            width: 90%;
        }
        th,
        td {
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
    <h1 style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px;">Monitor Your Students' Marks</h1>
    
    <div style="margin: 80px;">
        <h2 style="font-family: Helvetica; color: white; position: absolute; top: 57%;">
            Semester : <%=fb.getSem() %> | Section : <%=fb.getSection() %> |Branch : <%=fb.getCourse() %>
        </h2>
    </div>


	<form action="/StudentInformation/StudentServlet">
		<input type="hidden" name="action" value="addFacultyMarksValues">
		<input type="hidden" name="subID" value="<%=sub_ID%>">
		<input type="hidden" name="classID" value="<%=class_ID%>">
	    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute;top: 57%;">
	        <table>
		        <tr>
		        	<td>
		        		<select name="internalType">
		        			<option value="cie1">CIE 1</option>
		        			<option value="cie2">CIE 2</option>
		        			<option value="cie3">CIE 3</option>
		        			<option value="lab">LAB</option>
		        		</select>
		        	</td>
		        </tr> 
	        	
	        	<tr><td>&nbsp;</td></tr>
	            <%while(itr.hasNext()){ %>
				<%FacultyBean fb1 = (FacultyBean)itr.next(); %>
	            
	            <tr>
	                <td><input type="text" value="<%=fb1.getStudent_name() %>" readonly="readonly"></td>
	                <font color="white"><td><input type="text" name="internalMarks"></td></font>
	                <td><input type="hidden" name="stdID" value="<%=fb1.getStudent_id()%>"></td>
	            </tr>
	            <%} %>
	            
	            
	            <tr><td><input type="submit" value="Add Marks"></td></tr>
	        </table>
	    </div>    
    </form>

</body>

</html>