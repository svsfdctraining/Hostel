<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.head{
color:red;
}
</style>
<script type="text/javascript">
function loadvalues(val){
	document.forms[0].action = "${pageContext.request.contextPath}/student/load.htm?page=upload&param="+val;
    document.forms[0].method = "POST";
    document.forms[0].submit();
	
}
function Validate()
{
   var image =document.getElementById("document").value;
   if(image!=''){
        var checkimg = image.toLowerCase();
        if (!checkimg.match(/(\.xls|\.xlsx)$/)){
            alert("Please select a File with .xls or .xlsx extensions");
            document.getElementById("document").focus();
            return false;
          }
       }
   return true;
}
</script>
</head>
<body>
<form:form action="uploadfile.htm" method="POST" modelAttribute="studentbean" enctype="multipart/form-data" onsubmit="return Validate();">
<br/><br/><br/>
<div align="center">
<h2 class="head">${message}</h2>

<div align="center">
<table>
<tr>
<td>Academic Year</td>
<td><form:select path="academicyear">
<form:options items="${studentbean.academicyears}" itemLabel="label" itemValue="value"/>
</form:select></td>
<br/>
</tr>
</table>
<br/><br/><br/>
<table>
		<tr>
			
			<td> <input type="file" name="uploadfile" id="document"/></td>
		</tr>
		<tr>
			<td><br />
			</td>
			<td><input type="submit" value="Upload" /></td>
		</tr>
	</table>
</div>
<div>
<c:if test="${studentbean.uploadstatus == false}">
<c:if test="${fn:length(studentbean.uploadresults)>0}">
<table>
<tr>
<th>Row Number</th>
<th>Admission Number</th>
<th>First Name</th>
<th>Last Name</th>
<th>Status</th>
</tr>
<c:forEach items="${studentbean.uploadresults}" var="result" varStatus="loop">
<tr>
<td> ${result.rownum}</td>
<td>${result.admissionnum}</td>
<td>${result.firstname}</td>
<td>${result.lastname}</td>
<td>${result.status}</td>
</tr>
</c:forEach>
</table>
</c:if>
</c:if>
</div>

</form:form>
</body>
</html>