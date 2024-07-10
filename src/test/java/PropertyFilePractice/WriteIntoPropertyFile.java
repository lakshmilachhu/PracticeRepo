package PropertyFilePractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteIntoPropertyFile 
{
	public static void main(String[] args) throws IOException
	{
		File propertyFilePath=new File(System.getProperty("user.dir")+"/src/test/resources/Data/propertyFileData/propertyfile.properties");
		
		Properties prop=new Properties();
		
		prop.setProperty("Browser", "Chrome");
		prop.setProperty("OS","Windows10");
		prop.setProperty("Password", "moniLacchu");
		
		FileOutputStream fos=new FileOutputStream(propertyFilePath, true);
		
		prop.store(fos, "newly added data");
		
		fos.flush();
		fos.close();
		
//		Desktop.getDesktop().browse(propertyFilePath.toURI());
	
	}

}
