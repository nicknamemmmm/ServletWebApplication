<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file ="Header.jsp" %>
<a>User Data</a>

<%

String name = request.getParameter("fname");
String email=request.getParameter("email");
int number =Integer.parseInt(request.getParameter("number")); 
out.print(name);
out.print(email);
out.print(number);
String str="abdcs";
out.print(m1());
//out.print(str);
%>

<%= str= "jjjj" %>
<%! int a= 90; %>
<%!
public int m1(){
return a;	
}

%>
 <%@ include file="Footer.jsp" %>
</body>
</html>