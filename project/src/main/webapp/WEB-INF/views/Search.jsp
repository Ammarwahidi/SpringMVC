<%@page import="com.te.project.common.dto.Employeebean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String msg=(String)request.getAttribute("errMsg"); 
    Employeebean bean=(Employeebean)request.getAttribute("data");
    %>
    <%@ include file="nav.jsp" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="./search1" method="GET">
Search By Name: <input type="text" name="id" placeholder="EmployeeId">
    <input type ="submit" value="Search"></form>
    <%if(bean!=null){ %>
    <h4>Name:<%=bean.getName() %></h4>
     <h4>Id:<%=bean.getId() %></h4>
      <h4>dob:<%=bean.getDob()%></h4>
      <%
      }
      %>


</body>
</html>