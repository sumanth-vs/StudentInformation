<%@ page language="java" import="java.util.*, com.bms.bean.*"%>
<%-- <%ArrayList cl = (ArrayList)request.getAttribute("cl"); %>
<%Iterator itr = cl.iterator(); %>
<%StudentBean sb = (StudentBean)request.getAttribute("sb"); %> --%>



<html>
    <head>
        <meta charset="utf-8">
        <title>Assign Faculty To Classes</title>
        <link rel="stylesheet" href=".//CSS/newuser.css">
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
    </head>

    <body>
        <form class="box" action="/StudentInformation/StudentServlet" method="POST">
        	<input type="hidden" name="action" value="assignFaculty">
            <h1>Enter Details</h1>
            <input type="text" name="fac_id" id="idd"placeholder="Faculty ID" required>

            <input type="text" name="sub_id" id="idd"placeholder="Subject ID" required>
            
            <input type="text" name="class_id" id="idd"placeholder="Class ID" required>
            
            <input type="submit" name="Assign Faculty" placeholder="Assign">

        </form>
    </body>
</html>