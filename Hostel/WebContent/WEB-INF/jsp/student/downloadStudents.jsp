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
<form:form modelAttribute="studentbean" method="POST" action="downloadandexport.htm">
<div align="center">
<table>
<tr>
<td>Academic Year</td>
<td><form:select path="academicyear">
<form:options items="${studentbean.academicyears}" itemLabel="label" itemValue="value"/>
</form:select></td>
<td>Class</td>
<td><form:select path="stclass"> 
<form:option value="0" label="---Select---"></form:option>
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
<input type="submit" value="Download"/>
</td>
</tr>
</table>
</div>


</form:form>
</body>
</html>