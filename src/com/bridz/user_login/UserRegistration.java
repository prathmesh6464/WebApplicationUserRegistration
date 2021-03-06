package com.bridz.user_login;
import com.bridz.insert_into_database.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//USER REGISTRATION FORM
public class UserRegistration extends HttpServlet {

	//VARIABLE
	static final long serialVersionUID = -1561542084453441840L;

	public void service(HttpServletRequest request, HttpServletResponse response) {

		String nameOfUser = request.getParameter("nameOfUser");
		String lastNameOfUser = request.getParameter("lastNameOfUser");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println("First name : "+nameOfUser); 
		System.out.println("Last name : "+lastNameOfUser);
		System.out.println("User name : "+userName);
		System.out.println("Password : "+password);

		try {
			InsertDataBase.run(nameOfUser, lastNameOfUser, userName, password);			
			response.sendRedirect("http://localhost:8081/WebApplicationUserRegistration/Welcome.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}