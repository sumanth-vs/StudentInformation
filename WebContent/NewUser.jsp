<%@ page language="java" import="java.util.*, com.bms.bean.*"%>
<%ArrayList cl = (ArrayList)request.getAttribute("cl"); %>
<%Iterator itr = cl.iterator(); %>
<%StudentBean sb = (StudentBean)request.getAttribute("sb"); %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Welcome</title>
        <link rel="stylesheet" href=".//CSS/newuser.css">
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
    </head>

    <body>
        <form class="box" action="/StudentInformation/StudentServlet" method="POST"">
        	<input type="hidden" name="action" value="registerStudentDetails">
        	<input type="hidden" name="status" value="0">
            <h1>Enter Details</h1>
            <input type="text" name="username" id="idd"placeholder="Username" value="<%=sb.getUsername() %>" required>
            <br></br>
            <font color="white"><%if(sb.getUserNameErr() == 1) %><%=sb.getUserNameErrMsg()%></font>
            <input type="password" name="password" id="idd"placeholder="Password" required>
            <br></br>
            <input type="text" name="stud_name" id="idd"placeholder="Name" value="<%=sb.getName() %>" required>
            <br></br>
            <font color="white"><%if(sb.getNameErr() == 1) %><%=sb.getNameErrMsg()%></font>
            <input type="text" name="usn" id = "e1" placeholder="USN" value="<%=sb.getUsn() %>" required>
            <br></br>
            <font color="white"><%if(sb.getUsnErr() == 1) %><%=sb.getUsnErrMsg()%></font>
            <input type="text" name="email" id = "e2" placeholder="Email" value="<%=sb.getEmail() %>" required>
            <br></br>
            <font color="white"><%if(sb.getEmailErr() == 1) %><%=sb.getEmailErrMsg()%></font>
            <input type="text" name="mob" id = "user" placeholder="MOB" value="<%=sb.getMob() %>" required>
            <br></br>
            <font color="white"><%if(sb.getMobErr() == 1) %><%=sb.getMobErrMsg()%></font>
            <input type="text" name="address" id = "p1" placeholder="Address" value="<%=sb.getAddress() %>" required>
            <br></br>
            <input type="text" name="proc_name" id = "p2" placeholder="Proctor Name" value="<%=sb.getProc_name() %>" required>
            <br></br>
            <font color="white"><%if(sb.getProcNameeErr() == 1) %><%=sb.getProcNameErrMsg()%></font>
            <input type="text" name="proc_mob" id = "pn" placeholder="Proctor Phone Number" value="<%=sb.getProc_mob() %>" required>
            <br></br>
            <font color="white"><%if(sb.getProcMobErr() == 1) %><%=sb.getProcMobErrMsg()%></font>
            <input type="text" name="father_name" id = "pn" placeholder="Father Name" value="<%=sb.getFather_name() %>" required>
            <br></br>
            <font color="white"><%if(sb.getFatherNameErr() == 1) %><%=sb.getFatherNameErrMsg()%></font>
            <input type="text" name="father_mob" id = "pn" placeholder="Father Phone Number" value="<%=sb.getFather_mob() %>" required>
            <br></br>
            <font color="white"><%if(sb.getFatherMobErr() == 1) %><%=sb.getFatherMobErrMsg()%></font>
            <input type="text" name="mother_name" id = "pn" placeholder="Mother Name" value="<%=sb.getMother_name() %>" required>
            <br></br>
            <font color="white"><%if(sb.getMotherNameErr() == 1) %><%=sb.getMotherNameErrMsg()%></font>
            <input type="text" name="mother_mob" id = "pn" placeholder="Mother Phone Number" value="<%=sb.getMother_mob() %>" required>
            <br></br>
            <font color="white"><%if(sb.getMotherMobErr() == 1) %><%=sb.getMotherMobErrMsg()%></font>
            <select id="cars" name="course_class_sec">
            	<%while(itr.hasNext()){ %>
            	
            	<%ClassBean cb = (ClassBean)itr.next(); %>
				<option value="<%=cb.getClassID()%>"><%=cb.getCourse_code()%> : <%=cb.getSem() %> Sem <%=cb.getSection() %> Section</option>
				<%} %>
			</select>
            
            <input type="submit" name="Login" placeholder="Login" onclick="javascript:validate()"/>

        </form>


        <!-- <script type="text/javascript">
            function checkPasswordComplexity(pwd) {
                var letter = /[a-zA-Z]/; 
                var number = /[0-9]/;
                var valid = number.test(pwd) && letter.test(pwd);
                return valid;
            }

            function validate()
            {
                if(   document.getElementById("p1").value == ""
                   || document.getElementById("p2").value == "" 
                   || document.getElementById("e1").value == ""
                   || document.getElementById("e2").value == ""
                   || document.getElementById("idd").value == ""
                   || document.getElementById("pn").value == ""
                   || document.getElementById("user").value == "")
                {
                    alert( "Some Fields Are Unfilled" );
                    //location.href="newuser.html";
                    return false;
                }

                else if(   document.getElementById("e1").value.indexOf("@") < 1
                || document.getElementById("e1").value.lastIndexOf(".")  < 
                    document.getElementById("e1").value.indexOf("@") + 2
                || document.getElementById("e1").value.lastIndexOf(".") + 2 >=
                    document.getElementById("e1").value.length)
                {
                    alert( "Enter proper Email ID" );
                    //location.href="newuser.html";
                    return false;
                }

                else if(   document.getElementById("e1").value != 
                document.getElementById("e2").value)
                {
                    alert( "Retype Your Email Properly" );
                    //location.href="newuser.html";
                    return false;
                }

                else if(   document.getElementById("p1").value.length < 8)
                {
                    alert( "Password should be atleast 8 digits" );
                    //location.href="newuser.html";
                    return false;
                }

                else if(   !checkPasswordComplexity(document.getElementById("p1").value))
                {
                    alert( "Password should contain atleast 1 alphabet and 1 number" );
                    //location.href="newuser.html";
                    return false;
                }

                else if(   document.getElementById("p1").value != 
                document.getElementById("p2").value)
                {
                    alert( "Retype Your Password Properly" );
                    //location.href="newuser.html";
                    return false;
                }

                else if(   document.getElementById("pn").value.length < 10)
                {
                    alert( "Phone number must be 10 digits" );
                    //location.href="newuser.html";
                    return false;
                }

                else if(   isNaN(document.getElementById("pn").value))
                {
                    alert( "Phone number can only have numberical values" );
                    //location.href="newuser.html";
                    return false;
                }

                
                if(   document.getElementById("idd").value.indexOf("teacher") >= 0)
                {
                    alert( "Teacher Signing Up..." );
                    location.href="signup.html";
                }
                else if(   document.getElementById("idd").value.indexOf("1bm") >= 0)
                {
                    alert( "Student Signing Up..." );
                    location.href="signup.html";
                }
            }
        </script> -->

    </body>
</html>