<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title >Insert title here</title>
<style type="text/css">
#screen{
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
}
#body{
margin-top: 20px;
font-size: 20px;
color:red;
}
#body>input{
padding:7px;
width:60%;
border-radius:8px;
}
#second{
font-size: 20px;
color:red;
}
#second>input{padding:7px;
width:60%;
border-radius:8px;
}
#third{font-size: 20px;
color:red;
}
#third>input{
padding:7px;
width:60%;
border-radius:8px;
}
#fourth{
font-size: 20px;
color:red;
}
#fourth>input{
padding:7px;
width:60%;
border-radius:8px;
}

#five{
font-size: 20px;
color:red;
}
#five>input{
padding:7px;
width:60%;
border-radius:8px;
}

#six{
font-size: 20px;
color:red;
}
#six>input{
padding:7px;
width:60%;
border-radius:8px;
}
</style>
</head>
<body>

<h1 style=color:green;margin-left:40%;>Register Here</h1>
<div id="screen">
<form action="registerh" method="post">
<div id="body">
<label>UserId</label><br>
<input type="number" name="uid"/><br>
</div>
<div id="second">
<label>UserName</label><br>
<input type="text" name="uname"/><br>
</div>
<div id="third">
<label>UserEmail</label><br>
<input type="text" name="uemail"/><br>
</div>

<div id="fourth">
<label>Password</label><br>
<input type="Password" name="upassword"/><br>
</div>

<div id="five">
<label>ContactNo</label><br>
<input type="number" name="ucantact"/><br>
</div>

<div id="six">
<label>Address</label><br>
<input type="text" name="uaddress"/><br>
</div>

<div style=margin-top:16px;padding:10px; >
<input type="submit" value="Register"/>
</div>
</form>
</div>

</body>
</html>