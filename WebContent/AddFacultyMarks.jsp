<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> attList = (ArrayList<FacultyBean>)request.getAttribute("addMarksL"); %>
<%Iterator itr = attList.iterator(); %>
<%FacultyBean fb = (FacultyBean)request.getAttribute("fb"); %>

<!DOCTYPE html>
<html>

<head>
    <title>Marks</title>
    <style>
        body{
            background-color: black;
        }
        table {
            margin: 75px;
            border-collapse: collapse;
            width: 90%;
        }
        th,
        td {
            color: white;
            text-align: left;
            padding: 20px;
        }

        tr:nth-child(even) {
            background-color: #0b0c0c;
        }
    </style>
</head>

<body>
    <h1 style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px;">Monitor Your Students' Marks</h1>
    <!-- <div style="margin: 80px;">
        <p style="font-family: Helvetica; color: white;">* Minimum Marks for eligibility is 20 in each course</p>
        <p style="font-family: Helvetica;color: white;">* Best two marks of three tests will be considered for CIE</p>
        <p style="font-family: Helvetica;color: white;">* If CIE Marks is below 20, you are NOT ELIGIBLE to take up the SEE for that course.</p>
        <p style="font-family: Helvetica;color: white;">* Please contact your proctor for further details: Mrs. Antara De (+919538433364)</p>
    </div> -->
    
    <div style="margin: 80px;">
        <h2 style="font-family: Helvetica; color: white; position: absolute; top: 57%;">
            Semester : <%=fb.getSem() %> | Section : <%=fb.getSection() %> |Branch : <%=fb.getCourse() %>
        </h2>
    </div>


    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute;top: 57%;">
        <table>
            <tr>
                <th>Student Name</th>
                <th>Test 1 (/20)</th>
                <th>Test 2 (/20)</th>
                <th>Test 3 (/20)</th>
                <th>LAB/AAT (/10)</th>
            </tr>
            <%while(itr.hasNext()){ %>
			<%FacultyBean fb1 = (FacultyBean)itr.next(); %>
            <tr>
                <td><%=fb1.getStudent_name() %></td>
                <font color="white"><td><input type="text" name="cie1" placeholder="CIE1"></td></font>
                <font color="white"><td><input type="text" name="cie2" placeholder="CIE2"></td></font>
                <font color="white"><td><input type="text" name="cie3" placeholder="CIE3"></td></font>
                <font color="white"><td><input type="text" name="lab" placeholder="LAB"></td></font>
            </tr>
            <%} %>
        </table>
    </div>

</body>

</html>