package com.tyss.datadriven.practice_TXT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TxtFileReader {
	
	public static void main(String[] args) throws IOException {
		String filePath="C:\\Users\\Lakshmi\\OneDrive\\Desktop\\Selenium\\mohan\\lakshmi\\mohan.txt";
		String key="browser";
		String value=getValueFromTxt(filePath, key);
		System.out.println(value);
		
		 key="url";		
		System.out.println(getLineDataFromTxt(filePath, key));
		
		System.out.println(getLineDataFromTxt(filePath, 1));
	}
	
	
	
	
	
	public static String getValueFromTxt(String filePath, String key) throws IOException {
		File f=new File(filePath);
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String s=br.readLine();
		String value="";
		
		while(s!=null) {
			if(s.startsWith(key)) {
			value=s.replace(key+"=", "");
			break;
			}
			s=br.readLine();
		}
		return value;
	}
	
	public static String getLineDataFromTxt(String filePath, String key) throws IOException {
		File f=new File(filePath);
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String s=br.readLine();
			
		while(s!=null) {
			if(s.startsWith(key)) break;
			s=br.readLine();
		}
		return s;
	}
	public static String getLineDataFromTxt(String filePath, int lineCount) throws IOException {
		File f=new File(filePath);
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String s=br.readLine();
			int count=0;
		while(s!=null) {
			count++;
			if (count==lineCount)break;
			s=br.readLine();
		}
		return s;
	}

}
