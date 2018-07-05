<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

<form:form commandName="classbean" action="saveeditedroles.htm" method="POST">

<div align="center">
<c:if test="${fn:length(classbean.userroles)>0}">
<div align="center" >
<h2>Role</h2><br/>
<table style="background-color:#FFFACD;">
<tr>
<th>Role Name</th>
<th>Role Number</th>
<th>Role Status</th>
</tr>

<c:forEach items="${classbean.userroles}" var="classes" varStatus="loop">
<form:hidden path="userroles[${loop.index}].roleId"/>
<form:hidden path="userroles[${loop.index}].roleName"/>
<form:hidden path="userroles[${loop.index}].roleNum"/>
<tr>
<td><form:input path="userroles[${loop.index}].roleName" disabled="true"/></td>
<td><form:input path="userroles[${loop.index}].roleNum" disabled="true"/></td>
<td><form:select path="userroles[${loop.index}].status">
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