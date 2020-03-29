package com.bridz.insert_into_database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//INTERFACE MY SQL HELPER
interface MySqlHelper {
	void getMySqlDbConnection() throws Exception;
}


//CLASS CONNECTION DATABASE BY USING MYSQL
class ConnectionDatabase implements MySqlHelper {

	public void getMySqlDbConnection() throws Exception	{

		String url = "jdbc:mysql://localhost:3306/TestDataBase";
		String userName = "root";
		String password = "admin";
		String query = "select * from student";

		Class.forName("com.mysql.jdbc.Driver");
		Connection connectionWithMysql = DriverManager.getConnection(url, userName, password);
		Statement statement = connectionWithMysql.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		while(resultSet.next()) {
			int studentRollNumber = resultSet.getInt(1);
			String studentName = resultSet.getString(2);
			System.out.println("Student roll number : "+studentRollNumber);
			System.out.println("Student name : "+studentName);
		}
		resultSet.close();
		connectionWithMysql.close();
	}
}


public class InsertDataBase {

	//RUN METHOD
	public static void run() throws Exception {

		//CREATED OBJECT OF CONNECTION DATABASE
		ConnectionDatabase connectionDatabaseObject =  new ConnectionDatabase();
		connectionDatabaseObject.getMySqlDbConnection();
	}
}
