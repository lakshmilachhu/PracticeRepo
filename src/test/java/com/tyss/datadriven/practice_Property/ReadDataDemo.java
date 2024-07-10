package com.tyss.datadriven.practice_Property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataDemo 
{
	public static void main(String[] args) throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/resources/Data/propertyFileData/commonData.properties";
		
		FileInputStream fl=new FileInputStream(path);
		Properties pr=new Properties();
		pr.load(fl);
		fl.close();
		System.out.println(pr.getProperty("user_Name"));
		System.out.println(pr.getProperty("pwd"));
		String defaultValue=pr.getProperty("emailID","Key is not present");
		System.out.println(defaultValue);
	} 

}
