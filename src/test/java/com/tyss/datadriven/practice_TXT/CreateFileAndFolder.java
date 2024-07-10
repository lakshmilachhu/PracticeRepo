package com.tyss.datadriven.practice_TXT;

import java.io.File;
import java.io.IOException;

public class CreateFileAndFolder {
	
	
	public static void main(String[] args) throws IOException {
		String folderPath="C:\\Users\\Lakshmi\\OneDrive\\Desktop\\Selenium\\mohan\\lakshmi\\lakshmi.txt";
		File f=new File(folderPath);
		f.getParentFile().mkdirs();
		f.createNewFile();
	}

}
