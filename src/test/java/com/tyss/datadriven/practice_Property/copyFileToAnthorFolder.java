package com.tyss.datadriven.practice_Property;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class copyFileToAnthorFolder {
	
	
	public static void main(String[] args) throws IOException {
		String folderPath=System.getProperty("user.dir")+"/src/test/resources/Data/propertyFileData/commonData.properties";
		String folderPath1=System.getProperty("user.dir")+"/src/test/resources/Data/propertyFileData/commonData2.properties";
		File f=new File(folderPath);
		File f1=new File(folderPath1);
		f.getParentFile().mkdirs();
		f.createNewFile();
		FileUtils.copyFile(f, f1); //copy the file
//		FileUtils.copyDirectory(f, f1); //copy the folder
	}

}
