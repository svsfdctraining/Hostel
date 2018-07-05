<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function loadvalues(val){
	
	
	if(val=='' || val=='')
		return;
	
	
	document.forms[0].action = "${pageContext.request.contextPath}/util/load.htm?param=loadhostels&orgId="+val;
    document.forms[0].method = "POST";
    document.forms[0].submit();
	
}
</script>
</head>
<body>
<div align="center">
<form:form commandName="hostelbean" action="viewhostel.htm" method="POST">
<div style="widht:700px;">
<table style="background-color:#FFFACD;">
<tr>
<td colspan="2">Hostels</td>
</tr>
<tr>
</tr>

<tr>
<td>Select Organisation</td>
<td> <form:select path="orgname" onchange="loadvalues(this.value)">
<form:option value="" label="--Select--"></form:option>
<form:options items="${organizations}" itemLabel="orgName" itemValue="orgId"/>
</form:select></tr>
</table>

</div>
<c:choose>
<c:when test="${fn:length(hostels)>0}">
<div align="center">
			<h2>Hostels</h2>
<table style="background-color:#FFFACD; ">
<tr>
<th>Organization</th>
<th>Hostel name</th>
<th>Address</th>
<th>Status</th>

</tr>

<c:forEach var="hostel" items="${hostels}">

<tr>
<td>${hostel.orgname}</td>
<td>
<c:choose>
<c:when test="${status == 'edit'}">
<a href="${pageContext.request.contextPath}/util/load.htm?param=edithostel&hostelname=${hostel.hostelName}">${hostel.hostelName}</a>
</c:when>
<c:otherwise>
${hostel.hostelName}
</c:otherwise>
</c:choose>
</td>
<td>${hostel.address}</td>
<td>${hostel.status}</td>
</tr>
</c:forEach>
</table>
</div>

</c:when>
<c:otherwise>
<div>
No Hostels Found
</div>
</c:otherwise>
</c:choose>
<div>




</div>
</form:form>
</div>
</body>
</html>