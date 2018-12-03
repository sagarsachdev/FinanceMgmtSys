<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ page errorPage="ErrorPage.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<style type="text/css">
      
      th{
         color:#801525;
         padding: 10px;
         background-color: #44C5FC;
      }
      td{
         background-color: #44FAFC ;
         color:black;
      }
</style>
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


	<h4><a href="viewproduct1">Products</a></h4>
	<div>
		<a href="logout">Logout</a>
	</div>
	<div>
		<div style="width: 300px; height: 210px; border: 1px solid black; border-radius:20px; background-color: green;">
			<center><h4>Name : ${card.uname}</h4>
			<h4>Card type : ${card.cardType}</h4>
			<h4>Card Number : ${card.cardNo}</h4>
			<h4>Validity : ${card.validity}</h4>
			<h4>Total Credit :  ${card.value}</h4></center>
		</div>
		<div>
			<h4>Activated : ${verify.verified}</h4>
		</div>
		
		<div>
		<c:if test="${requestScope.purchaseList !=null and
	 	not empty requestScope.purchaseList}">
	 	<h3>Purchase History</h3>
		<table border="2" width="200px" cellpadding="5">  
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
	   <td>${purchase.period}</td> 
	   <td>${purchase.cost}</td>  
   </tr>  
   </c:forEach>  
   </table>  
   </c:if>
   </div>
	</div>
</body>
</html>