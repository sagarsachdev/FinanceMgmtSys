<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page errorPage="ErrorPage.jsp" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
<center>
<div align="center" style="width:500px;height:270px; margin-top: 200px; border: 2px solid blue; background-color:#D6F9B6">
<br>
	<h1 style="font-size:40px;text-shadow:0 0 3px #FF0000, 2px 2px 4px red;">User Activation</h1><br><br>
	<div align="center">
	<form:form method="POST" action="/FinanceMgmtSys/editsave">      
				<h2>Do you wish to Activate ${command.uname}'s account</h2><br>
				<h1><input type="radio" name="verified" value="yes" checked><span style="color:green">Yes</span>&nbsp&nbsp&nbsp&nbsp
					<input type="radio" name="verified" value="no"><span style="color:red">No</span></h1>
               <button type="submit" value="Edit Save" /> SAVE</button>  
       </form:form>
       </div> </div></center>
</body>
</html>