<%@page import="com.soft.beans.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.soft.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
  
  background-color: black;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 15px;
}
th{
color:blue;
}
td{
color:red;
}
h1{
margin-left:40%;
color:blue
}
button{
background-color:#feb236;
color:white;
padding:10px;
margin-left:10%;

}
</style>
</head>
<body>

<h1>Welcome To Dashbord</h1>



<div >

<a href="addProduct.jsp"><button style="margin-left:5px;">Add new product</button></a>

<table >
<thead>
<tr>
<th>ProductId</th>
<th>productName</th>
<th>productQty</th>
<th>ProductPrice</th>
<th>Action</th>
</tr>
</thead>
<tbody>

<%
ProductDAO productdao = new ProductDAO();
List<Product> productlist = productdao.findProducts();
%>

<%
for(Product prod:productlist){
%>	


<tr>
<td><%=prod.getPid()%></td>
<td><%=prod.getpName()%></td>
<td><%=prod.getpQty()%></td>
<td><%=prod.getPrice()%></td>
<td><a href="editProduct.jsp?pid=<%=prod.getPid()%>" onclick="return confirm('Are You Sure Want To Update')"><button>Edit</button></a>
<a href="deletepro?pid=<%=prod.getPid()%>" onclick="return confirm('Are You Sure Want To Delete')"><button>Delete</button></a>
</td>
</tr>

<% 	
}
%>


</tbody>
</table>
</div>
</body>
</html>