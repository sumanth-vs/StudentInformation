<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> facList = (ArrayList<FacultyBean>)request.getAttribute("fl"); %>
<%Iterator<FacultyBean> itr = facList.iterator(); %>
<%UserBean ub = (UserBean) session.getAttribute("ub"); %>


<!DOCTYPE html>
<html>

<head>
    <title>Marks</title>
    <style>
        body{
            background-color: black;
        }
        table {
            margin-top: -10px;
            margin-left: 20px;
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

	<h6><a style= "color: white; text-decoration: none; font-family: 'Lucida Sans'; font-size: 15px; text-align: center; padding: 10px;" href="/StudentInformation/StudentServlet?action=getFacultyHomepage&facID=<%=ub.getUserID()%>">Back</a></h6>

    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute;top: 57%;">
        <table>
            <tr style="background-color: #818181;">
                <th>Semester</th>
                <th>Section</th>
                <th>Course</th>
                <th>Subject</th>
                <th>Attendance</th>
                <th></th>
                <th>Marks</th>
                <th></th>
            </tr>
				<%while(itr.hasNext()){ %>
				<%FacultyBean fb = (FacultyBean)itr.next(); %>
            <tr>
                <td><%=fb.getSem() %></td>
                <td><%=fb.getSection() %></td>
                <td><%=fb.getCourse() %></td>
                <td><%=fb.getSub_name() %></td>
                <td><a href="/StudentInformation/StudentServlet?action=getFacultyAttendance&classID=<%=fb.getClass_id()%>&subID=<%=fb.getSub_id()%>" style="text-decoration: none; color: #A22;">View attendance</a></td>
                <td><a href="/StudentInformation/StudentServlet?action=addFacultyAttendance&classID=<%=fb.getClass_id()%>&subID=<%=fb.getSub_id()%>" style="text-decoration: none; color: #A22;">Add attendance</a></td>
                <td><a href="/StudentInformation/StudentServlet?action=getFacultyMarks&classID=<%=fb.getClass_id()%>&subID=<%=fb.getSub_id()%>" style="text-decoration: none; color: #A22;">View Marks</a></td>
                <td><a href="/StudentInformation/StudentServlet?action=addFacultyMarks&classID=<%=fb.getClass_id()%>&subID=<%=fb.getSub_id()%>" style="text-decoration: none; color: #A22;">Add Marks</a></td>
            </tr>
            <%} %>
        </table>
    </div>

</body>

</html>

