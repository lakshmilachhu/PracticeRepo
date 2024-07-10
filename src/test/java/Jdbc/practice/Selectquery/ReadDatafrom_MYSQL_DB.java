package Jdbc.practice.Selectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDatafrom_MYSQL_DB 
{
	public static void main(String[] args) throws SQLException
	{
		//step1: register/load the mySql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2: get connect to database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Info","root","root");
		
		//step3: create sql statement
		Statement state=con.createStatement();
		String query="select * from Students_data";
		
		//step4: execute statement/query
		ResultSet result=state.executeQuery(query);
	
		while(result.next())
			System.out.println(result.getInt("student_ID") + "\t" + result.getString("Name"));
		
		//step5: close the connection
		con.close();
	}

}
