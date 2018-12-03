<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page errorPage="ErrorPage.jsp" %>
    <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<style>
.grid-container {
display: grid;
grid-template-columns: auto auto;
}
</style>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>">
</head>
<body style="background-color: #e3e3e3">

	  <%
      	if(session.getAttribute("verify") == null){
      		response.sendRedirect("../login");
      	}
      %>
        <%
        	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        
        	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        	
        	response.setHeader("Expires", "0"); //Proxies
        
        %>

	<div>
		<h4 align="right">Hi, ${verify.uname}</h4>
		<h4 align="right"><a href="../logout">Logout</a></h4>
	</div>
	<div class="grid-container">
	<div class="grid-item">
    <img src="<c:url value="../${command1.image}"/>" style="width:200px;height:200px;"><br></div>
	  <div class="grid-item">
	  <h4><b>Product Name:<br> ${command1.productName}
	   <br>
	  Product Details:<br> ${command1.productDetails}  
	   <br>
	  Cost:<br> ${command1.cost}/-</b></h4>  

  <br> <br>
	<b>Period:</b>
	<select onchange="val()" name="prd" id="prd" required>
		<c:forEach var="p1" items="${command}">   
			<option value=${p1.period}>
			 ${p1.period} months
			</option>
		</c:forEach>
	</select>
	<h1 id= "demo"></h1>
	<form action="../purchase">
		<input type="hidden" name="id" value=${verify.id}>
		<input type="hidden" name="productId" value=${command1.productId}>
		<input type="hidden" name="cost" value=${command1.cost}>
		<input type="hidden" name="period" id="period">
		<input type="submit" value="purchase">
	</form>
	</div>
	</div>
	
 <script>
var x = ${command1.cost};
var e = document.getElementById("prd");
function val() {
    y = document.getElementById("prd").value;
    document.getElementById("period").value = document.getElementById("prd").value;
    var z = parseInt(x / y);
    document.getElementById("demo").innerHTML = "EMI Starting at " + z;
}
</script> 
</body>
</html>