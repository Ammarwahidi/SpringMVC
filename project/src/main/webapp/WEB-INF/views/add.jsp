<%@page import="com.te.project.common.dto.Employeebean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("errMsg");
Employeebean bean = (Employeebean) request.getAttribute("data");
%>
<%@ include file="nav.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Add new Employee</h1>
	<form action="./addEmployee" method="Post">
		<table>

			<tr>
				<td>Employee id</td>
				<td><input type="text" name="Employee_id" /></td>
			</tr>
			<tr>
				<td>Employee name</td>
				<td><input type="text" name="Employee_name" /></td>
			</tr>
			<tr>
				<td>Date of birth</td>
				<td><input type="text" name="DOB" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>