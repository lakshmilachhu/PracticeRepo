package PropertyFilePractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDatafromPropertyFile 
{
	public static void main(String[] args) throws IOException
	{
		String filePath=System.getProperty("user.dir")+"/src/test/resources/Data/propertyFileData/propertyfile.properties";
		
		FileInputStream fis=new FileInputStream(filePath);
	
		Properties prop=new Properties();
	
		prop.load(fis);
		
		fis.close();
		
		String data1=prop.getProperty("UserName");
		System.out.println("UserName is: " + data1);
		
		String data2=prop.getProperty("Password");
		System.out.println("Password is: " + data2);  //fetch recent data
		
		String data3=prop.getProperty("Language","Specified Key is not Present");
		System.out.println(data3); //if key is not present it'll send default value
		
		String data4=prop.getProperty("Language");
		System.out.println(data4); //if we send getProperty() without default value, suppose key is not present then it'll show null
		
		String data5=prop.getProperty("OS");
		System.out.println("Key with space: " + data5);
		
		String data6=prop.getProperty("OS");
		if(data6!=null)
			data6=data6.trim();
		System.out.println("Key without space: " + data6);
	
	}

}
