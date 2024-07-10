package Jdbc.practice.Selectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.jdbc.Driver;

public class ReadData_usingSQLquery {
	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "root");

		Statement state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String query = "Select * from Students_data";

		ResultSet result = state.executeQuery(query);

		// if we want to verify wheather particular data present in table in particular column or not from first row
//		boolean isPresent=verifyDataInDB(result, "student_ID", "5");

		// if we want to verify wheather particular data present in table at last row or not
//		boolean isPresent=verifyDataInDBAtLast(result, "student_ID", "5");

		// if we want to verify wheather particular data present in table in particular column or not from last row
//		boolean isPresent=verifyDataInDBFromLast(result, "student_ID", "5");

		// if we want to get all row data from paticular column
//		List<String> list = getAllRowDataFromColumn(result, "student_ID");
//		System.out.println(list);

		// if we want to get all row data from user specified column
//		String columnNames = "student_ID,Name,subject";
//		List<Map<String, String>> list=getAllRowDataFromSpecifiedColumn(result, columnNames);

		// If we want to get all row data from all columns
	//	List<Map<String, String>> list=getAllRowDataFromAllColumn(result);
		
		//If we want to get all column data for particular row(we should specify unique column name and data)
		Map<String, String> map = getAllColumnDataFromParticularRow(result, "student_ID", "101");
				
		// if we want to get column Count
//		int columnCount =getColumnCount(result);

		// if we want to get row count
//		int rowCount = getRowCount(result);
		
		//get row count ==> other way
//		ResultSet r = state.executeQuery("Select COUNT(*) as count from students_data;");
//		r.next();
//		System.out.println("COunt==> " + r.getString("count"));
		
		con.close();
	}

	private static boolean verifyDataInDB(ResultSet result, String columnName, String data) throws SQLException {
		boolean flag = false;
		result.first();
		while (result.next()) {
			if (result.getString(columnName).equalsIgnoreCase(data)) {
				System.out.println("Data present in DB");
				flag = true;
				break;
			}
		}
		return flag;
	}

	private static boolean verifyDataInDBAtLast(ResultSet result, String columnName, String data) throws SQLException {
		boolean flag = false;
		result.last();
		flag = result.getString(columnName).equalsIgnoreCase(data);
		return flag;
	}

	private static boolean verifyDataInDBFromLast(ResultSet result, String columnName, String data)
			throws SQLException {
		boolean flag = false;
		result.last();
		while (result.previous()) {
			if (result.getString(columnName).equalsIgnoreCase(data)) {
				System.out.println("Data present in DB");
				flag = true;
				break;
			}
		}
		return flag;
	}

	private static List<String> getAllRowDataFromColumn(ResultSet result, String columnName) throws SQLException {
		List<String> list = new ArrayList<>();
		while (result.next()) {
			list.add(result.getString(columnName));
		}
		return list;
	}

	private static List<Map<String, String>> getAllRowDataFromSpecifiedColumn(ResultSet result, String columnNames)
			throws SQLException {
		List<Map<String, String>> list = new ArrayList<>();
		while (result.next()) {
			Map<String, String> map = new LinkedHashMap<>();
			String[] strArr = columnNames.split(",");
			for (int i = 0; i < strArr.length; i++) {
				String key = strArr[i];
				map.put(key, result.getString(key));
			}
			list.add(map);
		}
		return list;
	}

	private static List<Map<String, String>> getAllRowDataFromAllColumn(ResultSet result) throws SQLException {
		List<Map<String, String>> list = new ArrayList<>();
		while (result.next()) {
			Map<String, String> map = new LinkedHashMap<>();
			int columnCount = result.getMetaData().getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String key = result.getMetaData().getColumnName(i);
				map.put(key, result.getString(key));
			}
			list.add(map);
		}
		return list;
	}

	
	private static Map<String, String> getAllColumnDataFromParticularRow(ResultSet result, String uniqueKeyColumnName, String uniqueData) throws SQLException {
		Map<String, String> map = new LinkedHashMap<>();
		while (result.next()) {
			if(result.getString(uniqueKeyColumnName).equalsIgnoreCase(uniqueData)){
				int columnCount = result.getMetaData().getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					String key = result.getMetaData().getColumnName(i);
					map.put(key, result.getString(key));
				}
				break;
			}
		}
		return map;
	}

	
	private static int getColumnCount(ResultSet result) throws SQLException {
		return result.getMetaData().getColumnCount();
	}

	private static int getRowCount(ResultSet result) throws SQLException {
		int rowCount = 0;
		while (result.next()) {
			rowCount++;
		}
		return rowCount;
	}

}
