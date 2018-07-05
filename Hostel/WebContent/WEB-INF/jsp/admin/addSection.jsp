<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function validateform(){
	var result=true;
	result= validatemandatory($('#classDesc'),'Class',$('#classDesc').val(),false);
	if(!result)
		return;
	result= validatemandatory($('#classfee'),'Fee',$('#classfee').val(),false);
	return result;
}
function loadvalues(val){
	if(val == '')
		return;
	document.forms[0].action = "${pageContext.request.contextPath}/admin/section/loadyers.htm?course="+val;
    document.forms[0].method = "POST";
    document.forms[0].submit();
}
</script>
</head>
<body>
<form:form commandName="section" action="save.htm" method="POST">
<div align="center">
<h3>${message}</h3>
<table>
<tr>
<td>Select Class</td>
<td>
<form:select path="stclass" onchange="loadvalues(this.value);">
<form:option value="" label="--Select--"></form:option>
<form:options items="${classes}" itemLabel="classDesc" itemValue="classValue"/>
</form:select>
</td>
</tr>
<tr>

<tr>
<td>Select Year</td>
<td>
<form:select path="year">
<form:options items="${years}" itemLabel="intvalue" itemValue="intvalue"/>
</form:select>
</td>
</tr>
<tr>
<td>Section</td>
<td><form:input path="sectionname" onchange="validatemandatory(this,'Class',this.value,false)"/>
<form:errors path="sectionname"/>
   </td>
</tr>
<tr>
<td>Maximum Students</td>
<td><form:input path="students"/> </td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Add"/>
</td>
</tr>
</table>
</div>
</form:form>
</body>
</html>