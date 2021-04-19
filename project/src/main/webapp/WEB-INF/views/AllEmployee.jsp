<%@page import="com.te.project.common.dto.Employeebean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% List<Employeebean> bean = (List<Employeebean>) request.getAttribute("bean");
	   String errMsg = (String) request.getAttribute("errMsg");
    %> 
    <%@include file="nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
    <% if (errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg%></h2>
	<% } %>
	<% if(bean != null){ %>
		<table border="1" style='width: 80%'>
			<thead style="background-color: blue; color: white;">
			<tr style="height: 35px">
				<th> Id</th>
				<th>Name</th>
				<th>DOB</th>

				
			</tr>
			</thead>
			<tbody>
			<% for(Employeebean beans : bean){ %>
			<tr>
					<td><%= beans.getId()%></td>
					<td><%= beans.getName()%></td>
					<td><%= beans.getDob()%></td>
			</tr>
			<% } %>
			</tbody>
			</table>
	<% } %>

</body>


</body>
</html>