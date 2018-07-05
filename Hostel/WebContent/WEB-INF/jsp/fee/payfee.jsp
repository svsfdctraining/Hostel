<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function viewbill(){
	
	if( confirm("Are you sure to Continue..?")){
		document.forms[0].action = "${pageContext.request.contextPath}/fee/paystfee.htm";
	    document.forms[0].method = "POST";
	    document.forms[0].submit();
	}
	
}

function validateform(){
	alert($("#feeType").val());
return false;	
}
</script>
<style type="text/css">
.error {
    	color: red;
    }
.heading{
color:red;
}
.tds{
width:150px; 
}
</style>
</head>
<body>
<form:form commandName="studentFeeBean" action="viewbill.htm" method="POST" >
<div align="center">
<form:hidden path="feeType"/>
<c:choose>
<c:when test="${studentFeeBean.feeType == 'college'}">
<div><h3>College Fee Payment</h3></div>
<table>
<tr><td>Admission Number</td><td><form:input path="collegeFee.StudentadmissionNo" disabled="true"/> </td> </tr>
<tr><td>Student Name</td><td><form:input path="collegeFee.studentname" disabled="true"/> </td> </tr>
<tr><td>Course</td><td><form:input path="collegeFee.stcourse" disabled="true"/> </td> </tr>
<tr><td>Year</td><td><form:input path="collegeFee.courseYear" disabled="true"/> </td> </tr>
<tr><td>Due Amount</td><td><form:input path="collegeFee.prevBalance" disabled="true"/> </td> </tr>
<tr><td>Payment Type</td><td><form:input path="collegeFee.paymentType"/><form:errors path="collegeFee.paymentType" cssClass="error"/> </td> </tr>
<tr><td>Current Payment</td><td><form:input path="collegeFee.currentPay"/><form:errors path="collegeFee.currentPay" cssClass="error"/> </td> </tr>
<tr><td>Comments</td><td><form:input path="collegeFee.description"/><form:errors path="collegeFee.description" cssClass="error"/> </td> </tr>
<tr>
<tr><td colspan="2"><input type="button" value="Pay" onclick="viewbill()"/> </td></tr>
</table>
</c:when>
<c:otherwise>
<div><h3>Hostel Fee Payment</h3></div>
<table>
<tr><td>Admission Number</td><td><form:input path="hostelfee.StudentadmissionNo" disabled="true"/> </td> </tr>
<tr><td>Student Name</td><td><form:input path="hostelfee.studentname" disabled="true"/> </td> </tr>
<tr><td>Course</td><td><form:input path="hostelfee.stcourse" disabled="true"/> </td> </tr>
<tr><td>Year</td><td><form:input path="hostelfee.courseYear" disabled="true"/> </td> </tr>
<tr><td>Due Amount</td><td><form:input path="hostelfee.prevBalance" disabled="true"/> </td> </tr>
<tr><td>Payment Type</td><td><form:input path="hostelfee.paymentType"/><form:errors path="hostelfee.paymentType" cssClass="error"/> </td> </tr>
<tr><td>Current Payment</td><td><form:input path="hostelfee.currentPay"/><form:errors path="hostelfee.currentPay" cssClass="error"/> </td> </tr>
<tr><td>Comments</td><td><form:input path="hostelfee.description" /><form:errors path="hostelfee.description" cssClass="error"/> </td> </tr>
<tr>
<tr><td colspan="2"><input type="button" value="Pay" onclick="validateform()"/>  </td></tr>
</table>
</c:otherwise>
</c:choose>

</div>

</form:form>

</body>
</html>