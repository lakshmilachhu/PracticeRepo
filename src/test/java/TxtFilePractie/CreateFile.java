package TxtFilePractie;

import java.io.File;
import java.io.IOException;

public class CreateFile 
{
	public static void main(String[] args) throws IOException
	{
		String filePath=System.getProperty("user.dir")+"/src/test/resources/Data/TxtFileData/TextData.txt";
		File file=new File(filePath);
		file.createNewFile();  //creating new file inside the TxtFileData folder
		
		
	}

}
