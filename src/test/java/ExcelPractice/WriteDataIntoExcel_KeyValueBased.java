package ExcelPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel_KeyValueBased {
	
	public static void main(String[] args) throws Exception {
		String path=System.getProperty("user.dir")+"/src/test/resources/Data/ExcelFileData/Book1.xlsx";
		FileInputStream fis=new FileInputStream(path);
		Workbook work=WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
		Sheet sheet=work.getSheet("Sheet3");
		for (int i = 0; i <=sheet.getLastRowNum(); i++) {
			String tcID = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(tcID.equalsIgnoreCase("tc003")) {
				for (int j = 0; j < sheet.getRow(i-1).getLastCellNum(); j++) {
					String headerName = df.formatCellValue(sheet.getRow(i-1).getCell(j));
					if(headerName.equalsIgnoreCase("Status")) {
						sheet.getRow(i).createCell(j).setCellValue("Fail");
						break;
					}
				}
				break;
			}
		}
		work.write(new FileOutputStream(path));
		System.out.println("Execution Completed");
	
	}

}
