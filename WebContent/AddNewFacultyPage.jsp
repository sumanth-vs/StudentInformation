<%@ page language="java" import="java.util.*, com.bms.bean.*"%>
<%-- <%ArrayList cl = (ArrayList)request.getAttribute("cl"); %>
<%Iterator itr = cl.iterator(); %>
<%StudentBean sb = (StudentBean)request.getAttribute("sb"); %> --%>



<html>
    <head>
        <meta charset="utf-8">
        <title>Add New Faculty</title>
        <link rel="stylesheet" href=".//CSS/newuser.css">
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
    </head>

    <body>
        <form class="box" action="/StudentInformation/StudentServlet" method="POST">
        	<input type="hidden" name="action" value="addNewFaculty">
            <h1>Enter Details</h1>
            <input type="text" name="username" id="idd"placeholder="Username" required>
            <br></br>

            <input type="password" name="password" id="idd"placeholder="Password" required>
            <br></br>
            <input type="text" name="fName" id="idd"placeholder="Name"  required>
            <br></br>

            <input type="text" name="fMob" id = "e2" placeholder="Mobile Number"  required>
            <br></br>

            <input type="text" name="fEmail" id = "user" placeholder="Email Address"  required>
            
            <input type="submit" name="Login" placeholder="Add Faculty">

        </form>

    </body>
</html>