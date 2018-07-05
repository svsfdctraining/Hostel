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

</script>
</head>
<body>
<form:form commandName="class" action="save.htm" method="POST">
<div align="center">
<h3>${message}</h3>
<table>
<tr>
<td>Course</td>
<td><form:input path="classDesc" onchange="validatemandatory(this,'Class',this.value,false)"/>
<form:errors path="classDesc"/>
   </td>
</tr>
<tr>
<td>Course Duration</td>
<td><form:input path="durationYears" onchange="validatemandatory(this,'durationyears',this.value,false)"/>
<form:errors path="durationYears"/>
   </td>
</tr>
<tr>
<tr>
<td>Medium</td>
<td><form:select path="medium">
<form:options items="${mediums}" itemLabel="mediumname" itemValue="mediumname"/>
</form:select>
<form:errors path="medium"/>
   </td>
</tr>
<tr>
<td>Course Fee</td>
<td><form:input path="classCollegeFee" onchange="validatemandatory(this,'Fee',this.value,false)"/>
<form:errors path="classCollegeFee"/>
   </td>
</tr>
<tr>
<td>Hostel Fee</td>
<td><form:input path="classHostelFee" onchange="validatemandatory(this,'Fee',this.value,false)"/>
<form:errors path="classHostelFee"/>
   </td>
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