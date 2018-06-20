<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function resetVendorForm(){
	document.getElementById("venIdErr").innerHTML="";
	document.getElementById("venNameErr").innerHTML="";
	document.getElementById("venEmailErr").innerHTML="";
	document.getElementById("locIdErr").innerHTML="";
}
function validateVendor(){
	var exp1=/^[1-9][0-9]*$/;
	var exp2=/^[A-Za-z]{4,20}$/;
	var exp3=/^[A-Za-z0-9\-\_]{4,20}\@[a-z]{4,12}\.[a-z\.]{2,8}$/;
	resetVendorForm();
	if(!(document.venform.venId.value.match(exp1))){
		document.getElementById("venIdErr").innerHTML=" Enter Valid id";
		return false;
	}
	if(!(document.venform.venName.value.match(exp2))){
		document.getElementById("venNameErr").innerHTML=" Enter Valid Name";
		return false;
	}
	if(!(document.venform.venMail.value.match(exp3))){
		document.getElementById("venEmailErr").innerHTML=" Enter valid Email";
		return false;
	}
	if(document.getElementById("locId").value==-1){
		document.getElementById("locIdErr").innerHTML=" Select any one option";
		return false;
	}
	return true;
}
</script>




</head>
<body>
<%@include file="Master.jsp" %>
<h1>welcome to Vendor Reg Page!!</h1>
<form  name="venform" action="insertVen" method="post" enctype="multipart/form-data" onsubmit="return validateVendor();">
<pre>
Id   : <input type="text" name="venId"/><span id="venIdErr"></span>
Name : <input type="text" name="venName"/><span id="venNameErr"></span>
Email: <input type="text" name="venMail"/><span id="venEmailErr"></span>
Loc  : <select name="loc.locId" id="locId">
		<option value="-1">--select--</option>
        <c:forEach items="${locListObj}" var="ob">
         <option value="${ob.locId}"><c:out value="${ob.locName}"/></option>
        </c:forEach>
	   </select> <span id="locIdErr"></span>
Document : <input type="file" name="sdocs"/>	   
<input type="submit" name="Insert"/><input type="reset" name="Clear"/>
</pre>
</form>
${msg}<br/>
<a href="viewAllven">View All Vendors</a>
</body>
</html>









