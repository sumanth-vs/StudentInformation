<%@ page language="java" import="com.bms.bean.UserBean"%>
<%UserBean ub = (UserBean) session.getAttribute("ub");%>


<!DOCTYPE html>
<html>
	<head>
		<title>Student Information Portal</title>
		<link rel="icon" href="Assets/sip_logo_fav.gif" type="image/gif" sizes="16x16">
		<link rel="stylesheet" type ="text/css" href="CSS/mainStyle.css">
		<link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">	</head>

	<body>
		<header>
			<div class = "main">
				<div class = "logo">
					<a href = "#"><img class = "logotext"  src = "Assets\sip_logo.png"></a>
				</div>
					<ul>
						<li class="active"><a href="#">Welcome <%=ub.getUserName() %></a></li>
						<li class = "active"><a href="#">Home</a></li>
						<li><a href="/StudentInformation/StudentServlet?action=aboutPage">About</a></li>
						<li><a href="/StudentInformation/StudentServlet?action=logout">Sign Out</a></li>
					</ul>
			</div>			
			
		</header>

		
		<section>
			<div class="title">
				<h1>
					Student Management.
				</h1>
				<h1>
					Simplified.
				</h1>

				<h3>
					Easy and Simple Information Management
				</h3>

			</div>
			
		</section>


		<section class="attendance-sec">
			<div>
				<img src="Assets\attendace_img.jpg">
			</div>
			<div class="attendance">
				<h2><a href="/StudentInformation/StudentServlet?action=activateStudentAccount">Change Account Status</a></h2>
			</div>
		</section>


		<section class="marks-sec">
			<div>
				<img class = "marks-img" src="Assets\aplus.jpg">
			</div>
			<div class="marks">
				<h2><a href="/StudentInformation/StudentServlet?action=addNewFaculty">Add Faculty</a></h2>
			</div>
		</section>


		<section class="project-sec">
			<div>
				<img class = "project-img" src="Assets\project.jpg">
			</div>
			<div class="project">
				<h2><a href="/StudentInformation/StudentServlet?action=addNewSubject">Add Subjects</a></h2>>
			</div>
		</section>



		<section class="complete-stud-sec">
				<div>
					<img class = "complete-stud-img" src="Assets/complete-student-records.webp">
				</div>
				<div class="complete-stud">
					<h2><a href="/StudentInformation/StudentServlet?action=addNewClass">Add Classes</a></h2>
				</div>
			</section>



		<footer>
			<div>
				<img class = "footer-img" src="Assets/footer-img.png">
			</div>

			<div class="footer-names">
				<ul>
					<li>Shashank Kumar</li><br></br>
					<li>Shreyas Mohan</li><br></br>
					<li>Sumanth V S</li><br></br>
					<li>Suraj Perdoor</li><br></br>
				</ul>
			</div>

			<div class="footer-copyright">
				<p>&copy; 2019 SIP Labs Inc.</p>
			</div>
		</footer>
		
	</body>
</html>
