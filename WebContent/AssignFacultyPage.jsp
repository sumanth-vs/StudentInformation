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
            <br></br>

            <input type="text" name="sub_id" id="idd"placeholder="Subject ID" required>
            <br></br>
            
            <input type="text" name="class_id" id="idd"placeholder="Class ID" required>
            <br></br>           
            
            <input type="submit" name="Assign Faculty" placeholder="Assign">

        </form>
		<%int user_ID = Integer.parseInt(request.getParameter("user_ID")); %>
        <a href="/StudentInformation/StudentServlet?action=getAdminHomepage&user_ID=<%=user_ID%>" style="text-decoration: none; color: white;">Back To Home page</a>
    </body>
</html>