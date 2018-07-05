<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload</title>
<script type="text/javascript">
function Validate()
{
   var image =document.getElementById("image").value;
   if(image!=''){
        var checkimg = image.toLowerCase();
        if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)){
            alert("Please select a File with .jpg,.png,.jpeg,.pdf extensions");
            document.getElementById("image").focus();
            return false;
          }
       }
   return true;
}
</script>
</head>
<body>
<form:form action="uploadphoto.htm" method="POST" modelAttribute="studentbean" enctype="multipart/form-data" onsubmit="return Validate();">
<form:hidden path="uploadtype"/>
<table>
		<tr>
			
			<td> <input type="file" name="filedata" id="image"/></td>
		</tr>
		<tr>
			<td><br />
			</td>
			<td><input type="submit" value="Upload" /></td>
		</tr>
	</table>

</form:form>
</body>
</html>