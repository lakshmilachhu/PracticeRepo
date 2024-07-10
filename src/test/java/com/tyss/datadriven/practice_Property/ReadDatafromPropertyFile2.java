package com.tyss.datadriven.practice_Property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDatafromPropertyFile2 {
	
	public static void main(String[] args) throws IOException {
		String filePath=System.getProperty("user.dir")+"/src/test/resources/Data/propertyFileData/commonData.properties";
		
		//5 steps
		//Step1--> convert the physical file into java memory instance
		FileInputStream fis=new FileInputStream(filePath);
		
		//Step2 --> create the instance of properties class
		Properties prop=new Properties();
		
		//Step3 --> load all the keys-value to properties class instance
		prop.load(fis);
		
		//Step 4 --> close input steam
		fis.close();
		
		//step5 --> get data from propery file based on key
		String value = prop.getProperty("pwd","Specified key not present in property file").trim(); //keys are case sensitive
		
		System.out.println(value);
		
	}

}
