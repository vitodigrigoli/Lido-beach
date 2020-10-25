<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="net.vdg.bean.CartBean, net.vdg.bean.UserBean" %>
    
    <%
    	session.removeAttribute( "cart" );
    	UserBean user = (UserBean) session.getAttribute( "user" );
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/reserved/client/css/payment.css">
    <link rel="stylesheet" href="/view/css/general.css">
    <title>Order Successful</title>
</head>
<body>
<p>The order was successful. We sent an email to <%= user.getEmail() %> with the receipt. Return to <a href="/reserved/client/booking.jsp">Home</a></p>
<img src="/media/payments.png">
</body>
</html>