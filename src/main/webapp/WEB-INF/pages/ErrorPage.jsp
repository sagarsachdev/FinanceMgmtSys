<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isErrorPage="true" %>

<html>
   <head>
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

      <h1>Ooooopps...</h1>
      <h3>An Error Occured</h3>
      
  <table width = "100%" border = "1" cellpadding="4">
         <tr valign = "top">
            <th width = "40%"><b>Error:</b></th>
            <td>${pageContext.exception}</td>
         </tr>
            
         <tr valign = "top">
            <th><b>URI:</b></th>
            <td>${pageContext.errorData.requestURI}</td>
         </tr>
            
         <tr valign = "top">
            <th><b>Status code:</b></th>
            <td>${pageContext.errorData.statusCode}</td>
         </tr>
            
         <tr valign = "top">
            <th><b>Stack trace:</b></th>
            <td>
               <c:forEach var = "trace" 
                  items = "${pageContext.exception.stackTrace}">
                  <p>${trace}</p>
               </c:forEach>
            </td>
         </tr>
      </table>



   </body>
</html>