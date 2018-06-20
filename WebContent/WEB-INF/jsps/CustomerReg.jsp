<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%@include file="Master.jsp" %>
<form action="insertCust" method="post">
<pre>
Name : <input type="text" name="custName"/>
Email : <input type="text" name="custEmail"/>
Address : <textarea name="custAddr"></textarea>
Type: <select name="custType">
        <option value="Seller">Seller</option>
        <option value="Consumer">Consumer</option>
	</select>
<input type="submit" value="Insert"/><input type="reset" value="Clear"/>	
</pre>
</form>
${msg}
</body>
</html>





