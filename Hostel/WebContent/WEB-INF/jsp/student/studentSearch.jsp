<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function loadvalues(val){
	document.forms[0].action = "${pageContext.request.contextPath}/student/load.htm?param="+val;
    document.forms[0].method = "POST";
    document.forms[0].submit();
	
}
function openwindow(val,value){

	document.forms[0].action = "${pageContext.request.contextPath}/student/vieworedit.htm?studentSeq="+value;
    document.forms[0].method = "POST";
    document.forms[0].submit();
}

</script>

</head>
<body>
<form:form modelAttribute="studentbean" method="POST" action="searchresults.htm" onsubmit="return validatesearch()">
<div align="center">
<table>
<tr>
<td>Academic Year</td>
<td><form:select path="academicyear">
<form:options items="${studentbean.academicyears}" itemLabel="label" itemValue="value"/>
</form:select></td>
<td>Class</td>
<td><form:select path="stclass" onchange="loadvalues('searchsections')"> 
<form:option value="" label="---Select---"></form:option>
<form:options items="${studentbean.classes}" itemLabel="classDesc" itemValue="classValue"/>
</form:select></td><br/>
</tr>
<tr>
<td>Section</td><td><form:select path="section">
<form:option value="" label="--Select--"/>
<form:options items="${studentbean.sections}" itemLabel="sectionname" itemValue="sectionname"/>
</form:select> </td>

<td>Medium</td><td><form:select path="medium">
<form:option value="" label="--Select--"/>
<form:options items="${studentbean.mediums}" itemLabel="mediumname" itemValue="mediumname"/>
</form:select> </td>
<br/>
</tr>
<tr></tr>
<tr>
<td>Student Name </td><td><form:input path="name"/></td>
<td>Father Name</td><td><form:input path="fname"/></td>
<td>Status</td><td><form:select path="status">
<form:option value="" label="--Select--"></form:option>
<form:option value="Active" label="Active"></form:option>
<form:option value="InActive" label="InActive"></form:option>
</form:select>
</td>
</tr>
<tr>
<td colspan="4">
<input type="submit" value="Search"/>
</td>
</tr>
</table>
</div>
<div align="center">
<c:if test="${fn:length(studentbean.results)>0}">

<table>
<tr class="trs">
<th>Admission Number</th>
<th>First Name</th>
<th>Last Name</th>
<th>Parent Name</th>
<th>Class</th>
<th>Medium</th>
<th>Section</th>
<th>Academic Year</th>
<th>Status</th>
</tr>
<c:forEach items="${studentbean.results}" var="result" varStatus="loop">
<form:hidden path="results[${loop.index}].studentSeq"/>
<tr>
<c:choose>
<c:when test="${studentbean.operation == 'update'}">
<td align="center"><a href="#" onclick="openwindow('edit',${result.studentSeq})">${result.admissionNo}</a> </td>
</c:when>
<c:otherwise>
<td align="center"><a href="#" onclick="openwindow('read',${result.studentSeq})">${result.admissionNo}</a> </td>
</c:otherwise>
</c:choose>

<td>${result.firstname} </td>
<td>${result.lastname} </td>
<td>${result.parentName} </td>
<td>${result.stclass} </td>
<td>${result.medium} </td>
<td>${result.section} </td>
<td>${result.academicyear} </td>
<td>${result.status} </td>
</tr>
</c:forEach>

</table>
</c:if>
</div>

</form:form>
</body>
</html>