package Jdbc.practice.NonSelectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDatafrom_MYSQL_DB_NonSelectquery 
{
	public static void main(String[] args) throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Info","root","root");
		
		Statement state=con.createStatement();
		String query="insert into Students_data values('5','Ahana','Hindi')";
		
		int result=state.executeUpdate(query);	
		
		if(result==1)
			System.out.println("user is created");
		else
			System.out.println("user is not created");
		
		con.close();
	}

}
