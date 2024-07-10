package com.tyss.datadriven.practice_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/Data/ExcelFileData/Book1.xlsx";

		// Step1 --> convert physical file into java instance (input steam)
		FileInputStream fis = new FileInputStream(filePath);

		// Step 2--> get the instance of DataFormatter
		DataFormatter df = new DataFormatter();

		// step3 --> open workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 4 --> Create Formula Evalutor(optional --> only if we have formulas in workbook)
		FormulaEvaluator fe = wb.getCreationHelper().createFormulaEvaluator(); 
		
		// Step5 --> get the control to particular sheet
		Sheet sheet = wb.getSheet("Sheet1"); // sheetName case sensitive

		// step6 --> get the control to particular row
		Row row = sheet.getRow(4);

		// step7 --> get the control to particular column
		Cell cell = row.getCell(4);

		// step8 --> get the data from the cell
		String data = df.formatCellValue(cell, fe); // if workbook contains formulas
//		String data = df.formatCellValue(cell); //if workbook doesnot contains formulas

		System.out.println(data);
	}
}
