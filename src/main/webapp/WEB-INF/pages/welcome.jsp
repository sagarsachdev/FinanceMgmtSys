<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ page errorPage="ErrorPage.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/nav.css"/>">
<style type="text/css">
	#div1 {
    	background-image: url("resources/images/card-background.jpg");
	}
	#div2{
		border: 2px solid black;
    	border-radius: 10px;
	}
      body{
			background-color: #e3e3e3;
		}
      th{
         color:#801525;
         padding: 10px;
      }
      td{
         color:black;
      }
</style>
<script type="text/javascript">
		history.pushState(null,null,location.href);
		window.onpopstate = function(){
			history.go(1);
		};
	</script>
</head>
<body>

	 <%
      	if(session.getAttribute("verify") == null){
      		response.sendRedirect("login");
      	}
      %>
        
	<div align="center">
	<div id="div2" style = "width:600px; height:100%; background-color: white">
	<h2>Dashboard</h2>
	<ul>	
		<li><a href="#">Hi, ${card.uname}</a></li>
		<li><a href="viewproduct1">Products</a></li>
		<li style="float:right"><a href="logout">Logout</a></li>
		<li style="float:right"><a href="changePassword">Change Password</a></li>
	</ul>
	<div>
		<h2>EMI Card</h2>
		<div id="div1" style="width: 300px; height: 210px; border: 1px solid black; color:white; border-radius:20px;">
			<center><h4>Name : ${card.uname}</h4>
			<h4>Card type : ${card.cardType}</h4>
			<h4>Card Number : ${card.cardNo}</h4>
			<h4>Validity : ${card.validity}</h4>
			<h4>Total Credit :  ${cardValue}</h4></center>
		</div>
		<div>
			<h4>Activated : ${verify.verified}</h4>
		</div>
		<div>
			<h4>
			Total Amount : ${cardValue}.0 &nbsp&nbsp&nbsp&nbsp&nbsp
			Remaining Amount : ${card.value}
			</h4>
		</div>
		
		<div>
	<c:if test="${requestScope.purchaseList !=null and
	 	not empty requestScope.purchaseList}">
	 	<h3>Purchase History</h3>
		<table border="2" cellpadding="5">  
		<tr>
		<th>Product Id</th>
		<th>Purchase Date</th>
		<th>No of Months</th>
		<th>Product Cost</th>
		</tr>  
	   <c:forEach var="purchase" items="${purchaseList}">   
	   <tr>  
	   <td>${purchase.productId}</td>  
	   <td>${purchase.buyingDate}</td>  
	   <td>${purchase.period} months</td> 
	   <td>${purchase.cost}</td>  
   </tr>  
   </c:forEach>  
   </table>  
   </c:if>
   </div>
	</div><br>
	</div>
	</div>
</body>
</html>