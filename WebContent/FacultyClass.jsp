<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> facList = (ArrayList<FacultyBean>)request.getAttribute("fl"); %>
<%Iterator itr = facList.iterator(); %>
<%UserBean ub = (UserBean) session.getAttribute("ub"); %>


<%while(itr.hasNext()){ %>
<%FacultyBean fb = (FacultyBean)itr.next(); %>
	<%=fb.getSem() %> | <%=fb.getSection() %> | <%=fb.getCourse() %> | <%=fb.getSub_name() %> | <a href="/StudentInformation/StudentServlet?action=getFacultyAttendance&classID=<%=fb.getClass_id()%>&subID=<%=fb.getSub_id()%>">Maintain attendance</a> | <a href="/StudentInformation/StudentServlet?action=getFacultyMarks&classID=<%=fb.getClass_id()%>&subID=<%=fb.getSub_id()%>">Maintain Marks</a>
	<br></br>
<%}%>
<br></br>
<a href="/StudentInformation/StudentServlet?action=getFacultyHomepage&facID=<%=ub.getUserID()%>">Back To Homepage</a>