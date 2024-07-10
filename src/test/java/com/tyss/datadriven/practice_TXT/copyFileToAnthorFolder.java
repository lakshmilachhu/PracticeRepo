package com.tyss.datadriven.practice_TXT;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class copyFileToAnthorFolder {
	
	
	public static void main(String[] args) throws IOException {
		String folderPath="C:\\Users\\Lakshmi\\OneDrive\\Desktop\\Selenium\\mohan\\lakshmi\\mohan.txt";
		String folderPath1="C:\\Users\\Lakshmi\\eclipse-workspace\\Amazon.Ecommerce.Selenium\\src\\test\\resources\\Data\\TxtFileData\\lakshmi.txt";
		File f=new File(folderPath);
		File f1=new File(folderPath1);
		f.getParentFile().mkdirs();
		f.createNewFile();
		FileUtils.copyFile(f, f1); //copy the file
//		FileUtils.copyDirectory(f, f1); //copy the folder
	}

}
