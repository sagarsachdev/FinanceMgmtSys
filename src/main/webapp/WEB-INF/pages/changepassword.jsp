<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ page errorPage="ErrorPage.jsp" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/util.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
<link rel="stylesheet" href="<c:url value= "https://use.fontawesome.com/releases/v5.5.0/css/all.css"/>" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="text/javascript">
	var check = function() {
		  if (document.getElementById("password").value ==
		    document.getElementById("confirm_password").value) {
		    document.getElementById("message").style.color = "green";
		    document.getElementById("message").innerHTML = "matching";
		  } else {
		    document.getElementById("message").style.color = "red";
		    document.getElementById("message").innerHTML = "not matching";
		  }
		}
	</script>
	</head>
<body>
		<%
      	if(session.getAttribute("verify") == null){
      		response.sendRedirect("login");
      	}
      	%>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
				<form action="changeProcess" class="login100-form validate-form flex-sb flex-w" method="POST">
					<span class="login100-form-title p-b-51">
						Change Password
					</span>

					<div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
						<input class="input100" type="password" id="password" name="password" placeholder="New Password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" onkeyup='check();'
			            title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters and no special characters" required>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
						<input class="input100" type="password" id="confirm_password" placeholder="Confirm New Password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" onkeyup='check();'
			            title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters and no special characters" required>
						<span class="focus-input100"></span>
					</div>
					<span id='message'></span>
					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn">
							Reset Password
						</button>
						<br><br>
					</div>
	</form>
	</div>
</div>
</div>
</body>
</html>