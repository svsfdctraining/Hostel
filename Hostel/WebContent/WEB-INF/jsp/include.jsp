<%@page import="com.school.pojo.Organization"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>School Maintenance</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.datepick.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pro_drop_1.css" />
<!--<script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.js" type="text/javascript"></script> -->
<script src="${pageContext.request.contextPath}/scripts/jquery-us.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/scripts/validations.js" type="text/javascript"></script>


<style type="text/css">
    h1 {
  font-family: Helvetica;
  font-weight: 100;
}
/* body {
  color:#333;
	text-align:center;
} */
    </style>


</head>
<body bgcolor="#DCDCDC">
<span class="preload1"></span>
<span class="preload2"></span>
<div align="center">

<div align="right">
<a href="${pageContext.request.contextPath}/login/logout.htm">Logout</a>
</div>

<ul id="nav" style="background-color:#DCDCDC;">
	
	<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Super Admin</span></a>
		<ul class="sub">
		<li><a href="#nogo3" class="fly">User</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/user/welcome.htm">Add</a></li>
						<li><a href="${pageContext.request.contextPath}/user/view.htm">View</a></li>
						<li><a href="${pageContext.request.contextPath}/user/search.htm">Search</a></li>
					</ul>
			</li>
			<li><a href="#nogo3" class="fly">Role</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/util/addrole.htm">Add</a></li>
						<li><a href="${pageContext.request.contextPath}/util/showroles.htm">View</a></li>
						<li><a href="${pageContext.request.contextPath}/util/editroles.htm">Edit</a></li>
					</ul>
			</li>
			<li class="mid"><a href="#nogo7" class="fly">Organisation</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/util/addorganization.htm">Add</a></li>
						<li><a href="${pageContext.request.contextPath}/util/viewall.htm?param=edit">Edit</a></li>
						<li><a href="${pageContext.request.contextPath}/util/viewall.htm?param=all">Show All</a></li>
						<li><a href="${pageContext.request.contextPath}/util/viewall.htm?param=search">Search</a></li>
						
					</ul>
			</li>
			<li class="mid"><a href="#nogo7" class="fly">Hostel</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/util/addHostel.htm">Add</a></li>
						<li><a href="${pageContext.request.contextPath}/util/viewhostel.htm?param=edit">View/Edit</a></li>
									
					</ul>
			</li>
			<li class="mid"><a href="#nogo7" class="fly">Extras</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/util/addcaste.htm">Add Caste</a></li>
						<li><a href="${pageContext.request.contextPath}/util/addreligion.htm">Add Religion</a></li>
						
					</ul>
			</li>
			
			</ul>
			</li>

<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Admin</span></a>
		<ul class="sub">
			<li class="mid"><a href="#nogo7" class="fly">Course</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/admin/class/add.htm">Add</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/class/view.htm">View</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/class/edit.htm">Edit</a></li>
					</li>
					</ul>
			</li>
			
			<li class="mid"><a href="#nogo7" class="fly">Medium</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/admin/medium/add.htm">Add</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/medium/view.htm">View</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/medium/edit.htm">Edit</a></li>
					</li>
					</ul>
			</li>
			<li class="mid"><a href="#nogo7" class="fly">Section</a>
					<ul>
					<li><a href="${pageContext.request.contextPath}/admin/section/add.htm">Add</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/section/edit.htm">Edit</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/section/view.htm">View</a></li>
			
					</ul>
					</li>
			<li><a href="#nogo3" class="fly">Promote</a>
					<ul>
						<li><a href="#nogo5">A Class</a></li>
						<li><a href="#nogo5">A Student</a></li>
						<li><a href="#nogo5">All Classes</a></li>
						
					</ul>
			</li>
</li>
</ul>

<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Student</span></a>
		<ul class="sub">
			<li><a href="${pageContext.request.contextPath}/student/welcome.htm">Add</a></li>
			<li><a href="${pageContext.request.contextPath}/student/search.htm?operation=update">Update</a></li>
			<li><a href="${pageContext.request.contextPath}/student/search.htm?operation=search">Search</a></li>
			<li><a href="${pageContext.request.contextPath}/student/import.htm">Import</a></li>
			<li><a href="${pageContext.request.contextPath}/student/studentexport.htm">Download</a></li>
			</ul>
			
<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Attendance</span></a>
		<ul class="sub">
			<li><a href="#nogo8">Add</a></li>
			<li><a href="#nogo8">View</a>
			<ul>
			<li><a href="#nogo8">Class</a></li>
			<li><a href="#nogo8">Student</a></li>
			</li></ul></ul>
			</li>

<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Fees</span></a>
		<ul class="sub">
			<li><a href="#nogo8">Pay</a></li>
			<li><a href="#nogo8">Inquiry</a></li>
			<li><a href="#nogo8">Report</a>
			<ul>
			<li><a href="#nogo8">Class</a></li>
			<li><a href="#nogo8">Due</a></li>
			</ul>
			</li>
			<li><a href="#nogo8">Search</a></li>
			<li><a href="#nogo8">Add Fee</a>
			<ul>
			<li><a href="#nogo8">Class</a></li>
			<li><a href="#nogo8">Student</a></li>
			<li><a href="#nogo8">Classes</a></li>
			</li>
			</ul>
			
			</li>		
			</ul>
			</li>

<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Time Table</span></a>
		<ul class="sub">
			<li><a href="#nogo8">Teache</a></li>
			<li><a href="#nogo8">Class</a></li>
			<li><a href="#nogo8">Classes</a></li>
			</ul>
		</li>
			
<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Exams</span></a>
		<ul class="sub">
			<li><a href="#nogo8">Schedule</a></li>
			<li><a href="#nogo8">Cancel</a></li>
			<li><a href="#nogo8">Re-Schedule</a></li>
			</ul>
	</li>

<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Marks</span></a>
		<ul class="sub">
			<li><a href="#nogo8">Add Marks</a>
			<ul>
						<li><a href="#nogo8">Class Wise</a></li>
						<li><a href="#nogo8">Student Wise</a></li>
						<li><a href="#nogo8">Exam Wise</a></li>
						<li><a href="#nogo8">Subject Wise</a></li>
			</ul>
			</li>
			<li><a href="#nogo8">Marks Report</a>
			<ul>
			<li><a href="#nogo8">Class Report</a></li>
						<li><a href="#nogo8">Student Report</a></li>
						<li><a href="#nogo8">Exam Report</a></li>
						<li><a href="#nogo8">Subject Report</a></li>
			</ul>		
		</li>
			</ul>
	</li>
<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Staff</span></a>
		<ul class="sub">
			<li><a href="#nogo8">Add</a></li>
			<li><a href="#nogo8">Edit</a></li>
			<li><a href="#nogo8">View</a></li>
			<li><a href="#nogo8">Search</a></li>
			</ul>
	</li>
									
<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">SMS</span></a>
		<ul class="sub">
			<li><a href="#nogo8">To All</a></li>
			<li><a href="#nogo8">To Absentees</a></li>
			<li><a href="#nogo8">To Specific Class</a></li>
			<li><a href="#nogo8">To A Student</a></li>
			</ul>
	</li>
	
	<li class="top"><a href="#nogo2" id="products" class="top_link"><span class="down">Travel Routes</span></a>
		<ul class="sub">
			<li><a href="#nogo8">Add Route</a></li>
			<li><a href="#nogo8">Edit Route</a></li>
			</ul>
	</li>

			</ul>
</div>			
			
</body>
</html>