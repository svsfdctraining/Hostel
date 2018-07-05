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
<c:when test="${fn:length(roles)>0}">

<div align="center">
			<h2>Roles</h2>
<table style="background-color:#FFFACD; ">
<tr>
<th>Role Id</th>
<th>Role Name</th>
<th>Role Number</th>
<th>Status</th>

</tr>

<c:forEach var="org" items="${roles}">

<tr>
<td>
<c:choose>
<c:when test="${status == 'edit'}">
<a href="${pageContext.request.contextPath}/util/addorganization.htm?param=edit&roleId=${org.roleId}">${org.roleId}</a>
</c:when>
<c:otherwise>
${org.roleId}
</c:otherwise>
</c:choose>
</td>
<td>${org.roleName}</td>
<td>${org.roleNum}</td>
<td>${org.status}</td>
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