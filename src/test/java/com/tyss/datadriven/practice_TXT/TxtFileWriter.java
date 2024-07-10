package com.tyss.datadriven.practice_TXT;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileWriter {
	
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\Lakshmi\\OneDrive\\Desktop\\Selenium\\mohan\\lakshmi\\mohan.txt");
		FileWriter fw=new FileWriter(f,true);  //true is mandotory if you want to retain old data
		BufferedWriter bw=new BufferedWriter(fw);
		bw.newLine();
		bw.append("I am Mohan");
		bw.flush();
	}

}
