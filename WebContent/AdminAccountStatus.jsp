<%@ page language="java" import="com.bms.bean.StudentBean, java.util.*"%>
<%ArrayList<StudentBean> studentList = (ArrayList<StudentBean>)request.getAttribute("sList"); %>
<%Iterator itr = studentList.iterator(); %>

<html>
<head>
	<title>Student Account Status</title>
	<style>
        body{
            background-color: black;
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
	<%int user_ID = Integer.parseInt(request.getParameter("user_ID")); %>
    <a href="/StudentInformation/StudentServlet?action=getAdminHomepage&user_ID=<%=user_ID%>" style="text-decoration: none; color: white;">Back</a>
	<div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute;top: 7%;">
        <table>
            <tr style="background-color: #818181;">
            	<th>Activation Status</th>
                <th>Name</th>
                <th>USN</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Address</th>
                <th>Father's Name</th>
                <th>Mother's Mobile</th>
                <th>Mother's Name</th>
                <th>Mother's Mobile</th>
                <th>Class ID</th>
            </tr>
				<%while(itr.hasNext()){ %>
				<%StudentBean sb = (StudentBean)itr.next(); %>
            <tr>
            	<%if(sb.getStatus() == 0){ %>
            			<td>Not Active</td>
            			<%} %>
            	<%if(sb.getStatus() == 1){ %>
            			<td>Active</td>
            			<%} %>
                <td><%=sb.getName() %></td>
                <td><%=sb.getUsn() %></td>
                <td><%=sb.getEmail() %></td>
                <td><%=sb.getMob() %></td>
                <td><%=sb.getAddress() %></td>
                <td><%=sb.getFather_name() %></td>
                <td><%=sb.getFather_mob() %></td>
                <td><%=sb.getMother_name() %></td>
                <td><%=sb.getMother_mob() %></td>
                <td><%=sb.getClass_id() %></td>
                
            </tr>
            <%} %>
        </table>
        
    </div>
</body>