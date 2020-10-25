<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/view/css/login.css">
    <script src="https://kit.fontawesome.com/3352ada0d1.js" crossorigin="anonymous"></script>
    
<title>Login</title>
</head>
<body>
	<div class="container">
		<h1>Login</h1>
	
			<form action="/LoginServlet" method="post">
				<input type="text" name="email" id="email" placeholder="Email">
				<input type="password" name="password" id="password" placeholder="Password">
				<input type="submit" class="button" value="Login">
			</form>
				
			<div id="servletResponse">${errorMsg}</div>
	
	</div>

	<script src="/view/js/jquery-3.5.1.js"></script>
	<script src="/view/js/login.js"></script>

</body>
</html>