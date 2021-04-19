<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("errMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmpLogin</title>
</head>
<body>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<%=msg%>
	<%
	}
	%>

	<fieldset>
		<legend>Login</legend>
		<form action="./empLogin" method="post">
			<table>
				<tr>
					<td>EmployeeID</td>
					<td><input type="text" name="id" required="required" />
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required" /></td>
				</tr>
			</table>
			<input type="submit" value="Login" />
		</form>

	</fieldset>
</body>
</html>