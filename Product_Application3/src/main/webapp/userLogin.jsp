<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
#sreen{
width: 500px;
    height: 440px;
    top: 50%;
    left: 50%;
    position: absolute;
    margin-top: -200px;
    margin-left: -250px;
    border:1px solid red;
    text-align: center;
        box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px, rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;

    background-color:yellow;
}
#fr{
margin-top: 90px;
font-size: 20px;
color:blue;
}
#fr>input{
padding:7px;
width:60%;
border-radius:8px;
}

#frr{
margin-top: 20px;
font-size: 20px;
color:blue;
}
#frr>input{
padding:7px;
width:60%;
border-radius:8px;
}

#frrr>input{
width:20%;
margin-top:10px;
padding:4px;
font-size:20px;
}
</style>
</head>
<body>

<h1 style=color:green;margin-left:40%;>Login page</h1>

<div id="sreen">
<form action="userLogin" method="get">
<div id="fr">
<label>UserEmail</label><br>
<input type="text" name="uemail"/><br>
</div>
<div id="frr">
<label>Password</label><br>
<input type="Password" name="upassword"/><br>
</div>

<div id="frrr">
<input type="submit" value="Login"/><br>
</div>
<a href="userRegister.jsp">Register First</a>
</form>
</div>
</body>
</html>