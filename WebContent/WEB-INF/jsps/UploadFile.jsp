<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%@include file="Master.jsp"%>
<h1>welcome to Document page</h1>
<form action="fileUpload" method="post" enctype="multipart/form-data">
<pre>
Id       : <input type="text" name="fid"/>
Document : <input type="file" name="fdatas"/>
<input type="submit" value="Upload"/>
</pre>
</form>
<br/>
<table border="1">
<tr>
<td>Id</td><td>Name</td><td>Link</td>
</tr>
<c:forEach items="${listOb}" var="f">
<tr>
<td><c:out value="${f[0]}"/></td>
<td><c:out value="${f[1]}"/></td>
<td><a href='downloadFile?fid=<c:out value="${f[0]}"/>'>Download</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>




