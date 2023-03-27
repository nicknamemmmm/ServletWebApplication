<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%out.print("welcome to JSP programing");%>

<h1>welcome</h1>
<% 
String name =(String)request.getAttribute("name");
out.print(name);
%>

<jsp:forward page="DateAndTime.jsp"/>
</body>
</html>