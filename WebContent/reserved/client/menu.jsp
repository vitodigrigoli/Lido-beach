<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ page import="net.vdg.bean.UserBean" %>
	
	<% 
	UserBean user = (UserBean) session.getAttribute("user");
	
	if( user == null ){ %>	
		<jsp:forward page="/view/login.jsp"></jsp:forward>
	<% }
	String role = user.getRole();

	if( !role.equals( "C" ) ){ %>		
		<jsp:forward page="/error_page/unauthorized_access.jsp"></jsp:forward>
	<% }
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/reserved/client/css/menu.css">
    <link rel="stylesheet" href="/view/css/general.css">
    <script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
    <title>Menu</title>
</head>
<body>

<%@ include file="/navbar/clientNavbar.jsp" %>

	<h1>Menu</h1>
	
	<div class="container">

	<div class="cards">

		<div class="cards__card" id="1">
			<h3>Pizza</h3>
			<i class="fas fa-pizza-slice"></i>
		</div>
		
		<div class="cards__card" id="2">
			<h3>Hamburger</h3>
			<i class="fas fa-hamburger"></i>
		</div>
		
		<div class="cards__card" id="3">
			<h3>Fish</h3>
			<i class="fas fa-fish"></i>
		</div>
		
		<div class="cards__card" id="4">
			<h3>Desserts &amp; Shakes</h3>
			<i class="fas fa-ice-cream"></i>
		</div>
		
		<div class="cards__card" id="5">
			<h3>Fruit Salad</h3>
			<i class="fas fa-apple-alt"></i>
		</div>

		<div class="cards__card" id="6">
			<h3>Beverage</h3>
			<i class="fas fa-wine-bottle"></i>
		</div>
	</div>
	
	<div class="table" id="AjaxResponse"></div>
	<div id="Ajax2"></div>
	
	</div>
	
	<script src="/view/js/jquery-3.5.1.js"></script>
	<script src="js/menu.js"></script>

</body>
</html>