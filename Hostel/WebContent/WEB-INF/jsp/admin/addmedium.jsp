<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function validateform(){
	
	return validatemandatory($('#mediumname'),'Medium',$('#mediumname').val(),false);
	
}
</script>
</head>
<body>
<form:form commandName="medium" action="save.htm" method="POST">
<div align="center">
<h3>${message}</h3>
<table>
<tr>
<td>Medium</td>
<td><form:input path="mediumname" onchange="validatemandatory(this,'Medium',this.value,false)"/>   </td>
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