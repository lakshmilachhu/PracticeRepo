package ExcelPractice;

import java.util.List;
import java.util.Map;

public class ReadDataFromExcel 
{
	public static void main(String[] args) throws Exception
	{
//		String value = GenericWay.getSpecifiedDataFromExcel("Book1.xlsx","Sheet3","TC003","product_name");
//		String value1 = GenericWay.getSpecifiedDataFromExcel("Book1.xlsx","Sheet3","TC003","url");
//		System.out.println(value);
//		System.out.println(value1);
//		
//		Map map=GenericWay.getAllHeaderandValues("Book1.xlsx", "Sheet3", "tc001");
//		System.out.println(map);
//		
		List<Map> listMap=GenericWay.getAllDatafromExcel("Book1.xlsx", "Sheet3");
		System.out.println(listMap);
		
	}

}
