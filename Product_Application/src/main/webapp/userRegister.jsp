<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#screen{
width:100%;
heigth:50px;
border:1px solid black;
margin_left:40%;
}
</style>
</head>
<body>

<form action="test" method="post">
<h1>User Registration</h1>
<div id="screen">

<label>Full Name</label><br>
<input type="text" name="fname" /><br>

<label>Email</label><br>
<input type="text" name="email"/><br>

<label>Password</label><br>
<input type="password" name="password"/><br>

<label>Contact Number</label><br>
<input type="number" name="fnumber"/><br>

<label>Address</label><br>
<input type="text" name="address/"><br>

<input type="submit" value="Register"/>
</div>
</form>
<a href="userLogin.jsp">Alredy Accound Login Here</a>

</body>
</html>