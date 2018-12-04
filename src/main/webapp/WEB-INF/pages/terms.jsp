<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="ErrorPage.jsp" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Terms and Conditions</title>
<style type="text/css">
	ul li {list-style-type: disc;}
	ol {
    list-style-type: none;
    border : 4px solid white;
    overflow: hidden;
    background-color: #333;
	}
	
	ol li {
	    float: left;
	}
	
	ol li a {
	    display: block;
	    color: white;
	    text-align: center;
	    padding: 14px 16px;
	    text-decoration: none;
	}
</style>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
		
			<div class="wrap-login100 p-t-90 p-b-90" style="width: 650px;">
			<ol>	
					<h3><li><a href="index.jsp">Home</a></li>
					<li style="float: right;"><a href="login">Login</a></li>
					<li style="float: right;"><a href="register">Register</a></li></h3>
			</ol><br>
			<div>
				<h1>Eligibility and Documents Required</h1><br>
				<ul>
					<h4><li> Regular source of income.  </li>
					 <li>Aadhar card and PAN card. </li>
					<li> One cancelled cheque.  </li>
					 <li>One passport size photograph. </li></h4>
				</ul>
			</div><br>
			<div>
			<h1>Terms and Conditions</h1><br>
			<ul>
				<li> Joining fee for Gold EMI Card: Rs. 400. </li>
				<li>Joining fee for Titanium EMI Card: Rs. 800 </li>
				<li> Annual fee of Rs. 117 (Rs.99+18% GST) will only be charged to the EMI cardholders who have not availed any loan using the EMI Card in the preceding year.</li>
				<li> Preceding year will be 12 months calculated from last years validity month.</li></ol>
			</ul>
			</div>
			</div>
		</div>
	</div>	
</body>
</html>