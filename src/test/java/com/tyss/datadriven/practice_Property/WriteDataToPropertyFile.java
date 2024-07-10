package com.tyss.datadriven.practice_Property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataToPropertyFile {
	
	public static void main(String[] args) throws IOException {
		String filePath=System.getProperty("user.dir")+"/src/test/resources/Data/propertyFileData/commonData.properties";
		
		//Step1 --> get the instance of properties class
		Properties prop=new Properties();

		//step2 --> set data to propery file based on key
		prop.setProperty("url2","http://google.co.in");
		prop.setProperty("un2","mohanlakshmi"); 
		prop.setProperty("pwd2","09876543"); 
		
		//Step3 --> create instance of fileoutputsteam to save the file along with true
		FileOutputStream fos=new FileOutputStream(filePath,true); //true is mandotory if you want to retain old data
		
		//step4 --> store all property instance data to fileoutsteam
		prop.store(fos, "Example added data");//usually we will specify time and date along with purpose
		
		//step5 --> save the file and close the stream
		fos.flush();
		fos.close();
		
	}

}
