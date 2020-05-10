<%@ page language="java" import="com.bms.bean.StudentBean"%>
<%StudentBean sb = (StudentBean)request.getAttribute("sb"); %>


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
						<li>Welcome <%=sb.getName() %></li>
						<li class = "active"><a href="#">Home</a></li>
						<li><a href="about.html">About</a></li>
						<li><a href="/StudentInformation/StudentServlet?action=logout">Sign Out</a></li>
						<!-- <li><a href="login.html">Login</a></li> -->
						<!-- <li><img src="Assets/user.png" alt="Suraj Profile" 
						style="max-width: 70px;
						border-radius: 20px;
						
						position: absolute;
						top: 3%;
						left: 60%;
						"></li> -->
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
				<h2><a href="/StudentInformation/StudentServlet?action=getStudentAttendance&stdID=<%=sb.getStdid()%>">Maintain and Track Attendance</a></h2>
				<p>
					SIP makes it incredibly easy to update the attendance for each class.
					It puts this vital information at the fingertips of students.
				</p>
			</div>
		</section>


		<section class="marks-sec">
			<div>
				<img class = "marks-img" src="Assets\aplus.jpg">
			</div>
			<div class="marks">
				<h2><a href="marks.html">Show Student's Marks</a></h2>
				<p>
					Students can access their records anywhere, anytime
				</p>
			</div>
		</section>

		<section class="project-sec">
			<div>
				<img class = "project-img" src="Assets\project.jpg">
			</div>
			<div class="project">
				<h2><a href="Projects.html">Projects, Assignments.</a></h2>
				<p>
					Students can submit them all from one place
				</p>
			</div>
		</section>



		<section class="complete-stud-sec">
				<div>
					<img class = "complete-stud-img" src="Assets/complete-student-records.webp">
				</div>
				<div class="complete-stud">
					<h2><a href="/StudentInformation/StudentServlet?action=getStudentInfo&stdID=<%=sb.getStdid()%>">Complete Student Details</a></h2>
					<p>
						Complete Student Information at your fingertips
					</p>
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



		<!-- <section>
			<div class = "title">
				<h1>Student</h1>
			</div>
			<div class = "button">
					<a href = "login.html" class = "btn">Sign Up</a>
					<a href = "#" class = "btn">Sign In</a>
			</div>
			
			<div class = "titlef">
				<h1>Faculty</h1>
			</div>
			<div class = "buttonf">
					<a href = "login.html" class = "btnf">Sign Up</a>
					<a href = "#" class = "btnf">Sign In</a>
			</div>
		</section> -->


	</body>
</html>
