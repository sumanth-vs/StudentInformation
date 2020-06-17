<%@ page language="java" import="com.bms.bean.StudentBean"%>
<%StudentBean sb = (StudentBean)request.getAttribute("sb"); %>


<!DOCTYPE html>
<html>

<head>
    <title>Details</title>
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
	<h6><a style= "color: white; text-decoration: none; font-family: 'Lucida Sans'; text-align: center; font-size:16px; padding: 10px;" href="/StudentInformation/StudentServlet?action=getStudentHomepage&stdID=<%=sb.getStdid()%>">Back</a></h6>
    <h1 style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px;">View All Your Details</h1>
    <div>
        <img style="max-width: 350px; position: absolute; left: 37.3%; border-radius: 25px" src="Assets/user.png" alt="SurajFail">
    </div>
    




    <div style="width: 1100px; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute;top: 57%;">
        <table>
            <tr style="background-color: #5c5c5c;">
                <th>Description</th>
                <th>Details</th>
            </tr>
            <tr>
                <td>NAME</td>
                <td><%=sb.getName() %></td>
            </tr>
            <tr>
                <td>USN</td>
                <td><%=sb.getUsn() %></td>
            </tr>

            <tr>
                <td>MOBILE NUMBER</td>
                <td><%=sb.getMob() %></td>
            </tr>
            <tr>
                <td>FATHER'S NAME</td>
                <td><%=sb.getFather_name() %></td>
            </tr>
            <tr>
                <td>FATHER'S MOBILE NUMBER</td>
                <td><%=sb.getFather_mob() %></td>
            </tr>
            <tr>
                <td>MOTHER'S NAME</td>
                <td><%=sb.getMother_name() %></td>
            </tr>
            <tr>
                <td>MOTHER'S MOBILE NUMBER</td>
                <td><%=sb.getMother_mob() %></td>
            </tr>
            <tr>
                <td>PERMANENT ADDRESS</td>
                <td><%=sb.getAddress() %></td>
            </tr>
            <tr>
                <td>BRANCH</td>
                <td><%=sb.getCourse() %></td>
            </tr>
            <tr>
                <td>SEMESTER</td>
                <td><%=sb.getSemester() %></td>
            </tr>
            

            <tr>
                <td>PROCTOR'S NAME</td>
                <td><%=sb.getProc_name() %></td>
            </tr>
            <tr>
                <td>PROCTOR'S MOBILE NUMBER</td>
                <td><%=sb.getProc_mob() %></td>
            </tr>
        </table>
    </div>

</body>

</html>