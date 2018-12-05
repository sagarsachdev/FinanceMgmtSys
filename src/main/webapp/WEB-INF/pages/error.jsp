<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isErrorPage="true" %>

<html>
   <head>
   <meta http-equiv="Refresh" content="5;url=dashboard">
   		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
      <title>Show Error Page</title>
      <style type="text/css">
      th{
         color:#801525;
         padding: 10px;
         background-color: #44C5FC;
      }
      td{
         padding: 10px;
         color:black;
      }
</style>
   </head>
   
   <body>

      <h1 style="color: red;"><i class="fas fa-frown"></i> Ooooopps...</h1>
      <h3>An Error Occured</h3>
      		<h2>${message}</h2>
      		
      		<%-- <table width = "100%" border = "1" cellpadding="4">
      			<tr>
      				<th>Error : </th>
      				<td>${message}</td>
      			</tr>
      			<tr>
      				<th>Stack Trace : </th>
      				<td>
      					<c:forEach var = "trace" 
		                  items = "${message.getStackTrace()}">
		                  <p>${trace}</p>
            			</c:forEach>
            		</td>
      			</tr>
      		</table> --%>
  			
   </body>
</html>