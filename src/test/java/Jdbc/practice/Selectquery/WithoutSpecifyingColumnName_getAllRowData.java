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

public class WithoutSpecifyingColumnName_getAllRowData 
{
	public static List<Map<String,String>> getAllRowData(ResultSet result) throws SQLException
	{
		List<Map<String,String>> listMap=new ArrayList<>();

		while(result.next())
		{
			Map<String,String> map=new LinkedHashMap<>();
			int columnCount=result.getMetaData().getColumnCount();
			for(int i=1;i<=columnCount;i++)
			{
				String key=result.getMetaData().getColumnName(i);
				map.put(key, result.getString(i));
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
		String query="select * from students_data";
		ResultSet result=state.executeQuery(query);
		
		List<Map<String,String>> list=getAllRowData(result);
		System.out.println(list);
		connect.close();
	}

}
