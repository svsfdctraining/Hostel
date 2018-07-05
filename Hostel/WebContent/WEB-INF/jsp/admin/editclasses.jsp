<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

<form:form commandName="classbean" action="saveedited.htm" method="POST">

<div align="center">
<c:choose>
<c:when test="${fn:length(classbean.classes)>0}">
<div align="center" >
<h2>Courses</h2><br/>
<table style="background-color:#FFFACD;">
<tr>
<th>Course Name</th>
<th>Course Fee</th>
<th>Hostel Fee</th>
<th>Course Status</th>
</tr>

<c:forEach items="${classbean.classes}" var="classes" varStatus="loop">
<form:hidden path="classes[${loop.index}].class_id"/>
<form:hidden path="classes[${loop.index}].classDesc"/>
<tr>
<td><form:input path="classes[${loop.index}].classDesc" disabled="true"/></td>
<td> <form:input path="classes[${loop.index}].classCollegeFee"/> </td>
<td> <form:input path="classes[${loop.index}].classHostelFee"/> </td>
<td><form:select path="classes[${loop.index}].status">
<form:option value="Active" label="Active"/>
<form:option value="InActive" label="InActive"/>
</form:select>
</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="Save"/>
</div>
</c:when>
<c:otherwise>
No Courses Found
</c:otherwise>
</c:choose>

</div>
</form:form>
</body>
</html>