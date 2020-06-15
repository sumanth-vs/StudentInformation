<%@ page language="java" import="com.bms.bean.UserBean"%>
<%UserBean ub = (UserBean)request.getAttribute("ub"); %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Login Page</title>
        <link rel="stylesheet" href=".//CSS/loginStyle.css">
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
    </head>

    <body>
        <form class="box" action="/StudentInformation/StudentServlet" method="POST" >
        	<input type="hidden" name="action" value="verifyLogin">
            <h1>Login To Access Your Information</h1>
            <input type="text" name="username" placeholder="Username" id="text1"  required>
            <input type="password" name="password" placeholder="Password" id="text2" required>
            
            <%if(ub.getGenErrFlag() == 1)%>
            <font color="white"><%=ub.getGenErrMsg() %></font>
            
            <%if(ub.getGenErrFlag() == 2) %>
            <font color="white"><%=ub.getStatusMsg() %></font>
            <br></br>
            <a href="/StudentInformation/StudentServlet?action=forgotPassword">Forgot Password?</a>
            
            <input type="submit" name="" placeholder="Login" />
        </form>
        <a class="newuser" href="/StudentInformation/StudentServlet?action=registerStudentPage">New Here? Sign Up</a> 
    </body>
</html>



