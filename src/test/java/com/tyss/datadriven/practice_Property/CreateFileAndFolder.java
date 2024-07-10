package com.tyss.datadriven.practice_Property;

import java.io.File;
import java.io.IOException;

public class CreateFileAndFolder {
	
	
	public static void main(String[] args) throws IOException {
		String folderPath=System.getProperty("user.dir")+"/src/test/resources/Data/propertyFileData/commonData.properties";
		File f=new File(folderPath);
		f.getParentFile().mkdirs();
		f.createNewFile();
	}

}
