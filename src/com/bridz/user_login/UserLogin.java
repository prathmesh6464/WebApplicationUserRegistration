package com.bridz.user_login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//CLASS USER LOGIN EXTENDS HTTP SERVLET
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 2970376729289338191L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		PrintWriter responseObject = response.getWriter();
		responseObject.println(userName);
	}
}