package com.Amazon.practice.lanchBrowser;

import java.io.File;
import java.io.IOException;

public class GetProperyFromSystem {
	
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","c://user//abc.exe");
		System.out.println(System.getProperty("user.dir")); //GET PROJECT DIRECTORY
		System.out.println(System.getProperty("java.io.tmpdir")); //GET TEMP DIRECTORY
		System.out.println(System.getProperty("os.name")); //GET OPERATING SYSTEM NAME
		System.out.println(System.getProperty("webdriver.chrome.driver")); //GET ANY PREVIOUSLY SET VALUE FOR CUSTOMISED KEY
		System.out.println(System.getenv("LOCALAPPDATA")); //GET LOCAL APP DATA DIRECTORY
		System.out.println(System.getenv("APPDATA")); //GET ROAMING APP DATA DIRECTORY
	}

}
