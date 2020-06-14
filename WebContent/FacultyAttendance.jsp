<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> attList = (ArrayList<FacultyBean>)request.getAttribute("attL"); %>
<%Iterator itr = attList.iterator(); %>
<%FacultyBean fb = (FacultyBean)request.getAttribute("fb"); %>




<html>

<head>
    <title>Attendance</title>
    <style>
        body{
            background: black;
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

    <h1 style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px; margin: 25px;">Monitor Your Students' Attendance</h2>
    <div>
        <img style="max-width: 100px; position: absolute; left: 43%;  border-radius: 20px" src="Assets/teacher.jpg" alt="SurajFail">
    </div>
    
    <div style="margin: 80px;">
        <h2 style="font-family: Helvetica; color: white; position: absolute; top: 52%;">
            Semester : <%=fb.getSem() %> | Section : <%=fb.getSection() %> |Branch : <%=fb.getCourse() %>
        </h2>
    </div>

    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute; top: 57%; left: 18%;">
        <table>
            
            <tr style="background-color: #818181;">
                <th>Student Name</th>
                <th>Classes Conducted</th>
                <th>Classes Attended</th>
                <th>Attendance Percentage</th>
                <th>Edit</th>
            </tr>

			<%while(itr.hasNext()){ %>
			<%FacultyBean fb1 = (FacultyBean)itr.next(); %>
            <tr>
                <td><%=fb1.getStudent_name() %></td>
                <td><%=fb1.getClasses_cond() %></td>
                <td><%=fb1.getClasses_attend() %></td>
                <td><%=(double) fb1.getClasses_attend()/fb1.getClasses_cond() * 100 %></td>        
                <td><a href="/StudentInformation/StudentServlet?action=editFacultyAttendance">Edit</a></td>        
            </tr>
            <%} %>
        </table>
    </div>

</body>

</html>
    