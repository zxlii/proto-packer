import javax.swing.filechooser.FileSystemView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProtoPackerConfig
{
	public static String ConstFileName="Constance";
	private static Properties properties;
	private static String PathDesktop;
	
	public static void Init(String path) throws IOException
	{
		properties=new Properties();
		File fileConfig=new File(path);
		if(fileConfig.exists())
		{
			InputStream instream=new BufferedInputStream(new FileInputStream(path));
			properties.load(instream);
			instream.close();
		}
		//PathDesktop=FileSystemView.getFileSystemView().getHomeDirectory().getAbsoluteFile().getAbsolutePath();
		PathDesktop="/Users/fotoable/Others/github/proto-packer/test-files/output";
	}
	
	public static String getInputExcelPath()
	{
		return properties.getProperty("input-excel");
	}
	
	public static String getOutputCodePath()
	{
		return properties.getProperty("output-code");
	}
	
	public static String getOutputBytePath()
	{
		return properties.getProperty("output-byte");
	}
	
	public static String getOutputProtoPath()
	{
		return PathDesktop + File.separator + "proto";
	}
	
	public static String getOutputDescPath()
	{
		return PathDesktop + File.separator + "desc";
	}
	
	public static String getPackageName()
	{
		return properties.getProperty("package-name");
	}
	
	public static String getProtocPath()
	{
		return properties.getProperty("protoc");
	}
	
	public static String getConstFilePath()
	{
		return getOutputBytePath() + File.separator + ConstFileName + ".bytes";
	}
	
}
