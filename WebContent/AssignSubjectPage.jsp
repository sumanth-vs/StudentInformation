<%@ page language="java" import="java.util.*, com.bms.bean.*"%>
<%-- <%ArrayList cl = (ArrayList)request.getAttribute("cl"); %>
<%Iterator itr = cl.iterator(); %>
<%StudentBean sb = (StudentBean)request.getAttribute("sb"); %> --%>



<html>
    <head>
        <meta charset="utf-8">
        <title>Assign Subject To Student</title>
        <link rel="stylesheet" href=".//CSS/newuser.css">
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
    </head>

    <body>
        <form class="box" action="/StudentInformation/StudentServlet" method="POST">
        	<input type="hidden" name="action" value="assignSubject">
            <h1>Enter Details</h1>
            <input type="text" name="std_id" id="idd"placeholder="Student ID" required>
            <br></br>

            <input type="text" name="sub_id" id="idd"placeholder="Subject ID" required>
            <br></br>           
            
            <input type="submit" name="Assign Subject" placeholder="Assign Subject">

        </form>

    </body>
</html>