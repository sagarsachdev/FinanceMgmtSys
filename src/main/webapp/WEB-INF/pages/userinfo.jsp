<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page errorPage="ErrorPage.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
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
<meta charset="ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
	<div align="center">
	<br>	<h1 style="font-size:40px;">User List</h1><br>
	<c:if test="${requestScope.usrList !=null and
 	not empty requestScope.usrList}">
	<table border="2" width="200px" cellpadding="5">  
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Phone</th>
	<th>Email</th>
	<th>Address</th>
	<th>Uname</th>
	<th>Card</th>
	<th>Account No</th>
	<th>Bank</th>
	<th>Ifsc</th>
	<th>Verified</th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>  
   <c:forEach var="usr" items="${usrList}">   
   <tr>  
   <td>${usr.id}</td>  
   <td>${usr.name}</td>  
   <td>${usr.phone}</td>  
   <td>${usr.email}</td> 
   <td>${usr.address}</td>  
   <td>${usr.uname}</td>  
   <td>${usr.card}</td>  
   <td>${usr.accountNo}</td>  
   <td>${usr.bank}</td>  
   <td>${usr.ifsc}</td>  
   <td>${usr.verified}</td> 
   <td><a href="editusr/${usr.id}">Edit</a></td>  
   <td><a href="deleteusr/${usr.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   </c:if>
   </div>
</body>
</html>