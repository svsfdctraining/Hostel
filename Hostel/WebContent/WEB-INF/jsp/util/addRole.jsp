<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
</script>
</head>
<body>
<form:form commandName="userRole" action="saverole.htm" method="POST">
<div align="center">
<h2>${message}</h2>
<table>
<tr>
<td colspan="2">Add Role</td>
</tr>
<tr>
<td>Role Number</td>
<td> <form:input path="roleNum" /></td>
</tr>
<tr>
<td>Role Name</td>
<td> <form:input path="roleName" /></td>
</tr>
<tr>
<td>Role Status</td>
<td> <form:select path="status">
<form:option value="" label="Select"></form:option>
<form:options items="${stasuses}"/>
</form:select></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Save" ></input></td>
</tr>
</table>
</div>
</form:form>

</body>
</html>