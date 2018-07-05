<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">


function getFee(val){
	$.ajax({
		      type: "POST",
		      url: "${pageContext.request.contextPath}/student/getfee.htm",
		      data: "stclass="+val,
		      success: function(response){
		    	  alert('response '+response);
		    	  $('#student.totalFee').value=response;
						
		       },
		        error: function(e){
		        alert('Error: ' + e);
		
		        }
		
		        }); 
}

$(document).ready(function () {
	$( "#joinedDate" ).datepicker({dateFormat: 'dd-mm-yy',
        changeMonth: true,//this option for allowing user to select month
        changeYear: true //this option for allowing user to select from year range
      });
	$( "#hostelLeftDate" ).datepicker({dateFormat: 'dd-mm-yy',
        changeMonth: true,//this option for allowing user to select month
        changeYear: true //this option for allowing user to select from year range
      });
	$( "#hostelJoinDate" ).datepicker({dateFormat: 'dd-mm-yy',
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
	
	if(val =='' || val == 0)
		return;
	document.forms[0].action = "${pageContext.request.contextPath}/student/load.htm?param="+val;
    document.forms[0].method = "POST";
    document.forms[0].submit();
	
}

function upload(val){
	document.forms[0].action = "${pageContext.request.contextPath}/student/upload.htm?action=edit&uploadtype="+val;
    document.forms[0].method = "POST";
    document.forms[0].submit();
}
function paybill(studentid,feetype){
	
	
	document.forms[0].action = "${pageContext.request.contextPath}/fee/payfee.htm?studentid="+studentid+"&feetypee="+feetype;
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
function gotosearch(){
	
	document.forms[0].action = "${pageContext.request.contextPath}/student/searchresults.htm";
    document.forms[0].method = "POST";
    document.forms[0].submit();
}

function downloadfile(documentid){
	document.forms[0].action = "${pageContext.request.contextPath}/student/download.htm?documentid="+documentid;
    document.forms[0].method = "POST";
    document.forms[0].submit();
}

</script>
<style type="text/css">
.error {
    	color: red;
    }

</style>
</head>
<body>
<form:form action="update.htm" modelAttribute="studentbean"  commandName="studentbean" method="POST" enctype="multipart/form-data">
<form:hidden path="student.studentSeq"/>
<table align="center">

<!--Academic Details Start-->
<tr><td align="center" colspan="2"><font color="red"><u>College Details</u></font> <td></tr><tr>
<td>Admission Number</td>
<td> <form:input path="student.admissionNo"  disabled="true"/><form:errors path="student.admissionNo" cssClass="error"/> </td>
<td>Academic Year</td><td> <form:input path="student.academicyear"  disabled="true"/>
</td><td>DOJ </td><td><form:input path="student.joinedDate" onclick="opendatepick()" readonly="true"/><form:errors path="student.joinedDate" cssClass="error"/></td>
</tr>
<tr><td>Course </td><td> <form:select path="student.stclass" onchange="loadvalues('years',this.value)">
<form:option value="">---Please Select---</form:option>
<form:options items="${studentbean.classes}" itemLabel="classDesc" itemValue="classValue"/>
</form:select>
</td>
<td>Studying Year</td> <td><form:select path="student.studyingyear" id="studyyear" onchange="loadvalues('sections',this.value);">
<form:option value="0" label="--Select--"></form:option>
<form:options items="${studentbean.studyingYears}" itemLabel="intvalue" itemValue="intvalue"/>
</form:select> </td>
<td>Section </td><td> <form:select path="student.section">
<form:option value="">---Please Select---</form:option>
<form:options items="${studentbean.sections}" itemLabel="sectionname" itemValue="sectionname"/>
</form:select>
</td>

<td>Medium </td><td> <form:select path="student.medium">
<form:option value="0">---Please Select---</form:option>
<form:options items="${studentbean.mediums}" itemLabel="mediumname" itemValue="mediumname"/>
</form:select>
</td>
<td>Roll NO </td><td> <form:input path="student.rollNo"/><form:errors path="student.rollNo" cssClass="error"/></td>
</tr>

<tr><td>Total Fee</td> <td> <form:input path="student.collegeFee" disabled="true"/></td>
<td>Paid Fee</td> <td> <form:input path="student.collegePaidFee" disabled="true"/></td>
<td>Due Fee </td> <td> <form:input path="student.collegeBlanceFee" disabled="true"/> </td>
<c:if test="${studentbean.student.collegeBlanceFee > 0}"><td><input type="button" value="Pay Fee" onclick="paybill('${studentbean.student.studentSeq}','collegefee')"/></td> </c:if>
</tr>

<tr>
<td>Student Type</td> <td> <form:select path="student.studentType">
<form:option value="" label="--Select--"/>
<form:option value="Days Caller"/>
<form:option value="Hostler"/>
</form:select> </td>
</tr>


<tr><td align="center" colspan="2"><font color="red"><u>Hostel Details</u> </font></td></tr>
<tr><td>Hostel Name</td><td><form:input path="student.hostelName"/> </td><td>Admission Number</td><td><form:input path="student.hostelAdmissionNo"/> </td>  <td>Joined Date</td><td><form:input path="student.hostelJoinDate" id="hostelJoinDate"/></td> </tr>
<tr><td>Total Fee</td> <td> <form:input path="student.hostelFee" disabled="true"/></td>
<td>Paid Fee</td> <td> <form:input path="student.hostelPaidfee" disabled="true"/></td>
<td>Due Fee </td> <td> <form:input path="student.hostelBalanceFee" disabled="true"/> </td>
<c:if test="${studentbean.student.hostelBalanceFee > 0}"><td><input type="button" value="Pay Bill" onclick="paybill('${studentbean.student.studentSeq}','hostelfee')"/></td> </c:if> </tr>
<tr><td>Left Date </td><td><form:input path="student.hostelLeftDate" id="hostelLeftDate" /> </td> </tr>

<!--Academic Details End-->
<!--Personal Details Start-->
<tr><td colspan="10"><hr/>
<h4>Personal Information</h4></td></tr>
<tr>

<td>First Name</td><td><form:input path="student.firstname" disabled="true"/><form:errors path="student.firstname" cssClass="error"/> </td>
<td>Last Name</td><td><form:input path="student.lastname" disabled="true"/><form:errors path="student.lastname" cssClass="error"/> </td>
<td>Gender</td><td><form:radiobutton path="student.gender" value="M" disabled="true"/>M<form:radiobutton path="student.gender" value="F" disabled="true"/> F</td>
 <td></td><td></td><td rowspan="3"> <div style="height:130px; width:100px; ">
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
<td> Date Of Birth</td><td><form:input path="student.birthDate" disabled="true"/><form:errors path="student.birthDate" cssClass="error"/></td>
<td>Religion</td><td><form:input path="student.religion" disabled="true"/>
<form:errors path="student.religion" cssClass="error"/></td>
<td>Caste</td><td><form:input path="student.caste" disabled="true"/><form:errors path="student.caste" cssClass="error"/></td>
<td>Sub Caste</td><td><form:input path="student.castename" disabled="true"/><form:errors path="student.castename" cssClass="error"/></td>
</tr>

<!--Personal Details End-->
<!--Parent Details Start-->
<tr><td colspan="8"><hr/>
<h4>Parent Information</h4></td></tr>
<tr>
<td>Parent Type </td><td><form:select path="student.parentType" disabled="true">
<form:option value="0">---Please Select---</form:option>
<form:option value="Father">Father</form:option>
<form:option value="Mother">Mother</form:option>
<form:option value="Guardian">Guardian</form:option>
</form:select></td>
<td>Parent Name</td><td> <form:input path="student.parentName" disabled="true"/><form:errors path="student.parentName" cssClass="error"/></td>
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
<td>School Name</td><td><form:input path="student.prevschool"/><form:errors path="student.prevschool" cssClass="error"/> </td>
<td>Class</td><td> <form:select path="student.prevsStudClass">
<form:option value="0">---Please Select---</form:option>
<form:option value="-2">Nursery</form:option>
</form:select><form:errors path="student.prevsStudClass"/></td>
<td>Academic Year</td><td><form:select path="student.prevsStudyear">
<form:option value="0">---Please Select---</form:option>
<form:option value="2015-2016"></form:option>
<form:option value="2016-2017"></form:option>
</form:select><form:errors path="student.prevsStudyear" cssClass="error"/> </td>
</tr>
<tr>
<td>Transfer Reason</td><td><form:input path="student.prevsReleaveReason"/><form:errors path="student.prevsReleaveReason" cssClass="error"/> </td>
<td>Conduct Issued</td><td><form:input path="student.prevconduct"/><form:errors path="student.prevconduct" cssClass="error"/> </td>
</tr>
<tr><td colspan="10"><hr/>
<h4>Documents Received</h4></td></tr>
<tr>
<tr>
<c:choose>
<c:when test="${studentbean.student.rectcname == null}">
<td colspan="2"><form:checkbox path="student.recTc" onclick="enable(this,'rectc')"/>TC <input type="button" value="upload" id="rectc" onclick="upload('rectc')"></td>
</c:when>
<c:otherwise>
<td colspan="2"><form:checkbox path="student.recTc" onclick="enable(this,'rectc')" disabled="true"/>TC <input type="button" value="upload" id="rectc" onclick="upload('rectc')"> <a href="downloadfile(${studentbean.student.tcid})"> ${studentbean.student.rectcname}</a></td>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${studentbean.student.recccname == null}">
<td colspan="2"><form:checkbox path="student.recCC" onclick="enable(this,'reccc')"/>CC <input type="button" value="upload" id="reccc" onclick="upload('reccc')"></td>
</c:when>
<c:otherwise>
<td colspan="2"><form:checkbox path="student.recCC" onclick="enable(this,'reccc')" disabled="true"/>CC <input type="button" value="upload" id="reccc" onclick="upload('reccc')"><a href="downloadfile(${studentbean.student.recccid})"> ${studentbean.student.recccname}</a></td>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${studentbean.student.recscname == null}">
<td colspan="2"><form:checkbox path="student.recSC" onclick="enable(this,'recsc')"/>SC <input type="button" value="upload" id="recsc" onclick="upload('recsc')">${studentbean.student.recscname}</td>
</c:when>
<c:otherwise>
<td colspan="2"><form:checkbox path="student.recSC" onclick="enable(this,'recsc')" disabled="true"/>SC <input type="button" value="upload" id="recsc" onclick="upload('recsc')"><a href="downloadfile(${studentbean.student.recscid})">${studentbean.student.recscname}</a></td>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${studentbean.student.recmmname == null}">
<td colspan="2"><form:checkbox path="student.recMarks" onclick="enable(this,'recmm')"/>Marks Sheet<input type="button" value="upload" id="recmm" onclick="upload('recmm')"></td>
</c:when>
<c:otherwise>
<td colspan="2"><form:checkbox path="student.recMarks" onclick="enable(this,'recmm')" disabled="true"/>Marks Sheet<input type="button" value="upload" id="recmm" onclick="upload('recmm')"><a href="downloadfile(${studentbean.student.recmmid})">${studentbean.student.recmmname}</a> </td>
</c:otherwise>
</c:choose>

</tr>
<tr><td colspan="10"><hr/>
<h4>Documents Issued</h4></td></tr>
<tr> 
<td colspan="2">
<c:choose>
<c:when test="${studentbean.student.tcname == null}">
<form:checkbox path="student.issTc" onclick="enable(this,'isstc')"/>TC <input type="button" value="upload" id="isstc" onclick="upload('isstc')">
</c:when>
<c:otherwise>
<form:checkbox path="student.issTc" onclick="enable(this,'isstc')" disabled="true"/>TC <input type="button" value="upload" id="isstc" onclick="upload('isstc')"> 
<a href="#" onclick="downloadfile(${studentbean.student.tcid})">${studentbean.student.tcname}</a>
</c:otherwise>
</c:choose>
</td>
<td colspan="2">
<c:choose>
<c:when test="${studentbean.student.ccname == null}">
<form:checkbox path="student.issCC" onclick="enable(this,'isscc')"/>CC<input type="button" value="upload" id="isscc" onclick="upload('isscc')">
</c:when>
<c:otherwise>
<form:checkbox path="student.issCC" onclick="enable(this,'isscc')" disabled="true"/>CC<input type="button" value="upload" id="isscc" onclick="upload('isscc')">
<a href="#" onclick="downloadfile(${studentbean.student.ccid})">${studentbean.student.ccname}</a>
</c:otherwise>
</c:choose>
</td>
<td>
<c:choose>
<c:when test="${studentbean.student.scname == null}">
<form:checkbox path="student.issSC" onclick="enable(this,'isssc')"/>SC<input type="button" value="upload" id="isssc" onclick="upload('isssc')">
</c:when>
<c:otherwise>
<form:checkbox path="student.issSC" onclick="enable(this,'isssc')" disabled="true"/>SC<input type="button" value="upload" id="isssc" onclick="upload('isssc')">
 <a href="#" onclick="downloadfile(${studentbean.student.scid})">${studentbean.student.scname}</a>
</c:otherwise>
</c:choose>
</td>
<td colspan="2">
<c:choose>
<c:when test="${studentbean.student.mmname == null}">
<form:checkbox path="student.issMarks" onclick="enable(this,'issmm')"/>Marks Sheet<input type="button" value="upload" id="issmm" onclick="upload('issmm')">
</c:when>
<c:otherwise>
<form:checkbox path="student.issMarks" onclick="enable(this,'issmm')" disabled="true"/>Marks Sheet<input type="button" value="upload" id="issmm" onclick="upload('issmm')">
 <a href="#" onclick="downloadfile(${studentbean.student.mmid})">${studentbean.student.mmname}
</c:otherwise>
</c:choose>
</td>



</tr>
<tr><td colspan="10"><hr/>
<h3>Re-leave Details</h3></td></tr>
<tr>
<td>Re-leave Reason</td><td><form:input path="student.leaveReason"/></td>
<td>Re-leave Date</td><td><form:input path="student.collegeLeaveDate"/></td>
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
<tr>
<td></td><td></td><td></td><td> <input type="submit" value="Save"/>&nbsp;&nbsp;&nbsp;<input type="button" value="Return" onclick="gotosearch()"/> </td>
</tr>
</table>


</form:form>

</body>
</html>