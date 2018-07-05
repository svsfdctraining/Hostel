<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<br/>
<br/>
<div align="center">
<c:choose>
<c:when test="${fn:length(mediums)>0}">
<table style="background-color:#FFFACD;">
<tr>
<td colspan="2">
<h2>Mediums</h2></td>
</tr>
<tr>
<th>Medium Name</th>
<th>Medium Status</th>
</tr>
<c:forEach items="${mediums}" var="mdm">
<tr>
<td>${mdm.mediumname}</td>
<td>${mdm.status}</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
No Mediums Found
</c:otherwise>
</c:choose>
</div>
</body>
</html>