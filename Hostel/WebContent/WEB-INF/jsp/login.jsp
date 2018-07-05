<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/scripts/jsDatePick_ltr.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pro_drop_1.css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery-us.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/jsDatePick.min.1.3.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<script type="text/javascript">
function validateandlogin(){
	var email=$('#email').val();
	alert('email'+email);
	
	var password=$('#userPassword').val();
	alert('password '+password);
	$.ajax({
		      type: "POST",
		      url: "${pageContext.request.contextPath}/login/validate.htm",
		      data: "email="+email+"&password="+password,
		      success: function(response){
				if(response == 'invaliduser'){
					alert('Invalid Username/Password');
					return;
				}
				if(response == 'orginactive'){
					alert('Your Organization is Inactive');
					return;
				}
		       
				if(response == 'valid'){
					document.forms[0].action = "${pageContext.request.contextPath}/login/login.htm";
				    document.forms[0].method = "GET";
				    document.forms[0].submit();
				}
				
		       },
		        error: function(e){
		        alert('Error: ' + e);
		
		        }
		
		        }); 
}

</script>
<script type="text/javascript">window.history.forward();function noBack(){window.history.forward();}</script>
<style type="text/css">
.error {
    	color: red;
    }
</style>
</head>
<body bgcolor="#FFFACD" onload="noBack()">
<div style="width:500px;height:700px; border-bottom-color: green; border-width:5px; " align="center" >
<form:form action="login.htm" method="POST" commandName="user">
<h3>User Login</h3>
${message}
<table>
<tr>
<td>User Name:</td>
<td> <form:input path="email"/><form:errors path="email" cssClass="error"/> </td>
</tr>
<tr>
<td> Password </td>
<td> <form:password path="userPassword"/><form:errors path="userPassword" cssClass="error"/> </td>
</tr>
<tr>
<td colspan="2"> <input type="submit" value="Login" /></td> 
</table>
</form:form>
</div>
</body>
</html>