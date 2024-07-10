package Jdbc.practice.Selectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyParticular_data_inDB_fromLastRow 
{
	public static boolean verifySpecified_Data_fromLast(ResultSet result,String columnName,String value) throws SQLException
	{
		boolean flag=false;
		result.last();
		result.next();
		while(result.previous())
			if(result.getString(columnName).equalsIgnoreCase(value))
			{
				flag=true;
				break;
			}
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

		boolean status=verifySpecified_Data_fromLast(result,"subject","Hindi");
		if(status==true)
			System.out.println("Data is present in DB");
		else
			System.out.println("Data is not present in DB");

		connect.close();
	}

}
