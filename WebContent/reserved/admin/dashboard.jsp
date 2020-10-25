<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="net.vdg.bean.UserBean" %>

<% 
	UserBean user = (UserBean) session.getAttribute("user");
	
	if( user == null ){ %>	
		<jsp:forward page="/view/login.jsp"></jsp:forward>
	<% }
	
	String role = user.getRole();

	if( !role.equals( "A" ) ){ %>		
		<jsp:forward page="/error_page/unauthorized_access.jsp"></jsp:forward>
	<% }
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../admin/css/style.css">
    <link rel="stylesheet" href="/view/css/general.css">
    <script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
    <title>Dashboard</title>
</head>
<body>

<%@ include file="/navbar/adminNavbar.jsp" %>

<div class="container">

	<h1>Dashboard</h1>
	<h2>Welcome <%= user.getFirstName() %></h2>
	
	<div class="cards">
	
		<div class="cards__card">
			<h3><i class="fas fa-balance-scale-right"></i>Earning<br>today</h3>
			<div class="cards__card__response" id="AjaxEarningsToday"><p>€ 0.0</p></div>
		</div>
		
		<div class="cards__card">
			<h3><i class="fas fa-utensils"></i>Kitchen orders<br>today</h3>
			<div class="cards__card__response" id="AjaxKitchenOrdersToday"><p>0</p></div></div>
		<div class="cards__card">
		
			<h3><i class="fas fa-umbrella-beach"></i>Umbrella bookings<br>today</h3>
			<div class="cards__card__response" id="AjaxUmbrellaOrdersToday"><p>0</p></div>
		</div>			
			
	</div>

<div class="form flex">
	
		<div class="form__input">
			<h3>Earnings in the custom period</h3>
			<form id="earningCustom">
				<label for="dateFrom">From</label>
				<input name="dateFrom" id="dateFrom" type="date">
				
				<label for="dateTo">To</label>
				<input name="dateTo" id="dateTo" type="date">
				
				<input type="submit" class="button" value="Show">
			</form>
		</div>
		
		<div class="form__response" id="AjaxEarningsCustom"></div>
		</div>
	
		<div class="form">
			<div class="form__input">
				<h3>Orders in the custom period</h3>
			<form id="ordersCustom" action="paymentsuccessfull.jsp" method="post">
			 <label for="dateFromC">From</label>
			 <input name="dateFromC" id="dateFromC" type="date">
			 
			 <label for="dateToC">To</label>
			 <input name="dateToC" id="dateToC" type="date">
			 
			 <label for="filter">Filter</label>
			 <select name="type" id="type">
					<option value="K">Kitchen</option>
					<option value="U">Umbrellas</option>
			</select>
			 
			 <input type="submit" class="button" value="Show">
			</form>
			</div>
			
			<div class="form__order" id="AjaxOrdersCustom"></div>
		</div>
</div>

<script src="/view/js/jquery-3.5.1.js"></script>
<script src="js/dashboard.js"></script>
</body>
</html>