package com.bridz.user_login;
import com.bridz.insert_into_database.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//CLASS USER LOGIN EXTENDS HTTP SERVLET
public class UserLogin extends HttpServlet {

	// STATIC FINAL VARIABLE
	private static final long serialVersionUID = 2970376729289338191L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//TAKING USER NAME AND PASSWORD FROM HTTP SERVLET REQUEST
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter printWriterObject = response.getWriter();  
				
		//TEMPARORY VARIABLE FOR CHECKING USER LOG IN OR NOT
		int temproryCheck = 0;
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
				String userNameToCheck = resultSet.getString(4);
				String passwordToCheck = resultSet.getString(5);
				System.out.println(userNameToCheck);
				System.out.println(passwordToCheck);
				
				if(userName.equals(userNameToCheck) && password.equals(passwordToCheck)) {
					
					temproryCheck++;
					
					try {	
						HttpSession session =  request.getSession();
						session.setAttribute("userName", userName);						
						RequestDispatcher rquestDispatcher = request.getRequestDispatcher("Welcome.jsp");  
						rquestDispatcher.forward(request, response);
						
					} catch (Exception e) {						
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(temproryCheck == 0)	{
			
			printWriterObject.write("Entered user name and password not matched please try again!!!");
			response.sendRedirect("http://localhost:8081/WebApplicationUserRegistration/LoginPage.jsp");
		}
	}
}