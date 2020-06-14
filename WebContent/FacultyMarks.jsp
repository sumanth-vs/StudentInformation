<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> attList = (ArrayList<FacultyBean>)request.getAttribute("marksL"); %>
<%Iterator itr = attList.iterator(); %>
<%FacultyBean fb = (FacultyBean)request.getAttribute("fb"); %>

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
    <div>
        <img style="max-width: 150px; position: absolute; left: 41.5%; border-radius: 20px" src="Assets/teacher.jpg" alt="SurajFail">
    </div>
    
    <div style="margin: 80px;">
        <h2 style="font-family: Helvetica; color: white; position: absolute; top: 57%;">
            Semester : <%=fb.getSem() %> | Section : <%=fb.getSection() %> |Branch : <%=fb.getCourse() %>
        </h2>
    </div>


    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute;top: 57%;">
        <table>
            <tr>
                <th>Student Name</th>
                <th>Test 1 (/20)</th>
                <th>Test 2 (/20)</th>
                <th>Test 3 (/20)</th>
                <th>LAB/AAT (/10)</th>
                <th>CIE(/50)</th>
                <th>Edit</th>
            </tr>
            <%while(itr.hasNext()){ %>
			<%FacultyBean fb1 = (FacultyBean)itr.next(); %>
            <tr>
                <td><%=fb1.getStudent_name() %></td>
                <td><%=fb1.getCie1() %></td>
                <td><%=fb1.getCie2() %></td>
                <td><%=fb1.getCie3() %></td>
                <td><%=fb1.getLab() %></td>
                <td>best of 3 + lab</td>
                <td><a href="/StudentInformation/StudentServlet?action=editFacultyMarks&stdId=<%=fb1.getStudent_id()%>&classID=<%=fb1.getClass_id()%>&subID=<%=fb1.getSub_id()%>" style="text-decoration: none; color: white;">Edit</a></td>           
            </tr>
            <%} %>
        </table>
    </div>

</body>

</html>