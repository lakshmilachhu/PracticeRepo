package com.tyss.datadriven.practice_TXT;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileWriterAndOpenFileAfterExecution {
	
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\Lakshmi\\OneDrive\\Desktop\\Selenium\\mohan\\lakshmi\\mohan.txt");
		FileWriter fw=new FileWriter(f,true);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.newLine();
		bw.append("I am Mohan");
		bw.flush();
		
		Desktop.getDesktop().browse(f.toURI());
		
	}

}
