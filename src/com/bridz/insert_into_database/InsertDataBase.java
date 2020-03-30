package com.bridz.insert_into_database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;




//CLASS CONNECTION DATABASE BY USING MYSQL
public class InsertDataBase {

	public void getMySqlDbConnection(String firstNameToStore, String lastNameToStore, String userNameToStore, String passwordToStore) throws Exception {

		String url = "jdbc:mysql://localhost:3306/UserDataBase";
		String userName = "root";
		String password = "admin";
		String query = "select into user_form (first_name,last_name,user_name,password) values ('prathamesh','jadhav','prathm62@gmail.com','123#1`2')";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connectionWithMysql = DriverManager.getConnection(url, userName, password);
		Statement statement = connectionWithMysql.createStatement();
		statement.executeUpdate(query);
		PreparedStatement stmt = connectionWithMysql.prepareStatement("insert into user_form values(?,?,?,?)");  
		stmt.setInt(1,101);//1 specifies the first parameter in the query  
		stmt.setString(2,"Ratan");  
		
/*
		while(resultSet.next()) {
			int studentRollNumber = resultSet.getInt(1);
			String studentName = resultSet.getString(2);
			System.out.println("Student roll number : "+studentRollNumber);
			System.out.println("Student name : "+studentName);
		}
		resultSet.close();*/
		connectionWithMysql.close();
	}
	
	public static void run(String firstNameToStore, String lastNameToStore, String userNameToStore , String passwordToStore) throws Exception {

		//CREATED OBJECT OF CONNECTION DATABASE
		InsertDataBase connectionDatabaseObject =  new InsertDataBase();
		connectionDatabaseObject.getMySqlDbConnection(firstNameToStore, lastNameToStore, userNameToStore, passwordToStore);
	}
}

/*
class InsertDataBase {
	
	//RUN METHOD
	public static void main(String args[]) throws Exception {

		//CREATED OBJECT OF CONNECTION DATABASE
		InsertDatabase connectionDatabaseObject =  new InsertDatabase();
		connectionDatabaseObject.getMySqlDbConnection();
	}
}*/