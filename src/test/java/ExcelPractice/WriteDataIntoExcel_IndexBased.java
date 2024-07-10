package ExcelPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel_IndexBased {
	
	public static void main(String[] args) throws Exception {
		String path=System.getProperty("user.dir")+"/src/test/resources/Data/ExcelFileData/Book1.xlsx";
		FileInputStream fis=new FileInputStream(path);
		Workbook work=WorkbookFactory.create(fis);
		
		Sheet sheet=work.getSheet("Sheet3");
		int rowIndex=17;
		int columnIndex=0;
		
		Row row = sheet.getRow(rowIndex);
		if(row==null)
			row = sheet.createRow(rowIndex);
		
		Cell cell = row.createCell(columnIndex);		
		cell.setCellValue("PASSed");
		
		work.write(new FileOutputStream(path));
		System.out.println("Execution Completed");
	}

}
