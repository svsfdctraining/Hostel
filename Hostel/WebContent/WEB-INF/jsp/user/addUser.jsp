<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/jsp/include.jsp" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
  
<script type="text/javascript">
function validateUser(){
	var model=$('#userName').val();
	$.ajax({
		      type: "POST",
		      url: "${pageContext.request.contextPath}/login/validate.htm",
		      data: "model=" + model,
		      success: function(response){
		    	  alert('response '+response);
				if(response == 'valid1'){
					alert('Please enter a valid Model Number');
					return;
				}
		       
		       },
		        error: function(e){
		        alert('Error: ' + e);
		
		        }
		
		        }); 
}
</script>
<title>Add User</title>
</head>
<body>
<div>
<form:form action="save.htm" commandName="user">
<h2 align="center">New User Registration</h2>
<table  bordercolor="green" border="3px;" align="center">
<tr>
<td colspan="2"><h2>${message}</h2></td>
</tr>
<tr>
<td>First Name :</td>
<td><form:input path="user.userFirstName" onchange="validatemandatory(this,'First Name',this.value,false)"/></td>
</tr>
<tr>
<td>Middle Name : </td>
<td><form:input path="user.userMiddleName" onchange="validatemandatory(this,'Middle Name',this.value,false)"/> </td>
</tr>

<tr>
<td> Last Name :</td>
<td><form:input path="user.userLastName" onchange="validatemandatory(this,'Last Name',this.value,false)"/> </td>
</tr>

<tr>
<td> Address :</td>
<td><form:textarea path="user.address" onchange="validatemandatory(this,'Address',this.value,true)"/> </td>
</tr>

<tr>
<td>Password :</td>
<td><form:password path="password1" onchange="validatemandatory(this,'Password',this.value,true)"/></td>
</tr>

<tr>
<td>Re-type Password : </td>
<td><form:password path="password2" onchange="validatemandatory(this,'Retype Password',this.value,true)"/></td>
</tr>
<tr>
<td>Email-Id :</td>
<td><form:input path="user.email" onchange="validateemail(this,'Email',this.value,true)"/></td>
</tr>
<tr>
<td>Mobile :</td>
<td><form:input path="user.mobile" onchange="validatemobile(this,'Mobile',this.value,false)"/></td>
</tr>
<tr>
<td>Organisation :</td>
<td><form:select path="user.orgId">
<form:options items="${orgs}" itemLabel="label" itemValue="val"/>
</form:select></td>
</tr>
<tr>
<td>Hostel User</td>
<td><form:select path="user.isHostelUser">
<form:option value="Yes" label="Yes"/>
<form:option value="No" label="No"></form:option>
</form:select> </td>
</tr>
<tr>
<td>User Role :</td>
<td><form:select path="user.role">
<form:options items="${roles}" itemLabel="roleName" itemValue="roleNum"/>
</form:select></td>
</tr>
<tr>

<tr>
<td>Status :</td>
<td><form:select path="user.status">
<form:option value="Active">Active</form:option>
<form:option value="InActive">InActive</form:option>
</form:select>
</td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="Register"></td>

</tr>
</table>
</form:form>
</div>
</body>
</html>