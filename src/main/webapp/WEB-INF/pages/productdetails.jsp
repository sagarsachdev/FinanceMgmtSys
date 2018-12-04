<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page errorPage="ErrorPage.jsp" %>
    <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/nav.css"/>">
<style>
	.grid-container {
	display: grid;
	grid-template-columns: auto auto;
	}
	#div2{
			margin-left: 200px;
			margin-right: 200px;	
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
	<center>
	<div id="div2" style = "height:100%;">
	<ul>	
		<li><a href="loginProcess">Hi, ${verify.uname}</a></li>
		<li style="float:right"><a href="../logout">Logout</a></li>
		<li style="float:right"><a href="changePassword">Change Password</a></li>
	</ul>
	</div></center>
	<div class="grid-container" style="margin-left: 200px; margin-right: 200px;">
	<div class="grid-item">
    <img src="<c:url value="../${command1.image}"/>" style="width:250px;height:250px;"><br></div>
	  <div class="grid-item">
	  <h4><b>Product Name:<br></b></h4> <h5>${command1.productName}</h5>
	  <h4><b>Product Details:<br></b></h4> <h5>${command1.productDetails}</h5>  
	  <h4><b>Cost:<br></b></h4> <h5>${command1.cost}/-</h5> 

  <br>
	<b>EMI Period:</b>
	<select onchange="val()" name="prd" id="prd" required>
		<option disabled selected value> -- select an option -- </option>
		<c:forEach var="p1" items="${command}">   
			<option value=${p1.period}>
			 ${p1.period} months
			</option>
		</c:forEach>
	</select><br>
	<h3 id= "demo"></h3>
	<form action="../purchase">
		<input type="hidden" name="id" value=${verify.id}>
		<input type="hidden" name="productId" value=${command1.productId}>
		<input type="hidden" name="cost" value=${command1.cost}>
		<input type="hidden" name="period" id="period">
		<input type="submit" value="Purchase" class="btn btn-success">
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