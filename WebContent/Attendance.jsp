<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<AcademicsBean> attendaceList = (ArrayList<AcademicsBean>)request.getAttribute("al"); %>
<%Iterator itr = attendaceList.iterator(); %>
<%UserBean ub = (UserBean) session.getAttribute("ub");%>
<!DOCTYPE html>
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
	<h6><a style= "color: white; text-decoration: none; font-family: 'Lucida Sans'; text-align: center; padding: 10px;" href="/StudentInformation/StudentServlet?action=getStudentHomepage&stdID=<%=ub.getUserID()%>">Back To Home Page</a></h6>
    <h1 style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px; margin: 25px;">Monitor Your Attendance</h2>
    <div>
        <img style="max-width: 200px; position: absolute; left: 75%;  border-radius: 20px" src="Assets/user.png" alt="SurajFail">
    </div>
    <div style="margin: 80px;">
        <p style="font-family: Helvetica; color: white;">* Minimum attendance for eligibility is 85% in each course</p>
        <p style="font-family: Helvetica; color: white;">* Students with attendance above 75% must apply for condonation</p>
        <p style="font-family: Helvetica; color: white;">* Students with attendance below 75% are NOT ELIGIBLE to write the Semester End Examinations</p>
    </div>
    
    <div style="margin: 80px;">
        <h3 style="font-family: Helvetica; color: white; position: absolute; top: 50%;">
            Semester : III | Branch : Computer Science and Engineering | USN : 1BM18CS113
        </h3>
    </div>

    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif;">
        <table>
            <tr style="background-color: #818181;">
                <th>Subject</th>
                <th>Classes Conducted</th>
                <th>Classes Attended</th>
                <th>Percentage</th>
            </tr>
            <tr>
            	<%while(itr.hasNext()){ %>
            	<%AcademicsBean ab = (AcademicsBean)itr.next(); %>
                <td><%=ab.getSubject() %></td>
                <td><%=ab.getClass_cond() %></td>
                <td><%=ab.getClass_attend() %></td>
                <td><%=(double)ab.getClass_attend()/ab.getClass_cond() * 100 %></td>
            </tr>
            <%} %>
        </table>
    </div>


    <div style="margin: 80px;">
        <h5 style="font-family: Helvetica; color: white; position: absolute; top: 125%;">
        --> Please Contact your Proctor for further information.
        </h5>
    </div>

</body>

</html>
