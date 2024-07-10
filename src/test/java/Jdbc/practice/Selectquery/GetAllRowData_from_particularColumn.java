package Jdbc.practice.Selectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class GetAllRowData_from_particularColumn 
{
	public static List<String> getAllRowData(ResultSet result,String columnName) throws SQLException
	{
		List<String> list=new ArrayList<>();
		while(result.next())
			list.add(result.getString(columnName));
		return list;
	}
	
	public static void main(String[] args) throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
		Statement state=connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String query="Select * from Students_data";
		ResultSet result=state.executeQuery(query);
		
		List<String> dataList=getAllRowData(result,"Name");
		System.out.println(dataList);
		
		connect.close();
	}

}
