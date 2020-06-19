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
    
    	<h6><a style= "color: white; text-decoration: none; font-family: 'Lucida Sans'; font-size: 15px; text-align: center; padding: 10px;" href="/StudentInformation/StudentServlet?action=getLoginPage"><img style="width: 50px;" src="Assets/back.png"></a></h6>
        <form class="box" action="/StudentInformation/StudentServlet" method="POST">
        	<input type="hidden" name="action" value="checkForgotUsername">
            <h1>Enter your UserName</h1>
            <input type="text" name="username" id = "e1" placeholder="Username" required>
           	<%if(ub.getGenErrFlag() == 1){ %>
           	<font color="white"><h4><%=ub.getGenErrMsg() %></h4></font>
           	<%} %>
            <input type="submit" name="" placeholder="Submit">
        </form>
    </body>
</html>