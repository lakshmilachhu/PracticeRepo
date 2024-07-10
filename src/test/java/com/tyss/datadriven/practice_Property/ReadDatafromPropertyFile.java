package com.tyss.datadriven.practice_Property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDatafromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		String filePath=System.getProperty("user.dir")+"/src/test/resources/Data/propertyFileData/commonData.properties";
		
		//5 steps
		//Step1--> get the physical file into java memory instance
		FileInputStream fis=new FileInputStream(filePath);
		
		//Step2 --> get the instance of properties class
		Properties prop=new Properties();
		
		//Step3 --> load all the keys to property instance
		prop.load(fis);
		
		//Step 4 --> close input steam
		fis.close();
		
		//step5 --> get data from propery file based on key
		String value = prop.getProperty("url"); //keys are case sensitive
		if(value!=null)value=value.trim();
		System.out.println(value);
		
	}

}
