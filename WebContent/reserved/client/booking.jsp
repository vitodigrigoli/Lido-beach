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
    <link rel="stylesheet" href="/reserved/client/css/booking.css">
    <link rel="stylesheet" href="/view/css/general.css">
    <script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
    <title>Booking</title>
</head>
<body>
	
	<%@ include file="/navbar/clientNavbar.jsp" %>
	
	<div class="container">
		<h1>Book your Umbrella</h1>
		<h2>Welcome <%= user.getFirstName() %></h2>
		
		<div class="form">
			<h3>View available umbrellas</h3>
			<form>
		 
				<label for="date">Select date</label>
				<input name="date" id="date" type="date">	 
				
				<input type="submit" class="button" value="Show">
			   </form>
			   
			   <div id="AjaxResponse"></div>
			   
		</div>
		

	</div>
	
	<script src="/view/js/jquery-3.5.1.js"></script>
	<script src="js/booking.js"></script>
</body>
</html>