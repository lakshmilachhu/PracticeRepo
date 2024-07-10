package Jdbc.practice.Selectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.mysql.cj.jdbc.Driver;

public class GetAllColumnData_basedOnRowData 
{
	public static Map<String, String> getAllColumndata_basedonRowValue(ResultSet set,String uniqueColumnName, String uniqueData) throws SQLException
	{
		Map<String,String> map=new LinkedHashMap<>();
		while(set.next())
		{
			if(set.getString(uniqueColumnName).equalsIgnoreCase(uniqueData))
			{
				int count=set.getMetaData().getColumnCount();
				for(int i=1;i<=count;i++)
				{
					String key=set.getMetaData().getColumnName(i);
					map.put(key, set.getString(key));
				}
				break;
			}	
		}
		return map;
	}
	
	public static void main(String[] args) throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
		Statement state=connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String query="Select * from Students_data";
		ResultSet set=state.executeQuery(query);
		
		Map<String,String> map=getAllColumndata_basedonRowValue(set,"Student_ID","103");
		System.out.println(map);
		connect.close();
	}
}
