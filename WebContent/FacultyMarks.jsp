<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> attList = (ArrayList<FacultyBean>)request.getAttribute("marksL"); %>
<%Iterator itr = attList.iterator(); %>
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
    <h1 style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px;">Monitor Your Students' Marks</h1>
    <div>
        <img style="max-width: 150px; position: absolute; left: 41.5%; border-radius: 20px" src="Assets/teacher.jpg" alt="SurajFail">
    </div>
    <!-- <div style="margin: 80px;">
        <p style="font-family: Helvetica; color: white;">* Minimum Marks for eligibility is 20 in each course</p>
        <p style="font-family: Helvetica;color: white;">* Best two marks of three tests will be considered for CIE</p>
        <p style="font-family: Helvetica;color: white;">* If CIE Marks is below 20, you are NOT ELIGIBLE to take up the SEE for that course.</p>
        <p style="font-family: Helvetica;color: white;">* Please contact your proctor for further details: Mrs. Antara De (+919538433364)</p>
    </div> -->
    
    <div style="margin: 80px;">
        <h2 style="font-family: Helvetica; color: white; position: absolute; top: 57%;">
            Semester : <%=ub.getSem() %> | Section : <%=ub.getSection() %> |Branch : <%=ub.getCourse() %>
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
			<%FacultyBean fb = (FacultyBean)itr.next(); %>
            <tr>
                <td><%=fb.getStudent_name() %></td>
                <td><%=fb.getCie1() %></td>
                <td><%=fb.getCie2() %></td>
                <td><%=fb.getCie3() %></td>
                <td><%=fb.getLab() %></td>
                <td>best of 3 + lab</td>
                <td><a href="/StudentInformation/StudentServlet?action=editFacultyMarks">Edit</a></td>           
            </tr>
            <%} %>
        </table>
    </div>

</body>

</html>