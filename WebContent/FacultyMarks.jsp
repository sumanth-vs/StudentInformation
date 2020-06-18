<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> attList = (ArrayList<FacultyBean>)request.getAttribute("marksL"); %>
<%Iterator<FacultyBean> itr = attList.iterator(); %>
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
        <img style="max-width: 150px; position: absolute; left: 43%; border-radius: 20px" src="Assets/teacher.jpg" alt="SurajFail">
    </div>
    
    <div style="margin: 80px;">
        <h2 style="font-family: Helvetica; color: red; position: absolute; top: 57%;">
            Semester : <%=fb.getSem() %> | Section : <%=fb.getSection() %> |Branch : <%=fb.getCourse() %>
        </h2>
    </div>


    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute;top: 57%;">
        <table>
            <tr style="background-color: #818181;">
                <th>Student Name</th>
                <th>Test 1 (/20)</th>
                <th>Test 2 (/20)</th>
                <th>Test 3 (/20)</th>
                <th>LAB/AAT (/10)</th>
                <th>CIE(/50)</th>
            </tr>
            <%while(itr.hasNext()){ %>
			<%FacultyBean fb1 = (FacultyBean)itr.next(); %>
            <tr>
                <td><%=fb1.getStudent_name() %></td>
                <td><%=fb1.getCie1() /2 %></td>
                <td><%=fb1.getCie2() /2 %></td>
                <td><%=fb1.getCie3() /2 %></td>
                <td><%=fb1.getLab() %></td>
                
                <%double a, b, c; %>
                <%a = fb1.getCie1() / 2; %>
                <%b = fb1.getCie2() / 2; %>
                <%c = fb1.getCie3() / 2; %>
                <td><%=fb1.getLab() + (c > (a>b ? a:b) ? c:((a>b) ? a:b)) + ((a >= b && a >= c) ? ((b >= c) ? b : c) : ((b >= c) ? ((a >= c) ? a : c) : ((a >= b) ? a : b))) %></td>
                
            </tr>
            <%} %>
        </table>
    </div>

</body>

</html>