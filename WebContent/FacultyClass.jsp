<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> facList = (ArrayList<FacultyBean>)request.getAttribute("fl"); %>
<%Iterator itr = facList.iterator(); %>
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

    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute;top: 57%;">
        <table>
            <tr>
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
                <td><a href="/StudentInformation/StudentServlet?action=getFacultyAttendance&classID=<%=fb.getClass_id()%>&subID=<%=fb.getSub_id()%>" style="text-decoration: none; color: white;">View attendance</a></td>
                <td><a href="/StudentInformation/StudentServlet?action=addFacultyAttendance&classID=<%=fb.getClass_id()%>&subID=<%=fb.getSub_id()%>" style="text-decoration: none; color: white;">Add attendance Details</a></td>
                <td><a href="/StudentInformation/StudentServlet?action=getFacultyMarks&classID=<%=fb.getClass_id()%>&subID=<%=fb.getSub_id()%>" style="text-decoration: none; color: white;">View Marks</a></td>
                <td><a href="/StudentInformation/StudentServlet?action=addFacultyMarks&classID=<%=fb.getClass_id()%>&subID=<%=fb.getSub_id()%>" style="text-decoration: none; color: white;">Add Marks</a></td>
            </tr>
            <%} %>
        </table>
        <a href="/StudentInformation/StudentServlet?action=getFacultyHomepage&facID=<%=ub.getUserID()%>" style="text-decoration: none; color: white;">Back To Homepage</a>
    </div>

</body>

</html>

