package ExcelPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadfromExcel 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		String excelPath=System.getProperty("user.dir")+"/src/test/resources/Data/ExcelFileData/Book1.xlsx";
	
		FileInputStream fis=new FileInputStream(excelPath);
		
		DataFormatter dataForm=new DataFormatter();
		
		Workbook work=WorkbookFactory.create(fis);
		
		Sheet sheet=work.getSheet("Sheet2");
		
		Row row=sheet.getRow(2);
		
		Cell cell=row.getCell(1);
		
//		String data=cell.getStringCellValue();  //if we use this, it'll give RTE, when we trying to print numeric or any other type of value except string
		
		String value=dataForm.formatCellValue(cell); //to avoid this we'll go with DataFormatter
		System.out.println(value);
		
	}
}