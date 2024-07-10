package ExcelPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadfromExcel1 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/resources/Data/ExcelFileData/Book1.xlsx";
		FileInputStream fis=new FileInputStream(path);
		Workbook work=WorkbookFactory.create(fis);
		Sheet sheet=work.getSheet("Sheet2");
		
		//Create a new row within the sheet and return the high level representation
		sheet.createRow(6);   
		
		//the number of the first logical row on the sheet (0-based)or -1 if no row exists
		int firstRowNum=sheet.getFirstRowNum();
		System.out.println(firstRowNum);
		
		//last row contained on this sheet (0-based) or -1 if no row exists
		int lastRowNum=sheet.getLastRowNum();
		System.out.println(lastRowNum);
		
		//short indicating the rownum (0 based) of the top row
		Short topRow=sheet.getTopRow();
		System.out.println(topRow);
	
		//Returns if formulas are displayed or not
		boolean check=sheet.isDisplayFormulas();
		System.out.println("Formula is applied in sheet ?: " + check);
	

	}

}
