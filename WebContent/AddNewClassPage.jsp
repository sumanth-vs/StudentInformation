<%@ page language="java" import="java.util.*, com.bms.bean.*"%>
<%-- <%ArrayList cl = (ArrayList)request.getAttribute("cl"); %>
<%Iterator itr = cl.iterator(); %>
<%StudentBean sb = (StudentBean)request.getAttribute("sb"); %> --%>



<html>
    <head>
        <meta charset="utf-8">
        <title>Add New Class</title>
        <link rel="stylesheet" href=".//CSS/newuser.css">
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
    </head>

    <body>
        <form class="box" action="/StudentInformation/StudentServlet" method="POST">
        	<input type="hidden" name="action" value="addNewClass">
            <h1>Enter Details</h1>
            <input type="text" name="sem" id="idd"placeholder="Semester" required>
            <br></br>

            <input type="text" name="section" id="idd"placeholder="Section" required>
            <br></br>
            <input type="text" name="course" id="idd"placeholder="Course"  required>
            <br></br>

            <input type="text" name="course_code" id = "e2" placeholder="Course Code"  required>
            <br></br>

            
            <input type="submit" name="Add Class" placeholder="Add Class">

        </form>

    </body>
</html>