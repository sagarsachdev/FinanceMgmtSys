<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page errorPage="ErrorPage.jsp" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/nav.css"/>">
<title>Product</title>
<style>
	.grid-container {
		display: grid;
		grid-template-columns: auto auto;
		margin-left: 200px;
		margin-right: 200px;
		}
		#div2{
			margin-left: 200px;
			margin-right: 200px;	
		}
</style>
<script type="text/javascript">
		history.pushState(null,null,location.href);
		window.onpopstate = function(){
			history.go(1);
		};
	</script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>">
</head>
<body style="background-color: #e3e3e3">

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
<center>
<div id="div2" style = "height:100%;">
	<ul>	
		<li><a href="loginProcess">Hi, ${verify.uname}</a></li>
		<li style="float:right"><a href="logout">Logout</a></li>
		<li style="float:right"><a href="changePassword">Change Password</a></li>
	</ul>
	</div></center>
	<div>
<h1 align="center">Product List</h1> 
<br>
 	<div class="grid-container">
   <c:forEach var="Product" items="${list}">   
   <div class="grid-item">
    <img src="<c:url value="${Product.image}"/>"style="width:200px;height:200px;"><br>
    </div>
    <div class="grid-item">
  	<br>	<b>Product Name:</b> ${Product.productName}  
   <br>
  		<b>Product Details:</b> ${Product.productDetails}  
   <br>
  		<b>Cost:</b> ${Product.cost}  
       <br><br><form action="searchpro/${Product.productId}"><input class="btn btn-success" type="Submit" value="Buy Now"><br><br><br></form>
       </div>
   </c:forEach>  
   </div>
</body>
</html>