package com.bridz.insert_into_database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//INTERFACE ORACLE HELPER
interface OracleHelper
{
	void getOracleDbConnection() throws Exception;
}


//CLASS CONNECTION DATABASE ACTS AS A FACADE
class ConnectionDatabase implements OracleHelper
{
	public void getOracleDbConnection() throws Exception
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "system";
		String password = "admin";
		String query = "select * from customers";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connectionWithOracle = DriverManager.getConnection(url, userName, password);
		Statement statement = connectionWithOracle.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		while(resultSet.next())
		{
			int customerID = resultSet.getInt("customer_id");
			String customerName = resultSet.getString("customer_name");
			String customerCity = resultSet.getString("city");
			System.out.println("Cutomer id : "+customerID);
			System.out.println("Cutomer name : "+customerName);
			System.out.println("Cutomer city : "+customerCity);
		}
		resultSet.close();
		connectionWithOracle.close();
	}
}


public class InsertDataBase {
	

}
