<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<form:form commandName="organization" action="viewall.htm"  method="GET">

<div align="center">

<c:if test="${status == 'search'}">
<table>
<tr>
<td>Organisation Name</td>
<td> <form:input path="orgName"/>  </td>
</tr>
<tr>
<td>Registration Number</td>
<td> <form:input path="regNum"/>  </td>
</tr>
<tr>
<td>Established Year</td>
<td> <form:input path="year"/>  </td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Search"/>
</td>
</tr>
</table>
</c:if>
</div>

<c:choose>
<c:when test="${fn:length(organizations)>0}">

<div align="center">
			<h2>Organisations</h2>
<table style="background-color:#FFFACD; ">
<tr>
<th>Organisation Id</th>
<th>Organisation Name</th>
<th>Registration Number</th>
<th>Established Year</th>
<th>Street</th>
<th>Mandal</th>
<th>Taluk</th>
<th>District</th>
<th>State</th>
<th>Country</th>
<th>Status</th>

</tr>

<c:forEach var="org" items="${organizations}">

<tr>
<td>
<c:choose>
<c:when test="${status == 'edit'}">
<a href="${pageContext.request.contextPath}/util/addorganization.htm?param=edit&orgId=${org.orgId}">${org.orgId}</a>
</c:when>
<c:otherwise>
${org.orgId}
</c:otherwise>
</c:choose>
</td>
<td>${org.orgName}</td>
<td>${org.regNum}</td>
<td>${org.year}</td>
<td>${org.street}</td>
<td>${org.mandal}</td>
<td>${org.taluk}</td>
<td>${org.district}</td>
<td>${org.state}</td>
<td>${org.country}</td>
<td>${org.status}</td>
</tr>
</c:forEach>
</table>
</div>
</c:when>
<c:otherwise>
<h2>Search Results Not Found</h2>
</c:otherwise>
</c:choose>
</form:form>

</body>
</html>