package com.bridz.insert_into_database;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridz.insert_into_database.EditeDeleteDataBase;

public class EditeUsersData extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String firstName = request.getParameter("nameOfUser");
		String lastName = request.getParameter("lastNameOfUser");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String QUERY_FOR_UPDATE = "UPDATE user_form	SET first_name = ?, last_name = ?,"
				+ "user_name = ?, password = ? WHERE user_id = ?";
		PreparedStatement preparedStatementObject = null;

		try {
			preparedStatementObject = InsertDataBase.getConection().prepareStatement(QUERY_FOR_UPDATE);
			preparedStatementObject.setString(1, firstName);
			preparedStatementObject.setString(2, lastName);
			preparedStatementObject.setString(3, userName);
			preparedStatementObject.setString(4, password);
			preparedStatementObject.setString(5, EditeDeleteDataBase.idOption);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		try {
			preparedStatementObject.executeUpdate();
			preparedStatementObject.close();
			InsertDataBase.getConection().close();
			response.sendRedirect("http://localhost:8081/WebApplicationUserRegistration/Welcome.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
