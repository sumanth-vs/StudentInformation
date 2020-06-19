<%@ page language="java" import="com.bms.bean.*, java.util.*, java.lang.Math"%>
<%ArrayList<AcademicsBean> marksList = (ArrayList<AcademicsBean>)request.getAttribute("ml"); %>
<%Iterator itr = marksList.iterator(); %>
<%UserBean ub = (UserBean) session.getAttribute("ub");%>


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
	<h6><a style= "color: white; text-decoration: none; font-family: 'Lucida Sans'; font-size: 15px; text-align: center; padding: 10px;" href="/StudentInformation/StudentServlet?action=getStudentHomepage&stdID=<%=ub.getUserID()%>"><img style="width: 50px;" src="Assets/back.png"></a></h6>
    <h1 style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px;">Monitor Your Marks</h1>
    <div>
        <img style="max-width: 250px; position: absolute; left: 70%; border-radius: 20px" src="Assets/user.png" alt="SurajFail">
    </div>
    <div style="margin: 80px;">
        <p style="font-family: Helvetica; color: white;">* Minimum Marks for eligibility is 20 in each course</p>
        <p style="font-family: Helvetica;color: white;">* Best two marks of three tests will be considered for CIE</p>
        <p style="font-family: Helvetica;color: #A22;">* If CIE Marks is below 20, you are NOT ELIGIBLE to take up the SEE for that course.</p>
    </div>
    
    <div style="margin: 80px;">
        <h3 style="font-family: Helvetica; color: red; position: absolute; top: 50%;">
            Semester : <%=ub.getSem() %> | Section : <%=ub.getSection() %> | Branch : <%=ub.getCourse() %> | USN : <%=ub.getUsn() %> 
        </h3>
    </div>


    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif;">
        <table>
            <tr style="background-color: #818181;">
                <th>Subject</th>
                <th>Test 1 (/20)</th>
                <th>Test 2 (/20)</th>
                <th>Test 3 (/20)</th>
                <th>LAB/AAT (/10)</th>
                <th>CIE(/50)</th>
            </tr>
            <tr>
            	<%while(itr.hasNext()){ %>
            	<%AcademicsBean ab = (AcademicsBean)itr.next(); %>
                <td><%=ab.getSubject() %></td>
                <td><%=ab.getCie1() / 2 %></td>
                <td><%=ab.getCie2() / 2 %></td>
                <td><%=ab.getCie3() / 2 %></td>
                <td><%=ab.getLab() %></td>
                <%double a, b, c; %>
                <%a = ab.getCie1() / 2; %>
                <%b = ab.getCie2() / 2; %>
                <%c = ab.getCie3() / 2; %>
                <td><%=ab.getLab() + (c > (a>b ? a:b) ? c:((a>b) ? a:b)) + ((a >= b && a >= c) ? ((b >= c) ? b : c) : ((b >= c) ? ((a >= c) ? a : c) : ((a >= b) ? a : b))) %></td>
            </tr>
            <%} %>
        </table>
    </div>



</body>

</html>