package com.tyss.datadriven.practice_TXT;

import java.io.File;

public class FolderHandle_1 {
	
	
	public static void main(String[] args)  {
		String folderPath="C:\\Users\\Lakshmi\\OneDrive\\Desktop\\Selenium\\mohan\\lakshmi";
		
		File f=new File(folderPath);
		f.mkdirs();
		System.out.println(f.exists());
		f.delete();
	}

}
