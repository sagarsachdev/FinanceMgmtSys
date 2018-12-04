<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ page errorPage="ErrorPage.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/util.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
<link rel="stylesheet" href="<c:url value= "https://use.fontawesome.com/releases/v5.5.0/css/all.css"/>" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" >
			<div class="wrap-login100 p-t-50 p-b-90">
				<form action="loginProcess" class="login100-form validate-form flex-sb flex-w" method="post">
					<span class="login100-form-title p-b-51">
						Login Form
					</span>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
						<input class="input100" type="text" name="uname" placeholder="Username"></input>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn">
							Login
						</button>
						<br><br>
					</div>
					
	<p style="font-size: 15px;margin-left:50px">New Here? <a href="register"> Click here</a> to signup</p>
	<p style="font-size: 15px;margin-left:50px"><a href="forgotPassword"> Forgot Password?</a></p>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

				</form>
			</div>
		</div>
		</div>

	

</body>
</html>