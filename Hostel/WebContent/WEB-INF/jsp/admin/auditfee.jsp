<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
updateview(value){
	alert('value '+value);
}
</script>
</head>
<body>
<form:form commandName="adminbean" action="save.htm" method="POST">
<div align="center">
<h2>Add Fee</h2>
<table>
<tr><td>Add Fee To</td>
<td>
<form:select path="type" onchange="updateview(this.value)">
<form:option value="" label="--Select--"/>
<form:option value="Class" label="Class"/>
<form:option value="All Classes" label="All Classes"/>
<form:option value="Student" label="Student"/>
</form:select>
</td>
</tr>
</table>
</div>
</form:form>
</body>
</html>