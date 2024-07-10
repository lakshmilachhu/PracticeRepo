package ExcelPractice;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelWorkBook_CreateNewSheet {
	
	public static void main(String[] args) throws Exception {
		String path=System.getProperty("user.dir")+"/src/test/resources/Data/ExcelFileData/Book2.xlsx";
		
		XSSFWorkbook work = new XSSFWorkbook();

		XSSFSheet sheet1 = work.createSheet("Mohan");
		XSSFSheet sheet2 = work.createSheet("Lakshmi");
		XSSFCellStyle style = work.createCellStyle();
		style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		style.setFillPattern(FillPatternType.DIAMONDS);
		sheet1.createRow(0).createCell(0).setCellStyle(style);
		work.write(new FileOutputStream(path));
		System.out.println("Execution Completed");
	
	}

}
