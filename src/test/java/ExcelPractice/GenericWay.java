package ExcelPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericWay 
{
//	public static String getSpecifiedDataFromExcel(String excelFileName,String sheetName,String testCaseID, String headerName) throws Exception
//	{
//		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Data/ExcelFileData/"+excelFileName);
//		Workbook work=WorkbookFactory.create(fis);
//		DataFormatter df=new DataFormatter();
//		Sheet sheet=work.getSheet(sheetName);
//		String value="";

//		for(int i=0;i<=sheet.getLastRowNum();i++)
//		{
//			String tcID=df.formatCellValue(sheet.getRow(i).getCell(0));
//			if(tcID.equalsIgnoreCase(testCaseID))
//			{
//				for(int j=0;j<sheet.getRow(i-1).getLastCellNum();j++)
//				{
//					String header=df.formatCellValue(sheet.getRow(i-1).getCell(j));
//					if(header.equalsIgnoreCase(headerName))
//					{
//						value=df.formatCellValue(sheet.getRow(i).getCell(j));
//						break;
//					}
//				}
//				break;
//			}
//
//		}
//		work.close();
//		fis.close();
//		return value;
//	}
//	

//	public static Map getAllHeaderandValues(String excelFileName, String sheetName, String testCaseID) throws IOException
//	{
//		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Data/ExcelFileData/"+excelFileName);
//		DataFormatter df=new DataFormatter();
//		Workbook work=WorkbookFactory.create(fis);
//		Map<String,String> hMap=new HashMap();
//		Sheet sheet=work.getSheet(sheetName);
		
//		for(int i=0; i<=sheet.getLastRowNum();i++)
//		{
//			String tcID=df.formatCellValue(sheet.getRow(i).getCell(0));
//			if(tcID.equalsIgnoreCase(testCaseID))
//			{
//				for(int j=0; j<sheet.getRow(i-1).getLastCellNum();j++)
//				{
//					String key=df.formatCellValue(sheet.getRow(i-1).getCell(j));
//					String value=df.formatCellValue(sheet.getRow(i).getCell(j));
//					hMap.put(key, value);
//				}
//				break;
//			}
//		}
//		work.close();
//		fis.close();
//		return hMap;
//	}
//	
	public static List<Map> getAllDatafromExcel(String excelFileName, String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Data/ExcelFileData/"+excelFileName);
		DataFormatter df=new DataFormatter();
		Workbook work=WorkbookFactory.create(fis);
		List<Map> listMap=new ArrayList<>();
		Sheet sheet=work.getSheet(sheetName);
	
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			String tcID=df.formatCellValue(sheet.getRow(i).getCell(0));
			Map<String,String> hmap=new HashMap<>();
			if(tcID.startsWith("tc"))
			{
				for(int j=0; j<sheet.getRow(i-1).getLastCellNum();j++)
				{
					String key=df.formatCellValue(sheet.getRow(i-1).getCell(j));
					String value=df.formatCellValue(sheet.getRow(i).getCell(j));
					hmap.put(key, value);
				}
			}
			listMap.add(hmap);
		}
		work.close();
		fis.close();
		return listMap;
	}	
}

