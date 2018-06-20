<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

</style>
 

</head>
<body>
<%@include file="Master.jsp" %>
<h1>Welcome to Register Page!!</h1>
<form name="locForm" action="insertLoc" method="post" onsubmit="return validateLoc();">
<pre>
<!-- Enter Id  : <input type="text" name="locId"/> <span id="locIdErr" class="error"></span> -->
Enter Name: <input type="text" name="locName"/><span id="locNameErr" class="error"></span>
Select Type: <input type="radio" name="locType" value="Urban" />Urban <input type="radio" name="locType" value="Rural"/>Rural<span id="locTypeErr" class="error"></span>
<input type="submit" value="Save"/> <input type="reset" value="Clear"/>
</pre>
</form>
${msg}<br/>
<a href="viewAllLocs">View All Location</a> 
</body>
</html>




