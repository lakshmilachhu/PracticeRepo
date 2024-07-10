package ExcelPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Practice1 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/Data/ExcelFileData/Book1.xlsx");
		DataFormatter df=new DataFormatter();
		Map<String,String> hMap=new HashMap<>();
		Workbook work=WorkbookFactory.create(fis);
		Sheet sheet=work.getSheet("Sheet3");

		for(int i=0; i<=sheet.getLastRowNum();i++)
		{
			String tcID=df.formatCellValue(sheet.getRow(i).getCell(0));
			if(tcID.equalsIgnoreCase("tc003"))
			{
				for(int j=0; j<sheet.getRow(i-1).getLastCellNum();j++)
				{
					String key=df.formatCellValue(sheet.getRow(i-1).getCell(j));
					String value=df.formatCellValue(sheet.getRow(i).getCell(j));
					hMap.put(key, value);
				}
				break;
			}
		}
		
		System.out.println(hMap);
	}
}