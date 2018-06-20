<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome to login page</h1>
<form action="loginCheck" method="post">
<pre>
User Name: <input type="text" name="userName"/>
Password : <input type="password" name="pwd"/>
<input type="submit" value="Insert">
</pre>
</form>
${msg}
</body>
</html>





