package Jdbc.practice.Selectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadAllDatafrom_DB 
{
	public static void main(String[] args) throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
		Statement state=connect.createStatement();
		String query="Select * from Students_data";
		ResultSet result=state.executeQuery(query);
		
		System.out.println("Students_data is: ");
		while(result.next())
			System.out.println(result.getInt(1) + "\t" + result.getString("Name") + "\t" + result.getString("Subject"));
		
		connect.close();
	}
}
