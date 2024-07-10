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

public class ReadfromExcel2 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/resources/Data/ExcelFileData/Book1.xlsx";
		
		FileInputStream fis=new FileInputStream(path);
		Workbook work=WorkbookFactory.create(fis);
		Sheet sheet=work.getSheet("Sheet2");
		Row row=sheet.getRow(3);

		//short representing the first logical cell in the row,or -1 if the row does not contain any cells.
		short firstCellnum=row.getFirstCellNum();
		System.out.println(firstCellnum);
		
		//short representing the last logical cell in the row PLUS ONE,or -1 if the row does not contain any cells
		int lastCellnum=row.getLastCellNum();
		System.out.println(lastCellnum);
		
		
	}

}
