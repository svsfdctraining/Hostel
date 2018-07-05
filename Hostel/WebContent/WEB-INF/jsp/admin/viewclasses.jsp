<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<form:form commandName="class">
<c:choose>
<c:when test="${fn:length(classes)>0}">
<div align="center" >
<h2>Classes</h2><br/>
<table style="background-color:#FFFACD;">
<tr>
<th>Course Name</th>
<th>Hostel Fee</th>
<th>College Fee</th>
<th>College Fee</th>
<th>No Of Years</th>
<th>Course Status</th>
</tr>

<c:forEach items="${classes}" var="cls">
<tr>
<td>${cls.classDesc}</td>
<td>${cls.classHostelFee}</td>
<td>${cls.classCollegeFee}</td>
<td>${cls.durationYears}</td>
<td>${cls.status}</td>
</tr>
</c:forEach>
</table>

</div>
</c:when>
<c:otherwise>
No Courses Found
</c:otherwise>
</c:choose>
</form:form>
</body>
</html>