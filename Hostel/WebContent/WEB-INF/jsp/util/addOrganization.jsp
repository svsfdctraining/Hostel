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
<form:form commandName="organization" action="saveorganization.htm" method="POST">
<div align="center">
<h2>${message}</h2>
<table style="background-color:#FFFACD;">
<tr>
<td colspan="2">Add Organization</td>
</tr>
<tr>
</tr>
<tr>
<td>Organisation Name</td>
<td> <form:input path="orgName" />
</tr>
<tr>
<td>Hostel Availability</td>
<td> <form:select path="isHostel">
<form:option value="Yes" label="Yes"/>
<form:option value="No" label="No"/>
</form:select>
</tr>
<tr>
<td>Registration Number</td>
<td> <form:input path="regNum" />
</tr>
<tr>
<td>Established Year</td>
<td> <form:select path="year">
<form:option value="0" label="Select"></form:option>
<form:options items="${years}" itemLabel="intlabel" itemValue="intvalue"/>
</form:select>
</tr>

<tr>
<td colspan="2">Address</td>
</tr>
<tr>
<td>Street</td>
<td> <form:input path="street" /></td>
</tr>
<tr>
<td>Mandal</td>
<td> <form:input path="mandal" /></td>
</tr>
<tr>
<td>Taluk</td>
<td> <form:input path="taluk" /></td>
</tr>
<tr>
<td>District</td>
<td> <form:input path="district" /></td>
</tr>
<tr>
<td>State</td>
<td> <form:input path="state" /></td>
</tr>
<tr>
<td>Country</td>
<td> <form:input path="country" /></td>
</tr>
<tr>
<td>other</td>
<td> <form:input path="other" /></td>
</tr>
<tr>
<td>status</td>
<td> <form:select path="status">
<form:option value="" label="Select"></form:option>
<form:options items="${stasuses}"/>
</form:select></td>
</tr>
<tr>
<td>Expiry Date</td>
<td> <form:input path="expiryDate" /></td>
</tr>
<tr>
<td>Licences</td>
<td> <form:input path="licencedStudents" /></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="Save" onclick="validatecaste()"></input></td>
</tr>
</table>

</div>
</form:form>

</body>
</html>