<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<form action="isValidUser" method="post">
		<table>
			<tr>
				<td><br> <label for="userName">User Name &nbsp; :
						&nbsp; &nbsp;</label></td>
				<td><br> <input type="text" id="userName" name="userName"
					placeholder="Enter User Name" required></td>
			</tr>
			<tr>
				<td><br> <label for="password">Password &nbsp;
						&nbsp; &nbsp; : &nbsp; &nbsp;</label></td>
				<td><br> <input type="password" id="password"
					name="password" placeholder="Enter Password" required></td>
			</tr>
			<tr>
				<td></td>
				<td><br> <input type="submit" value="Login">
					&nbsp; &nbsp; <a
					href="http://localhost:8081/WebApplication/UserRegistrationForm.jsp">
						<input type="button" value="Sign Up">
				</a>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>