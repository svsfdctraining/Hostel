<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function validateUser(){
	var caste=$('#religionname').val();
	$.ajax({
		      type: "POST",
		      url: "${pageContext.request.contextPath}/caste/validate.htm",
		      data: "caste=" + caste,
		      success: function(response){
		    	  alert('response '+response);
				if(response == 'exist'){
					alert('Duplicate Caste');
					return;
				}
		       
		       },
		        error: function(e){
		        alert('Error: ' + e);
		
		        }
		
		        }); 
}

function validateform(){
	
	return validatemandatory($('#religionname'),'Religion',$('#religionname').val(),false);
	
}
</script>
</head>
<body>
<form:form commandName="religion" action="savereligion.htm" method="POST" onsubmit="return validateform()">
<div align="center">
<table>
<tr>
<td colspan="2">Add Religion</td>
</tr>
<tr>
<td>${message}</td>
</tr>
<tr>
<td>Religion</td>
<td> <form:input path="religionname" onchange="validatemandatory(this,'Religion',this.value,false)"/>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Add"></input></td>
</tr>
</table>
<c:if test="${fn:length(religions)>0}">
Available Religions</hr></br>
<c:forEach var="religion" items="${religions}">
<c:out value="${religion.religionname}"></c:out></br>
</c:forEach>
</c:if>
</div>
</form:form>

</body>
</html>