<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="ErrorPage.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>Registration</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/class.css"/>">
<style type="text/css">

	#verified {
	display: none;
}
</style>
<link rel="stylesheet"
	href="<c:url value= "https://use.fontawesome.com/releases/v5.5.0/css/all.css"/>"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
</head>

<body>
  <div class="container">
    <form action="registerProcess" method="post">
      <div class="row">
        <h4>User details</h4>
        <div class="input-group input-group-icon"> 
          <input type="text" name="name" placeholder="Full Name" pattern="^[a-zA-Z]+$" maxlength="20" required />
          <div class="input-icon">
            <i class="fas fa-users"></i>
          </div>
        </div>
        <div class="input-group input-group-icon">
          <input type="tel" name="phone" placeholder="Phone Number"
            pattern="[789][0-9]{9}" name="phone" minlength="10" maxlength="10"
            required />
          <div class="input-icon">
            <i class="fas fa-phone"></i>
          </div>
        </div>
        <div class="input-group input-group-icon">
          <input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" placeholder="Email Address" required />
          <div class="input-icon">
            <i class="fa fa-envelope"></i>
          </div>
        </div>
        <div class="input-group input-group-icon">
          <input type="textarea" name="address" placeholder="Address" pattern="^[a-zA-Z0-9]+$" maxlength="30" required />
          <div class="input-icon">
            <i class="fas fa-address-card"></i>
          </div>
        </div>
        <h4>User Credentials</h4>
        <div class="input-group input-group-icon">
          <input type="text" name="uname" placeholder="Username" pattern="^[a-zA-Z0-9]+$" maxlength="10" required />
          <div class="input-icon">
            <i class="fas fa-user"></i>
          </div>
        </div>
        <div class="input-group input-group-icon">
          <input type="password" name="password"
            pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
            title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
            placeholder="Password" required />
          <div class="input-icon">
            <i class="fa fa-key"></i>
          </div>
        </div>
      </div>

      <div class="row">
        <h4>Card Type</h4>
        <div class="input-group">
          <input type="radio" id="payment-method-card" name="card" value="gold" checked="true" /> 
          <label for="payment-method-card">Gold</label> 
            <input type="radio" id="payment-method-paypal" name="card" value="titanium" /> 
            <label for="payment-method-paypal">Titanium</label>
        </div>
      

        <h4>Bank Details</h4>
        <div class="input-group">
          <h4 style="color: gray">
            <i class="fas fa-university"></i> Bank Name
          </h4>
          </i> <select name="bank" required>
            <option>Bank A</option>
            <option>Bank B</option>
          </select>
        </div>
      </div>
        <div class="input-group input-group-icon">
          <input type="tel" placeholder="Savings Account number"
            name="accountNo" pattern="[0-9]{11,15}" required />
          <div class="input-icon">
            <i class="fas fa-piggy-bank"></i>
          </div>
        </div>
        <div class="input-group input-group-icon">
          <input type="text" placeholder="IFSC code" pattern="^[A-Za-z]{4}\d{7}$" minlength="11"
            maxlength="11" name="ifsc" required />
          <div class="input-icon" >
            <i class="fas fa-qrcode"></i>
          </div>

          <div class="form-wrapper" id="verified">
            <label style="font-size: 15px; color: green">Verified</label> <input
              type="radio" class="form-control" name="verified" value="yes"
              required> <input type="radio" class="form-control"
              name="verified" value="no" required checked>
          </div>
              <div class="row">
                <button type="submit" value="register">Register</button>
              </div>

              <h4>
                Already have an account? <a href="login">Click here</a> to login
              </h4>
    </form>
  </div>
</body>
</html>