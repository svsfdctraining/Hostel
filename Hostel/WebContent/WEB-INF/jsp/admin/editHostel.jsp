<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function validateform(){
	
	return validatemandatory($('#hostelName'),'hostelName',$('#hostelName').val(),false);
}
</script>
</head>
<body>
<form:form commandName="hostel" action="savehostel.htm" method="POST">
<div align="center">
<h2>${message}</h2>
<table style="background-color:#FFFACD;">
<tr>
<td colspan="2">Add Hostel</td>
</tr>
<tr>
</tr>

<tr>
<td>Organisation Name</td>
<td> <form:select path="orgname">
<form:options items="${organizations}" itemLabel="orgName" itemValue="orgName"/>
</form:select>
</tr>

<tr>
<td>Hostel Name</td>
<td> <form:input path="hostelName" /> </td>
</tr>

<tr>
<td>Hostel Address</td>
<td> <form:textarea path="address"/> </td>
</tr>

<tr>
<td>Hostel Status</td>
<td> <form:select path="status">
<form:option value="Active" label="Active"></form:option>
<form:option value="Inactive" label="Inactive"></form:option>
</form:select> </td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Save" onclick="validateform()"></input></td>
</tr>
</table>

</div>
</form:form>

</body>
</html>