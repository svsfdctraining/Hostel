<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">

$(document).ready(function () {
	
	
	 $("#birthdate").datepicker({ dateFormat: 'dd-mm-yy',
        changeMonth: true,//this option for allowing user to select month
        changeYear: true //this option for allowing user to select from year range
      }); 
	 $("#collegeLeaveDate").datepicker({dateFormat: 'dd-mm-yy',
	        changeMonth: true,//this option for allowing user to select month
	        changeYear: true //this option for allowing user to select from year range
	      });
	 
	 $("#joinedDate").datepicker({dateFormat: 'dd-mm-yy',
	        changeMonth: true,//this option for allowing user to select month
	        changeYear: true //this option for allowing user to select from year range
	      });
	 
	 document.getElementById("isstc").disabled=true;
	 document.getElementById("isscc").disabled=true;
	 document.getElementById("isssc").disabled=true;
	 document.getElementById("issmm").disabled=true;
	 document.getElementById("rectc").disabled=true;
	 document.getElementById("reccc").disabled=true;
	 document.getElementById("recsc").disabled=true;
	 document.getElementById("recmm").disabled=true;
	 
	      
});
	    
function loadvalues(type,val){
	
	if(val == 0 || val =='')
		return;
	
	document.forms[0].action = "${pageContext.request.contextPath}/student/load.htm?param="+type;
    document.forms[0].method = "POST";
    document.forms[0].submit();
	
}

function upload(val){
	document.forms[0].action = "${pageContext.request.contextPath}/student/upload.htm?uploadtype="+val;
    document.forms[0].method = "POST";
    document.forms[0].submit();
}

function enable(obj,id){
	if(obj.checked){
	document.getElementById(id).disabled=false;
	}else{
		document.getElementById(id).disabled=true;	
	}
	
}

function opendatepick(val){
	
	document.getElementById("birthdate").value=val;
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
<form:form action="save.htm" modelAttribute="studentbean"  commandName="studentbean" method="POST" enctype="multipart/form-data">
<form:hidden path="student.hostelPaidfee"/>
<form:hidden path="student.collegePaidFee"/>
<div style="border-width:2px;border-color:#D3D3D3;border-style:solid; width:1200px;">
<div> <h4>${message} </h4></div>
<table>
<!--Academic Details Start-->

<tr><td colspan="10">
<h4 class="heading">Academic Details</h4><hr/> </td>
</tr>
<tr>
<td>Admission Number</td>
<td> <form:input path="student.admissionNo"/><form:errors path="student.admissionNo" cssClass="error"/> </td>
<td>Academic Year</td><td> <form:input path="student.academicyear"/>
</td><td>DOJ </td><td><form:input path="student.joinedDate" id="joinedDate"/><form:errors path="student.joinedDate" cssClass="error"/></td>
</tr>
<tr><td>Course </td><td> <form:select path="student.stclass"  onchange="loadvalues('years',this.value);">
<form:option value="0">---Please Select---</form:option>
<form:options items="${studentbean.classes}" itemLabel="classDesc" itemValue="classValue"/>
</form:select>
</td>
<td>Studying Year</td> <td><form:select path="student.studyingyear" id="studyyear" onchange="loadvalues('sections',this.value);">
<form:option value="0" label="--Select--"></form:option>
<form:options items="${studentbean.studyingYears}" itemLabel="intvalue" itemValue="intvalue"/>
</form:select> </td>
<td>Section </td><td> <form:select path="student.section" id="section" >
<form:option value="">---Please Select---</form:option>
<form:options items="${studentbean.sections}" itemLabel="sectionname" itemValue="sectionname"/>
</form:select>
</td>

<td>Medium </td><td> <form:select path="student.medium" id="medium" onchange="loadvalues('rollnum',this.value)">
<form:option value="">---Please Select---</form:option>
<form:options items="${studentbean.mediums}" itemLabel="mediumname" itemValue="mediumname"/>
</form:select>
</td>
<td>Roll NO </td><td> <form:input path="student.rollNo"/><form:errors path="student.rollNo" cssClass="error"/></td>
</tr>
<tr><td>College Fee</td> <td> <form:input path="student.collegeFee" readonly="true"/></td>
</tr>

<tr><td>Student Type</td> <td> <form:select path="student.studentType">
<form:option value="" label="--Select--"/>
<form:option value="Days Caller"/>
<form:option value="Hostler"/>
</form:select> </td>
</tr>
<!--Academic Details End-->
<div id="hostel">
<tr> <td colspan="10"><hr/>
<h4>Hostel information</h4></td> </tr>
<tr><td>Hostel Name</td><td><form:select path="student.hostelName">
<form:options items="${studentbean.hostels}" itemLabel="hostelName" itemValue="hostelName"/>
</form:select> </td>
<td>Admission Number</td><td><form:input path="student.hostelAdmissionNo"/>
</div>
<!--Personal Details Start-->
<tr><td colspan="10"><hr/>
<h4>Personal Information</h4></td></tr>
<tr>


<td>First Name</td><td><form:input path="student.firstname"/><form:errors path="student.firstname" cssClass="error"/> </td>
<td>Last Name</td><td><form:input path="student.lastname"/><form:errors path="student.lastname" cssClass="error"/> </td>
<td>Gender</td><td><form:radiobutton path="student.gender" value="M"/>M<form:radiobutton path="student.gender" value="F"/> F</td>
 <td></td><td></td><td rowspan="3"> <div style="height:130px; width:100px; border-style:solid;  ">
 <c:choose>
 <c:when test="${studentbean.student.photoname == null}">
 <input type="button" value="Photo" onclick="upload('photo')">
 </c:when>
 <c:otherwise>
 <img src="${studentbean.photopath}" height="130px;" width="100px;"/>
 </c:otherwise>
 </c:choose>
</div> </td>
</tr>

<tr>
<td> Date Of Birth</td><td><form:input path="dob" id="birthdate" readonly="true" onclick="opendatepick(this.value)"/><form:errors path="student.birthDate" cssClass="error"/></td>
<td>Religion</td><td><form:select path="student.religion">
<form:option value="0">---Please Select---</form:option>
<form:option value="Hindu">Hindu</form:option>
<form:option value="Hindu">Muslim</form:option>
<form:option value="Hindu">Christian</form:option>
</form:select><form:errors path="student.religion" cssClass="error"/></td>
<td>Caste</td><td><form:select path="student.caste">
<form:option value="-3">---Please Select---</form:option>
<form:option value="OC">OC</form:option>
<form:option value="BC">BC</form:option>
<form:option value="SC">SC</form:option>
</form:select><form:errors path="student.caste" cssClass="error"/></td>
<td>Sub Caste</td><td><form:input path="student.castename"/><form:errors path="student.castename" cssClass="error"/></td>
</tr>

<!--Personal Details End-->
<!--Parent Details Start-->
<tr><td colspan="8"><hr/>
<h4>Parent Information</h4></td></tr>
<tr>
<td>Parent Type </td><td><form:select path="student.parentType">
<form:option value="0">---Please Select---</form:option>
<form:option value="Father">Father</form:option>
<form:option value="Mother">Mother</form:option>
<form:option value="Guardian">Guardian</form:option>
</form:select></td>
<td>Parent Name</td><td> <form:input path="student.parentName"/><form:errors path="student.parentName" cssClass="error"/></td>
</tr>
<tr>
<td>Mobile</td><td> <form:input path="student.mobile"/><form:errors path="student.mobile" cssClass="error"/></td>
<td>Email</td><td> <form:input path="student.email"/></td>
<td>Occupation</td><td> <form:input path="student.occupation"/><form:errors path="student.occupation" cssClass="error"/></td>
</tr>

<!--Parent Details End-->
<!--Address Details Start-->
<tr><td colspan="10"><hr/>
<h4>Address Details</h4></td></tr>
<tr>
<td>Present Address</td><td> <form:textarea path="student.presentAddress"/><form:errors path="student.presentAddress" cssClass="error"/></td>
<td>Permanent Address</td><td> <form:textarea path="student.premanentAddress"/><form:errors path="student.premanentAddress" cssClass="error"/><hr/></td>
</tr>

<!--Address Details End-->
<!--Previous School Details Start-->
<tr><td colspan="10"><hr/>
<h4>Previous Study Details</h4></td></tr>
<tr>
<td>Previous Organization</td><td><form:input path="student.prevschool"/><form:errors path="student.prevschool" cssClass="error"/> </td>
<td>Previous Study</td><td><form:input path="student.prevsStudClass"/> <form:errors path="student.prevsStudClass"/></td>
<td>Academic Year</td><td><form:input path="student.prevsStudyear"/> &nbsp; Format Should like <b>Previous Year - Current Year</b>
<form:errors path="student.prevsStudyear" cssClass="error"/> </td>
</tr>
<tr>
<td>Transfer Reason</td><td><form:input path="student.prevsReleaveReason"/><form:errors path="student.prevsReleaveReason" cssClass="error"/> </td>
<td>Conduct Issued</td><td><form:input path="student.prevconduct"/><form:errors path="student.prevconduct" cssClass="error"/> </td>
</tr>
<tr><td colspan="10"><hr/>
<h4>Documents Received</h4></td></tr>
<tr>
<td colspan="2"><form:checkbox path="student.recTc" onclick="enable(this,'rectc')"/>TC <input type="button" value="upload" id="rectc" onclick="upload('rectc')"> ${studentbean.student.rectcname}</td>
<td colspan="2"><form:checkbox path="student.recCC" onclick="enable(this,'reccc')"/>CC <input type="button" value="upload" id="reccc" onclick="upload('reccc')">${studentbean.student.recccname}</td>
<td colspan="2"><form:checkbox path="student.recSC" onclick="enable(this,'recsc')"/>SC <input type="button" value="upload" id="recsc" onclick="upload('recsc')">${studentbean.student.recscname}</td>
<td colspan="2"><form:checkbox path="student.recMarks" onclick="enable(this,'recmm')"/>Marks Sheet<input type="button" value="upload" id="recmm" onclick="upload('recmm')">${studentbean.student.recmmname}</td>
</tr>
<tr><td colspan="10"><hr/>
<h4>Documents Issued</h4></td></tr>
<tr> 
<td colspan="2">
<form:checkbox path="student.issTc" onclick="enable(this,'isstc')"/>TC <input type="button" value="upload" id="isstc" onclick="upload('isstc')"> 
${studentbean.student.tcname}</td>
<td colspan="2"><form:checkbox path="student.issCC" onclick="enable(this,'isscc')"/>CC<input type="button" value="upload" id="isscc" onclick="upload('isscc')">
${studentbean.student.ccname}</td>
</td>
<td colspan="2"><form:checkbox path="student.issSC" onclick="enable(this,'isssc')"/>SC<input type="button" value="upload" id="isssc" onclick="upload('isssc')"> ${studentbean.student.scname}</td>
<td colspan="2"><form:checkbox path="student.issMarks" onclick="enable(this,'issmm')"/>Marks Sheet<input type="button" value="upload" id="issmm" onclick="upload('issmm')">${studentbean.student.mmname}</td>

</tr>
<tr><td colspan="10"><hr/>
<h3>Re-leave Details</h3></td></tr>
<tr>
<td>Re-leave Reason</td><td><form:input path="student.leaveReason"/></td>
<td>Re-leave Date</td><td><form:input path="student.collegeLeaveDate" id="collegeLeaveDate"/></td>
<td>Conduct</td><td><form:input path="student.issuedconduct"/></td>
</tr>
<tr>
<td></td><td></td>
<td>Status</td><td>
<form:select path="student.status">
<form:option value="Active">Active</form:option>
<form:option value="Left">Left</form:option>
<form:option value="Absconded">Absconded</form:option>
<form:option value="Stopped">Stopped</form:option>
</form:select>
</td>
</tr>
</table>
</div>
<div align="center"> <input type="submit" value="Save"/></div>
</form:form>

</body>
</html>