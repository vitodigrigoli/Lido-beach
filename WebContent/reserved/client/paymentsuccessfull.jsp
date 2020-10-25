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
    <link rel="stylesheet" href="/reserved/client/css/payment.css">
    <link rel="stylesheet" href="/view/css/general.css">
    <title>Payment Successful</title>
</head>
<body>
<p>The payment was successful. We sent an email to <%= user.getEmail() %> with the receipt. Return to <a href="/reserved/client/booking.jsp">Home</a></p>
<img src="/media/payments.png">
</body>
</html>