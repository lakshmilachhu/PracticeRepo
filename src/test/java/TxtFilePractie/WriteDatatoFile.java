package TxtFilePractie;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDatatoFile 
{
	public static void main(String[] args) throws IOException
	{
		//String filePath=System.getProperty("user.dir")+"/src/test/resources/Data/TxtFileData/TextData.txt";
		File file=new File(System.getProperty("user.dir")+"/src/test/resources/Data/TxtFileData/TextData.txt");
		
		FileWriter fw=new FileWriter(file,true);
		
		BufferedWriter bw=new BufferedWriter(fw);
		bw.newLine();
		bw.append("place=Mandya");
		bw.flush();
		
		bw.newLine();
		bw.append("pwd=lacchu");
		bw.flush();
		
		Desktop.getDesktop().browse(file.toURI());
		
	}
}
