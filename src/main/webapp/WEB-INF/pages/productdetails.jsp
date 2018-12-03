<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page errorPage="ErrorPage.jsp" %>
    <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>

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

	<h1>Hi, ${verify.uname}</h1>
	<div>
		<a href="../logout">Logout</a>
	</div>

    <img src="https://via.placeholder.com/150"><br>
  <b>Product Name:</b> ${command1.productName}  
   <br>
  <b>Product Details:</b> ${command1.productDetails}  
   <br>
  <b>Cost:</b> ${command1.cost}  

  <br> <br>
Period:
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