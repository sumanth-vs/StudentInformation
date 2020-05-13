<%@ page language="java" import="com.bms.bean.*"%>
<%UserBean ub = (UserBean)request.getAttribute("ub"); %>
    
<html>
    <head>
        <meta charset="utf-8">
        <title>Forgot Password</title>
        <link rel="stylesheet" href=".//CSS/loginStyle.css">
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
    </head>

    <body>
        <form class="box" action="/StudentInformation/StudentServlet" method="POST">
        	<input type="text" name="action" value="checkForgotUsername">
            <h1>Enter your UserName</h1>
            <input type="text" name="username" id = "e1" placeholder="Email" required>
            <h4><%if(ub.getGenErrFlag()== 1){ %><%=ub.getGenErrMsg() %></h4><%} %>
            <input type="submit" name="" placeholder="Submit">
        </form>
    </body>
</html>