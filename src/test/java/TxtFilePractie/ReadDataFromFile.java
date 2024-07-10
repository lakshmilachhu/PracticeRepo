package TxtFilePractie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromFile 
{
	public static String getLineDataFromTxtFile(String filePath, String key) throws IOException
	{
		File file=new File(filePath);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		
		while(line!=null)
		{
			if(line.startsWith(key))break;
			line=br.readLine();
		}
		return line;
	}
	
	public static String getValueDataFromTxtFile(String filePath, String key) throws IOException
	{
		File file=new File(filePath);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		String value="";
		
		while(line!=null)
		{
			if(line.startsWith(key))
			{
				value=line.replace(key+"=","");
				break;
			}
			line=br.readLine();
		}
		return value;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		String filePath=System.getProperty("user.dir")+"/src/test/resources/Data/TxtFileData/TextData.txt";
		String key="name";
		
		String lineData=getLineDataFromTxtFile(filePath,key);
		System.out.println(lineData);
		
		String valueData=getValueDataFromTxtFile(filePath,key);
		System.out.println(valueData);
	}

}
