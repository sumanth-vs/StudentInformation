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

    <h1 style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px; margin: 25px;">Links to Assignments</h1>
    
    
    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif;">
        <table>
            <tr style="background-color: #424242;">
                <th>Courses</th>
                <th>Links</th>
                
            </tr>
            <tr>
                <td>Logic Design</td>
              <td><a href = "https://new.edmodo.com/groups/logic-design-3rd-semester-19-20-odd-30418335" style="text-decoration:  none;color:rgb(29, 107, 196)">Edmodo</a></td>
        
            </tr>
            <tr>
                <td>Object Oriented Java</td>
                 <td><a href = "https://new.edmodo.com/groups/3c-java-30833838" style="text-decoration:  none;color:rgb(29, 107, 196)">Edmodo</a></td>
                
            </tr>
            <tr>
                <td>Micro Processors and Microcontrollers</td>
                  <td><a href = "#" style="text-decoration:  none;color:rgb(29, 107, 196)">Google Classroom</a></td>
                
            </tr>
            <tr>
                <td>Statistics & Discrete Maths</td>
              <td><a href = "https://app.schoology.com/home" style="text-decoration:  none;color:rgb(29, 107, 196)">Schoology</a></td>
               
            </tr>
            <tr>
                <td>Data Structures</td>
                 <td><a href = "https://new.edmodo.com/groups/data-structures-3c-aug-to-dec-2019-29964936" style="text-decoration:  none;color:rgb(29, 107, 196)">Edmodo</a></td>
               
            </tr>
            <tr>
                <td>Computer Organisation and Architecture</td>
                <td><a href = "https://classroom.google.com/h" style="text-decoration:  none;color:rgb(29, 107, 196)">Google Classroom</a></td>
              
            </tr>
        </table>
    </div>

</body>

</html>
    