<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<form:form action="viewall.htm"  method="GET">

<div align="center">

<c:choose>
<c:when test="${fn:length(users)>0}">

<div align="center">
			<h2>Users</h2>
<table style="background-color:#FFFACD; ">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Address</th>
<th>Email</th>
<th>Status</th>
<th>Role</th>
</tr>

<c:forEach var="user" items="${users}">

<tr>
<td>${user.userFirstName}</td>
<td>${user.userLastName}</td>
<td>${user.address}</td>
<td>${user.email}</td>
<td>${user.status}</td>
<td>${user.role}</td>
</tr>
</c:forEach>
</table>
</div>
</c:when>
<c:otherwise>
<h2>Results Not Found</h2>
</c:otherwise>
</c:choose>
</form:form>

</body>
</html>