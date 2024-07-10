package Jdbc.practice.Selectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadFirstLastDatafrom_DB 
{
	public static void main(String[] args) throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
		Statement state=connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String query="select * from students_data";
		ResultSet result=state.executeQuery(query);
		
		result.first();
		System.out.println("first element in column 2: " + result.getString(2));  //passing column index
		
		result.last();
		System.out.println("last element in column 1: " + result.getString(1));
			
		connect.close();
	
	}

}
