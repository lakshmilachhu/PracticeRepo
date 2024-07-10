package Jdbc.practice.Selectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.jdbc.Driver;

public class GetData_from_userSpecifiedColumn 
{
	public static List<Map<String, String>> getListofData_fromSpecifiedColumns(ResultSet result,String columnNames) throws SQLException
	{
		List<Map<String,String>> listMap=new ArrayList<>();
		while(result.next())
		{
			Map<String,String> map=new LinkedHashMap<>();
			String[] strArr=columnNames.split(",");
			for(int i=0; i<strArr.length;i++)
			{
				String key=strArr[i];
				map.put(key, result.getString(key));
			}
			listMap.add(map);
		}
		return listMap;
	}
	
	public static void main(String[] args) throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
		Statement state=connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String query="Select * from Students_data";
		ResultSet result=state.executeQuery(query);
		
		String columnNames="student_ID,Name";
		List<Map<String,String>> listMap=getListofData_fromSpecifiedColumns(result,columnNames);
		System.out.println(listMap);
		connect.close();
	}

}
