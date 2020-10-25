<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="net.vdg.bean.CartBean" %>
<%@ page import="net.vdg.bean.UserBean" %>
	
	<% 
	UserBean user = (UserBean) session.getAttribute("user");
	
	if( user == null ){ %>	
		<jsp:forward page="/view/login.jsp"></jsp:forward>
	<% }
	String role = user.getRole();

	if( !role.equals( "C" ) ){ %>		
		<jsp:forward page="/view/unauthorized_access.jsp"></jsp:forward>
	<% }
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/reserved/client/css/cart.css">
    <link rel="stylesheet" href="/view/css/general.css">
    <script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
    <title>Cart</title>
<body>

<%@ include file="/navbar/clientNavbar.jsp" %>
	
	<div class="container">

<h1>Cart</h1>

	<% 
		CartBean cart = ( CartBean ) session.getAttribute( "cart" );
		if( cart == null || cart.getList().size() == 0 ){ %>	
			<p>The cart is empty</p> <% 
		}
		else{ %>
		
		
		<div class="table" id="AjaxShowCart"></div>
		
		<div class="form">
			<h3>Enter your payment details</h3>
			<form>
				<label for="payment">Method of payment</label>
			  	<i class="fab fa-cc-visa"></i><input type="radio" id="visa" name="payment" value="visa" required>
			  	<i class="fab fa-cc-mastercard"></i><input type="radio" id="mastercard" name="payment" value="mastercard" required>
				<i class="fab fa-cc-amex"></i><input type="radio" id="americanExpress" name="payment" value="americanExpress" required>
			
				<label for="cardnumber">Credit card number</label>
				<input type="tel" pattern="[0-9]{16}" maxlength="16" required>
				
				<label for="expiryDate">Expiration date</label>
				<input type="month" required>
				
				<label for="ccv">CCV</label>
				<input type="tel" pattern="[0-9]{3}" maxlength="3" required>
				
				<label for="note">Note</label>
				<textarea id="note" name="note" rows="4" cols="50"></textarea>
				
				<input type="submit" class="button" value="pay order">
			</form>
		</div>
		
	<% } %>
	
	</div>
	
	<script src="/view/js/jquery-3.5.1.js"></script>
	<script src="js/cart.js"></script>	
</body>
</html>