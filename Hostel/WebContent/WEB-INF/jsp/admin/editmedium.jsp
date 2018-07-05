<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<form:form commandName="classbean" action="saveedited.htm" method="POST" modelAttribute="classbean">

<div align="center">
<c:if test="${fn:length(classbean.mediums)>0}">
<div align="center" >
<h2>Mediums</h2><br/>
<table style="background-color:#FFFACD;">
<tr>
<th>Medium Name</th>
<th>Class Status</th>
</tr>

<c:forEach items="${classbean.mediums}" var="mdm" varStatus="loop">
<form:hidden path="mediums[${loop.index}].mediumid"/>
<form:hidden path="mediums[${loop.index}].mediumname"/>
<tr>
<td><form:input path="mediums[${loop.index}].mediumname" disabled="true"/></td>
<td> <form:select path="mediums[${loop.index}].status">
<form:option value="Active" label="Active"/>
<form:option value="InActive" label="InActive"/>
</form:select>
 </td>
</tr>
</c:forEach>
</table>
<input type="submit" value="Save"/>
</div>
</c:if>
</div>
</form:form>
</body>
</html>