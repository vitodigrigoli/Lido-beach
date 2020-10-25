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
	<title>Edit</title>
</head>
<body>

<%@ include file="/navbar/adminNavbar.jsp" %>

<div class="container">
<h1>Edit page</h1>

<div class="form">
<form class="form__input" id="addUser">
	<h3>Add a new user</h3>
		<label for="firstName">First Name</label>
		<input type="text" name="firstName" id="firstName" required/>
		
		<label for="lastName">Last Name</label>
		<input type="text" name="lastName" id="lastName" required/>
		
		<label for="email">Email</label>
		<input type="email" name="email" id="email" required/>
		
		<label for="password">Password</label>
		<input type="password" name="password" id="password" required/>
		
		<label for="roleAdd">Role</label>
		<select name="roleAdd" id="roleAdd">
			<option value="A">Admin</option>
			<option value="LG">Lifeguarde</option>
			<option value="K">Kitchen</option>
			<option value="C">Customer</option>
		</select>
		
		<input class="button" type="submit" value="Register"/>
</form>

<div id="ajaxResponseAdd"></div>
</div>
	

<div class="form">
	<form class="form__input" id="removeUser">
	<h3>Remove user</h3>
	<label for="roleRemove">Filter by roles</label>
	<select name="roleRemove" id="roleRemove">
		<option value="A">Admin</option>
		<option value="LG">Lifeguarde</option>
		<option value="K">Kitchen</option>
		<option value="C">Customer</option>
	</select>
	
	<input class="button" type="submit" value="Show"/>
</form>
	

<div class="form__result" id="ajaxResponseRemove"></div>
<div class="form__result" id="ajaxResponseRemove2"></div>
</div>

</div>

<script src="/view/js/jquery-3.5.1.js"></script>
<script src="js/edit.js"></script>
</body>
</html>