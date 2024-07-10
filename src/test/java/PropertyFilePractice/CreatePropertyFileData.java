package PropertyFilePractice;

import java.io.File;
import java.io.IOException;

public class CreatePropertyFileData
{
	public static void main(String[] args) throws IOException
	{
		String propertyFilePath=System.getProperty("user.dir")+"/src/test/resources/Data/propertyFileData/propertyfile.properties";
		
		File file=new File(propertyFilePath);
		file.createNewFile();
	}
}
