<%@ page language="java" import="java.util.*, com.bms.bean.*"%>
<%ArrayList cl = (ArrayList)request.getAttribute("cl"); %>
<%Iterator itr = cl.iterator(); %>
<%StudentBean sb = (StudentBean)request.getAttribute("sb"); %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Welcome</title>
        <link rel="stylesheet" href="CSS/newuser.css">
        <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
        
        
        <!-- <style>
        .custom-select {
		  position: relative;
		  font-family: Arial;
		}
		
		.custom-select select {
		  display: none; /*hide original SELECT element: */
		}
		
		.select-selected {
		  background-color: DodgerBlue;
		}
		
		/* Style the arrow inside the select element: */
		.select-selected:after {
		  position: absolute;
		  content: "";
		  top: 14px;
		  right: 10px;
		  width: 0;
		  height: 0;
		  border: 6px solid transparent;
		  border-color: #fff transparent transparent transparent;
		}
		
		/* Point the arrow upwards when the select box is open (active): */
		.select-selected.select-arrow-active:after {
		  border-color: transparent transparent #fff transparent;
		  top: 7px;
		}
		
		/* style the items (options), including the selected item: */
		.select-items div,.select-selected {
		  color: #ffffff;
		  padding: 8px 16px;
		  border: 1px solid transparent;
		  border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
		  cursor: pointer;
		}
		
		/* Style items (options): */
		.select-items {
		  position: absolute;
		  background-color: DodgerBlue;
		  top: 100%;
		  left: 0;
		  right: 0;
		  z-index: 99;
		}
		
		/* Hide the items when the select box is closed: */
		.select-hide {
		  display: none;
		}
		
		.select-items div:hover, .same-as-selected {
		  background-color: rgba(0, 0, 0, 0.1);
		}

	        
    </style> -->
    </head>

    <body>
    
    	<h6><a style= "color: white; text-decoration: none; font-family: 'Lucida Sans'; font-size: 15px; text-align: center; padding: 10px;" href="/StudentInformation/StudentServlet?action=getLoginPage">Back</a></h6>
        <form class="box" action="/StudentInformation/StudentServlet" method="POST"">
        	<input type="hidden" name="action" value="registerStudentDetails">
        	<input type="hidden" name="status" value="0">
            <h1>Enter Details</h1>
            <input type="text" name="username" id="idd"placeholder="Username" value="<%=sb.getUsername() %>" required>
            <font color="white"><%if(sb.getUserNameErr() == 1) %><%=sb.getUserNameErrMsg()%></font>
            <input type="password" name="password" id="idd"placeholder="Password" required>
            <input type="text" name="stud_name" id="idd"placeholder="Name" value="<%=sb.getName() %>" required>
            <font color="white"><%if(sb.getNameErr() == 1) %><%=sb.getNameErrMsg()%></font>
            <input type="text" name="usn" id = "e1" placeholder="USN" value="<%=sb.getUsn() %>" required>
            <font color="white"><%if(sb.getUsnErr() == 1) %><%=sb.getUsnErrMsg()%></font>
            <input type="text" name="email" id = "e2" placeholder="Email" value="<%=sb.getEmail() %>" required>
            <font color="white"><%if(sb.getEmailErr() == 1) %><%=sb.getEmailErrMsg()%></font>
            <input type="text" name="mob" id = "user" placeholder="MOB" value="<%=sb.getMob() %>" required>
            <font color="white"><%if(sb.getMobErr() == 1) %><%=sb.getMobErrMsg()%></font>
            <input type="text" name="address" id = "p1" placeholder="Address" value="<%=sb.getAddress() %>" required>
            <input type="text" name="proc_name" id = "p2" placeholder="Proctor Name" value="<%=sb.getProc_name() %>" required>
            <font color="white"><%if(sb.getProcNameeErr() == 1) %><%=sb.getProcNameErrMsg()%></font>
            <input type="text" name="proc_mob" id = "pn" placeholder="Proctor Phone Number" value="<%=sb.getProc_mob() %>" required>
            <font color="white"><%if(sb.getProcMobErr() == 1) %><%=sb.getProcMobErrMsg()%></font>
            <input type="text" name="father_name" id = "pn" placeholder="Father Name" value="<%=sb.getFather_name() %>" required>
            <font color="white"><%if(sb.getFatherNameErr() == 1) %><%=sb.getFatherNameErrMsg()%></font>
            <input type="text" name="father_mob" id = "pn" placeholder="Father Phone Number" value="<%=sb.getFather_mob() %>" required>
            <font color="white"><%if(sb.getFatherMobErr() == 1) %><%=sb.getFatherMobErrMsg()%></font>
            <input type="text" name="mother_name" id = "pn" placeholder="Mother Name" value="<%=sb.getMother_name() %>" required>
            <font color="white"><%if(sb.getMotherNameErr() == 1) %><%=sb.getMotherNameErrMsg()%></font>
            <input type="text" name="mother_mob" id = "pn" placeholder="Mother Phone Number" value="<%=sb.getMother_mob() %>" required>
            <font color="white"><%if(sb.getMotherMobErr() == 1) %><%=sb.getMotherMobErrMsg()%></font>
            
            <select id="cars" name="course_class_sec" class="custom-select" style="width:170px;">
            	<%while(itr.hasNext()){ %>
            	
            	<%ClassBean cb = (ClassBean)itr.next(); %>
				<option value="<%=cb.getClassID()%>"><%=cb.getCourse_code()%> : <%=cb.getSem() %> Sem <%=cb.getSection() %> Section</option>
				<%} %>
			</select>
            
            <input class="subbutton" type="submit" name="Login" placeholder="Login">

        </form>


    </body>
</html>