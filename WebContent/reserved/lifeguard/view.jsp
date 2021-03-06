<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="net.vdg.bean.UserBean" %>

<% 
	UserBean user = (UserBean) session.getAttribute("user");
	
	if( user == null ){ %>	
		<jsp:forward page="/view/login.jsp"></jsp:forward>
	<% }
	String role = user.getRole();

	if( !role.equals( "LG" ) ){ %>		
		<jsp:forward page="/error_page/unauthorized_access.jsp"></jsp:forward>
	<% }
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/view/css/general.css">
	<link rel="stylesheet" href="/reserved/lifeguard/view.css">
	<title>View</title>
</head>
<body>

	<%@ include file="/navbar/simpleNavbar.jsp" %>
	
	<div class="container">
		<h1>view of umbrellas booked today</h1>		
		
		<div class="table" id="AjaxResponse"></div>
</div>

<script src="/view/js/jquery-3.5.1.js"></script>
<script src="view.js"></script>

</body>
</html>