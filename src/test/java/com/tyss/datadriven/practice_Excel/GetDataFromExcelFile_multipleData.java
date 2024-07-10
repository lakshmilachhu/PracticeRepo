package com.tyss.datadriven.practice_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile_multipleData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/Data/ExcelFileData/Book1.xlsx";

		FileInputStream fis = new FileInputStream(filePath);
		DataFormatter df = new DataFormatter();
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1"); 
		
		int lastRowIndex = sheet.getLastRowNum();
		for (int i = 0; i <=lastRowIndex; i++) {
			Row row = sheet.getRow(i);
			int cellCount=row.getLastCellNum();
			String data="";
			for (int j = 0; j < cellCount; j++) {
				Cell cell = row.getCell(j);
				data =data+ df.formatCellValue(cell)+" == ";
			}
			System.out.println(data);
		}
		

		
	}
}
