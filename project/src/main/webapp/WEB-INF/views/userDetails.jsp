<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String name=(String) request.getAttribute("username");
    int pwd=(int) request.getAttribute("password");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
<h1>
name=
<%=name%></h1>
<br>
<hr> 
<h1>
password=
<%=pwd %>
</h1>
</body>
</html>