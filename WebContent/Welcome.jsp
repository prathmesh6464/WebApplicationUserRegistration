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
		<%
			ResultSet resultSetObject = InsertDataBase.getResultSet();
			while (resultSetObject.next()) {

				String firstNameToShow = resultSetObject.getString(1);
				String lastNameToShow = resultSetObject.getString(2);
				String userNameToShow = resultSetObject.getString(3);
				String passwordToShow = resultSetObject.getString(4);
		%>

		<table>
			<thead>
				<tr>
					<td><%=firstNameToShow%>&nbsp</td>
					<td><%=lastNameToShow%>&nbsp</td>
					<td><%=userNameToShow%>&nbsp</td>
					<td><%=passwordToShow%>&nbsp</td>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>

		<%
			}
		%>
	</center>
</body>
</html>