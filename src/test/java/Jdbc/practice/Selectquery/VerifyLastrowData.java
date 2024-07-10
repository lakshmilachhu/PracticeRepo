package Jdbc.practice.Selectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyLastrowData 
{
	private static boolean verifyLastRowData(ResultSet result,String columnName,String value) throws SQLException
	{
		boolean flag=false;
		result.last();
		flag=result.getString(columnName).equalsIgnoreCase(value);
		return flag;
	}
	public static void main(String[] args) throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
		Statement state=connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String query="Select * from Students_data";
		ResultSet result=state.executeQuery(query);
		
		boolean status=verifyLastRowData(result,"Name","Lahana");
		if(status==true)
			System.out.println("Given data is present in last row: " + status);
		else
			System.out.println("Given data is present in last row: " + status);
		connect.close();
		
	}

}
