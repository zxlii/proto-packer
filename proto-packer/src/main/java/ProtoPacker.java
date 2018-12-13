import javax.swing.*;

public class ProtoPacker
{
	public static void ShowMessage(String message,Boolean isError,Boolean isExit)
	{
		JOptionPane.showMessageDialog(null,message,"提示",isError ? 0 : 1);
		if(isExit)
		{
			Runtime.getRuntime().exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		if(args.length!=1)
		{
			ShowMessage("调用ProtoPacker工具需要传入配置文件所在路径！",true,true);
		}
		
		try
		{
			ProtoPackerConfig.Init(args[0]);
			new ProtoPackerPipeline().execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.err.println(e.getStackTrace());
		}
	}
}
