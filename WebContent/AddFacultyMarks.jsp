<%@ page language="java" import="com.bms.bean.*, java.util.*"%>
<%ArrayList<FacultyBean> attList = (ArrayList<FacultyBean>)request.getAttribute("addMarksL"); %>
<%Iterator<FacultyBean> itr = attList.iterator(); %>
<%FacultyBean fb = (FacultyBean)request.getAttribute("fb"); %>
<%int sub_ID = (int) request.getAttribute("subID"); %>
<%int class_ID = (int) request.getAttribute("classID"); %>

<!DOCTYPE html>
<html>

<head>
    <title>Marks</title>
    
    <link href="https://fonts.googleapis.com/css?family=Bebas+Neue&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
    
    <style>
        body{
            background-color: black;
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
        
        
        
        
        
        
        
	        /* The container must be positioned relative: */
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
	        
	        
	        
	        
	        
		.box input[type = "text"]{
			    background: none;
			    display: block;
			    margin: 5px auto;
			    text-align: center;
			    border: .5px solid white;
			    padding: 14px 10px;
			    width: 400px;
			    outline: none;
			    color: white;
			    transition: .25s ease;
			}
			
			.box input[type = "text"]:hover{
			    border-color: rgb(10, 165, 69);
			}
			
			.box input[type = "text"]:focus{
			    width: 280px;
			    border-color: rgb(12, 199, 37);
			    
			}
			
			
			.box input[type = "submit"]{
			    font-family: 'Bebas Neue', cursive;
			    font-size: 23px;
			    background: none;
			    text-align: center;
			    border: 2px solid white;
			    height: 50px;
			    width: 200px;
			    color: white;
			    transition: .25s;
			    cursor: pointer;
			}
			
			.box input[type = "submit"]:hover{
			
			    background:   rgb(26, 224, 115);
			    color: black;
			}
        
        
        
        
        
        
    </style>
</head>

<body>
    <h1 style="color: white; font-family: 'Lucida Sans'; text-align: center; padding: 10px;">Monitor Your Students' Marks</h1>
    
    <div>
			<img
				style="max-width: 100px; position: absolute; left: 43%; border-radius: 20px"
				src="Assets/teacher.jpg" alt="SurajFail">
	</div>
	
    
    <div style="margin: 80px;">
        <h2 style="font-family: Helvetica; color: red; position: absolute; top: 57%;">
            Semester : <%=fb.getSem() %> | Section : <%=fb.getSection() %> |Branch : <%=fb.getCourse() %>
        </h2>
    </div>


	<form action="/StudentInformation/StudentServlet">
		<input type="hidden" name="action" value="addFacultyMarksValues">
		<input type="hidden" name="subID" value="<%=sub_ID%>">
		<input type="hidden" name="classID" value="<%=class_ID%>">
	    <div style="overflow-x:auto; font-family: Verdana, Geneva, Tahoma, sans-serif; position: absolute;top: 67%; left:10%;">
	        <table>
		        <tr>
		        	<td>
		        		<select name="internalType" class="custom-select" style="width:90px;">
		        			<option>Select</option>
		        			<option value="cie1">CIE 1</option>
		        			<option value="cie2">CIE 2</option>
		        			<option value="cie3">CIE 3</option>
		        			<option value="lab">LAB</option>
		        		</select>
		        	</td>
		        </tr> 
	        	
	        	<tr>
		        	<th style="background-color: #818181;">Student Name</th>
		        	<th style="background-color: #818181;">Marks</th>
	        	</tr>
	        	
	            <%while(itr.hasNext()){ %>
				<%FacultyBean fb1 = (FacultyBean)itr.next(); %>
	            
	            <tr class="box">
	                <td><input type="text" value="<%=fb1.getStudent_name() %>" readonly="readonly"></td>
	                <font color="white"><td><input type="text" name="internalMarks"></td></font>
	                <td><input type="hidden" name="stdID" value="<%=fb1.getStudent_id()%>"></td>
	            </tr>
	            
	            <%} %>
	            
	            
	            <tr class="box"><td><input type="submit" value="Add Marks"></td></tr>
	        </table>
	    </div>    
    </form>

</body>

</html>