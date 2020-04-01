package com.bridz.insert_into_database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//INSERT DATABASE  USING MYSQL
public class InsertDataBase {

	// PROVIDES CONNECTION
	public static Connection getConection() throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/UserDataBase";
		String userName = "root";
		String password = "admin";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connectionWithMysql = DriverManager.getConnection(url, userName, password);
		return connectionWithMysql;
	}

	// INSERTING DATA INTO DATABASE
	public void getMySqlForInsertingDataIntoDatabase(String firstNameToStore, String lastNameToStore,
			String userNameToStore, String passwordToStore) throws Exception {

		Connection connectionWithMysql = getConection();

		PreparedStatement preparedStatement = connectionWithMysql
				.prepareStatement("INSERT INTO user_form "
						+ "(first_name,last_name,user_name,password) VALUES (?,?,?,?)");

		preparedStatement.setString(1, firstNameToStore);// 1 specifies the first parameter in the query
		preparedStatement.setString(2, lastNameToStore);
		preparedStatement.setString(3, userNameToStore);
		preparedStatement.setString(4, passwordToStore);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connectionWithMysql.close();
	}

	// FOR GETTING RESULT SET
	public static ResultSet getResultSet() throws SQLException, ClassNotFoundException {

		String SELECT_QUERY = "SELECT * FROM User_Form";
		Connection connectionWithMysql = getConection();
		Statement statement = connectionWithMysql.createStatement();
		ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
		return resultSet;
	}

	// FOR EXECUTING OTHER METHOD
	public static void run(String firstNameToStore, String lastNameToStore, String userNameToStore,
			String passwordToStore) throws Exception {

		// CREATED OBJECT OF CONNECTION DATABASE
		InsertDataBase connectionDatabaseObject = new InsertDataBase();
		connectionDatabaseObject.getMySqlForInsertingDataIntoDatabase(firstNameToStore, lastNameToStore,
				userNameToStore, passwordToStore);
	}
}
