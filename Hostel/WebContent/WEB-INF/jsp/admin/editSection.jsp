<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function loadSections(val){
	
	document.forms[0].action = "${pageContext.request.contextPath}/admin/section/getsecdata.htm?param=edit";
    document.forms[0].method = "POST";
    document.forms[0].submit();
	
}
</script>
</head>
<body>
<form:form commandName="classbean" action="saveedited.htm" method="POST" modelAttribute="classbean">

<div align="center">
<c:if test="${fn:length(classbean.classes)>0}">
<div align="center" >
<h2>Sections</h2><br/>
<table style="background-color:#FFFACD;">
<tr><td>Select Class </td>
<td><form:select path="stclass" onchange="loadSections(this.value)">
<form:option value="0" label="--Select--"></form:option>
<form:options items="${classbean.classes}" itemLabel="classDesc" itemValue="classValue"/>
</form:select>  </td>
</tr>
<tr>
<th>Section</th>
<th>Maximum Students</th>
<th>Year</th>
<th>Status</th>
</tr>

<tr>${message}</tr>
<c:forEach items="${classbean.sections}" var="sec" varStatus="loop">
<form:hidden path="sections[${loop.index}].sectionname"/>
<form:hidden path="sections[${loop.index}].recid"/>
<form:hidden path="sections[${loop.index}].orgid"/>
<tr>
<td><form:input path="sections[${loop.index}].sectionname" disabled="true"/></td>
<td><form:input path="sections[${loop.index}].students"/></td>
<td><form:input path="sections[${loop.index}].year"/></td>
<td> <form:select path="sections[${loop.index}].status">
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