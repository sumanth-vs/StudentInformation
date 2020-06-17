<%@ page language="java" import="com.bms.bean.*"%>

<%UserBean ub = (UserBean) session.getAttribute("ub");%>    
    <!DOCTYPE html>
<html>
<head>
    <title>Projects</title>
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

	<h6><a style= "color: white; text-decoration: none; font-family: 'Lucida Sans'; font-size: 15px; text-align: center; padding: 10px;" href="/StudentInformation/StudentServlet?action=getStudentHomepage&stdID=<%=ub.getUserID()%>">Back</a></h6>	
    
    <h1 style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px; margin: 25px;">Links to Assignments</h1>
    
    
    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif;">
        <table>
            <tr style="background-color: #424242;">
                <th>Courses</th>
                <th>Links</th>
                
            </tr>
            <tr>
                <td>Analysis And Design Of Algorithms</td>
              <td><a href = "https://new.edmodo.com/groups/logic-design-3rd-semester-19-20-odd-30418335" target="_blank" style="text-decoration:  none;color:rgb(29, 107, 196)">Edmodo</a></td>
        
            </tr>
            <tr>
                <td>Database Management Systems</td>
                 <td><a href = "https://new.edmodo.com/groups/3c-java-30833838" target="_blank" style="text-decoration:  none;color:rgb(29, 107, 196)">Edmodo</a></td>
                
            </tr>
        </table>
    </div>

</body>

</html>
    