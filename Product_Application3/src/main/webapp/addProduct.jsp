<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#screen{
width: 500px;
    height: 440px;
    top: 50%;
    left: 50%;
    position: absolute;
    margin-top: -200px;
    margin-left: -250px;
    
    text-align: center;
        box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px, rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;

    background-color:#b2ad7f;
}

#body{
margin-top: 70px;
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
margin-top:20px;
font-size: 20px;
color:red;

}
#six>input{
padding:7px;
width:20%;
border-radius:8px;
background-color:blue;
color:white;
}
h1{
margin-left:40%;
color:blue
}
</style>

</head>
<body>

<h1>Add New Product</h1>
<div id="screen">
<form action="addproduct" method="post">
<div id="body">
<label>ProductId</label><br>
<input type="number" name="pid"/><br>
</div>

<div id="second">
<label>Product Name</label><br>
<input type="text" name="pname"/><br>
</div>

<div id="third">
<label>Product Quantity</label><br>
<input type="number" name="pqnumber"/><br>
</div>

<div id="fourth">
<label>Price</label><br>
<input type="number" name="pprice"/><br>
</div>
<div id="six">
<input type="submit" value="Submit"/><br>
</div>
</form>
</div>
</body>
</html>