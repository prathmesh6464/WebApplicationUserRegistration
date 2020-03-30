package com.bridz.user_login;
import com.bridz.insert_into_database.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//CLASS USER LOGIN EXTENDS HTTP SERVLET
public class UserLogin extends HttpServlet {

	// STATIC FINAL VARIABLE
	private static final long serialVersionUID = 2970376729289338191L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);

		ResultSet resultSet = null;
		try {
			resultSet = InsertDataBase.getResultSet();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while(resultSet.next()) {
				String userNameToCheck = resultSet.getString(3);
				String passwordToCheck = resultSet.getString(4);
				System.out.println(userNameToCheck);
				System.out.println(passwordToCheck);
				
				if(userName.equals(userNameToCheck) && password.equals(passwordToCheck)) 
				{
					try {						
						response.sendRedirect("http://localhost:8081/WebApplicationUserRegistration/Welcome.jsp");
					} catch (Exception e) {						
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
