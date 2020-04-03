package com.bridz.user_login;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();	 	
		session.removeAttribute("userName");
		session.invalidate();
		response.sendRedirect("http://localhost:8081/WebApplicationUserRegistration/LoginPage.jsp");		
	}	
}
