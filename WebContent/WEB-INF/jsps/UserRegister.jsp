<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome to User Register page</h1>
<form action="insertUser" method="post">
<pre>
Name   : <input type="text" name="userName"/>
Email  : <input type="text" name="emailId"/>
Mobile : <input type="text" name="mobile"/>
Address: <textarea name="address"></textarea>
<input type="submit" value="Register"/>
</pre>
</form>
${msg}
</body>
</html>


