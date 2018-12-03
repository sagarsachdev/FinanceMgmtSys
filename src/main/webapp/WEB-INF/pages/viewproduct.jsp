<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page errorPage="ErrorPage.jsp" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>

	<%
      	if(session.getAttribute("verify") == null){
      		response.sendRedirect("login");
      	}
      %>
        <%
        	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        
        	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        	
        	response.setHeader("Expires", "0"); //Proxies
        
        %>

<div>
<div>
<h1>Hi, ${verify.uname}</h1>
</div>
<div>
<a href="logout">Logout</a>
</div>
</div>
<h1>Product List</h1> 
<br>
 
   <c:forEach var="Product" items="${list}">   
    <img src="https://via.placeholder.com/150"><br>
  		Product Name: ${Product.productName}  
   <br>
  		Product Details: ${Product.productDetails}  
   <br>
  		Cost: ${Product.cost}  
       <br><br><form action="searchpro/${Product.productId}"><input type="Submit" value="Buy Now"><br><br><br></form>
   </c:forEach>  
    


</body>
</html>