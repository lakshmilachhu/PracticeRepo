package com.testyantra.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * this class contains java specific libraries
 * @author Lakshmi
 *
 */

public class JavaUtility 
{
	/**
	 * this method is used to generate integer random numbers with in the boundary of 0 to 1000
	 * @return int data
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int randomNum=ran.nextInt(1000);
		return randomNum;
	}
	
	/**
	 * this method is used to get date and time of the current system
	 * @return string data
	 */
	public String getSystemDate()
	{
		Date date=new Date();
		String systemDate_Time=date.toString();
		return systemDate_Time;
	}
	
	/**
	 * it is used to get current system date and time with the format as YYYY-MM-DD
	 * @return
	 */
	public String getSystemDate_YYYY_MM_DD()
	{
		Date date=new Date();
		String systemDate_Time=date.toString();
		System.out.println(systemDate_Time);
		String[] arr=systemDate_Time.split(" ");
		String DD=arr[2];
		String YYYY=arr[5];
		int MM=date.getMonth()+1;
		String finalFormat=YYYY+"-"+MM+"-"+DD;
		return finalFormat;	
	}

}
