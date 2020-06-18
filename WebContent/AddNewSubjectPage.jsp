<%@ page language="java" import="java.util.*, com.bms.bean.*"%>
<%-- <%ArrayList cl = (ArrayList)request.getAttribute("cl"); %>
<%Iterator itr = cl.iterator(); %>
<%StudentBean sb = (StudentBean)request.getAttribute("sb"); %> --%>



<html>
    <head>
        <meta charset="utf-8">
        <title>Add New Subject</title>
        <link rel="stylesheet" href=".//CSS/newuser.css">
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
    </head>

    <body>
        <form class="box" action="/StudentInformation/StudentServlet" method="POST">
        	<input type="hidden" name="action" value="addNewSubject">
            <h1>Enter Details</h1>
            <input type="text" name="sub_name" id="idd"placeholder="Subject Name" required>

            <input type="text" name="sub_s_name" id="idd"placeholder="Subject Short Name" required>
            
            <input type="submit" name="Login" placeholder="Add Subject">

        </form>
		
    </body>
</html>