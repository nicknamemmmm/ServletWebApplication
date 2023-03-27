<%@page import="com.soft.beans.Product"%>
<%@page import="com.soft.dao.ProductDAO"%>
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

    background-color:#feb236;
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
background-color:#6b5b95;
color:white;
}
h1{
margin-left:40%;
color:blue
}

</style>
</head>
<body>
<%
int pid = Integer.parseInt(request.getParameter("pid"));
ProductDAO productDAO=new ProductDAO();
Product exitProduc = productDAO.findBypidP(pid);
%>

<h1>Edit Product</h1>
<div id="screen">
<form action="updateProduct" method="post">
<div id="body">
<label>ProductId</label><br>
<input type="number" name="pid" readonly value="<%=exitProduc.getPid() %>"><br>
</div>

<div id="second">
<label>Product Name</label><br>
<input type="text" name="pname"value="<%=exitProduc.getpName()%>"><br>
</div>

<div id="third">
<label>Product Quantity</label><br>
<input type="number" name="pqnumber"value="<%=exitProduc.getpQty() %>"><br>
</div>

<div id="fourth">
<label>Price</label><br>
<input type="number" name="pprice"value="<%=exitProduc.getPrice() %>"><br>
</div>

<div id="six">
<input type="submit" value="Update"/><br>
</div>
</form>
</div>
</body>
</html>