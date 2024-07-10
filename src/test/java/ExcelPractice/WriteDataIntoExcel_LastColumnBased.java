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

public class WriteDataIntoExcel_LastColumnBased {

	public static void main(String[] args) throws Exception {
		String path=System.getProperty("user.dir")+"/src/test/resources/Data/ExcelFileData/Book1.xlsx";
		FileInputStream fis=new FileInputStream(path);
		Workbook work=WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
		Sheet sheet=work.getSheet("Sheet3");

		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			String id=df.formatCellValue(sheet.getRow(i).getCell(0));
			if(id.equalsIgnoreCase("tc003"))
			{
				short lastCell=sheet.getRow(i).getLastCellNum();
				for(int j=0; j<sheet.getRow(i-1).getLastCellNum(); j++)
				{
					sheet.getRow(i-1).createCell(lastCell).setCellValue("status");
					sheet.getRow(i).createCell(lastCell).setCellValue("passed");
					break;
				}
				break;		
			}
		}
		work.write(new FileOutputStream(path));
	}

	//		for (int i = 0; i <=sheet.getLastRowNum(); i++) {
	//			String tcID = df.formatCellValue(sheet.getRow(i).getCell(0));
	//			if(tcID.equalsIgnoreCase("tc002")) {
	//				short cellIndex = sheet.getRow(i).getLastCellNum();
	//				String da = df.formatCellValue(sheet.getRow(i-1).getCell(cellIndex-1));
	//				int count=1;
	//				if(da.startsWith("status"))
	//					{
	//					da=da.replace("status", "").trim();
	//					count=Integer.parseInt(da);
	//					count++;
	//					}
	//				sheet.getRow(i).createCell(cellIndex).setCellValue("pass");
	//				sheet.getRow(i-1).createCell(cellIndex).setCellValue("status "+count);
	//				break;
	//			}
	//		}
	//		work.write(new FileOutputStream(path,true));
	//		System.out.println("Execution Completed");

}


