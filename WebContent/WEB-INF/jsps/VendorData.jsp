<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table tr th {
	color: white;
	background-color: black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<table border="1">
<tr>
	<th>Id</th><th>Name</th><th>Email</th><th>Location</th><th>Type</th>
</tr>
<c:forEach items="${venListObj}" var="ven">
<tr>
<td><c:out value="${ven.venId}"/></td>
<td><c:out value="${ven.venName}"/></td>
<td><c:out value="${ven.venMail}"/></td>
<td><c:out value="${ven.loc.locName}"/></td>
<td><c:out value="${ven.loc.locType}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>





