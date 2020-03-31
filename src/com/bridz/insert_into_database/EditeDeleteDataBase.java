package com.bridz.insert_into_database;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridz.insert_into_database.*;

public class EditeDeleteDataBase extends HttpServlet {

	//VARIABLE
	static final long serialVersionUID = -156154208445344184L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String idOption = request.getParameter("id");
		String buttonOption = request.getParameter("button");
		System.out.println(idOption);
		System.out.println(buttonOption);

		if(buttonOption.equals("Delete")) {
			String query = "delete from user_form where user_id = "+idOption;
			try {
				Statement statement = InsertDataBase.getConection().createStatement();
				statement.executeUpdate(query);
				System.out.println("Record deleted successfully of id : "+idOption);
				response.sendRedirect("http://localhost:8081/WebApplicationUserRegistration/Welcome.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		//if(buttonOption2.equals("Edite")) {
		//}
	}
}
