<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bridz.insert_into_database.*"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<center>
		<h1>Welcome</h1>
	</center>
	<div align="right">
		<a
			href="http://localhost:8081/WebApplicationUserRegistration/LoginPage.jsp">
			<input type="button" value="Logout" />
		</a>
	</div>
	<center>
		<table border="1" width="600">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>User Name</th>
					<th>Password</th>
				</tr>
			</thead>
		</table>
		<%
			ResultSet resultSetObject = InsertDataBase.getResultSet();
			while (resultSetObject.next()) {

				String firstNameToShow = resultSetObject.getString(1);
				String lastNameToShow = resultSetObject.getString(2);
				String userNameToShow = resultSetObject.getString(3);
				String passwordToShow = resultSetObject.getString(4);
		%>

		<table border="1" width="600">
			<tr>
				<td width="80">&nbsp<%=firstNameToShow%>&nbsp
				</td>
				<td width="80">&nbsp<%=lastNameToShow%>&nbsp
				</td>
				<td width="80">&nbsp<%=userNameToShow%>&nbsp
				</td>
				<td width="80">&nbsp<%=passwordToShow%>&nbsp
				</td>
			</tr>
		</table>

		<%
			}
		%>
	</center>
</body>
</html>