import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.DynamicMessage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ProtoPackerPipeline
{
	final private String inputExcelPath;
	final private String outputCodePath;
	final private String outputBytePath;
	final private String outputProtoPath;
	final private String outputDescPath;
	final private String packageName;
	final private String outputConstFilePath;
	final private String pathProtoc;
	final private String constFileName;
	
	final private HashMap<String,Sheet> excelMap;
	
	public ProtoPackerPipeline()
	{
		inputExcelPath=ProtoPackerConfig.getInputExcelPath();
		outputCodePath=ProtoPackerConfig.getOutputCodePath();
		outputBytePath=ProtoPackerConfig.getOutputBytePath();
		outputProtoPath=ProtoPackerConfig.getOutputProtoPath();
		outputDescPath=ProtoPackerConfig.getOutputDescPath();
		packageName=ProtoPackerConfig.getPackageName();
		outputConstFilePath=ProtoPackerConfig.getConstFilePath();
		pathProtoc=ProtoPackerConfig.getProtocPath();
		constFileName=ProtoPackerConfig.ConstFileName;
		
		excelMap=new HashMap<String,Sheet>();
	}
	
	public void execute() throws Exception
	{
		checkPath();
		readExcel();
		//writeProto();
		generateDesc();
		
		//TimerTask task = new TimerTask() {
		//	@Override
		//	public void run() {
		//		try {
		//
		//
		//			writeBytes();
		//			generateCode();
		//
		//			cancel();
		//			ProtoPacker.ShowMessage("完成！",false,true);
		//
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			ProtoPacker.ShowMessage("失败！",true,true);
		//		}
		//	}
		//};
		//
		//Timer timer = new Timer();
		//timer.schedule(task, 1000);
	}
	
	private void checkPath() throws IOException
	{
		File file=new File(inputExcelPath);
		if(!file.exists())
		{
			ProtoPacker.ShowMessage("输入路径不存在！",true,true);
		}
		
		file=new File(pathProtoc);
		if(!file.exists())
		{
			ProtoPacker.ShowMessage("无法找到protoc环境！",true,true);
		}
		
		file=new File(outputCodePath);
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		file=new File(outputBytePath);
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		file=new File(outputProtoPath);
		if(!file.exists())
		{
			System.out.println(outputProtoPath);
			file.createNewFile();
		}
		
		file=new File(outputDescPath);
		if(!file.exists())
		{
			file.createNewFile();
		}
	}
	
	private void readExcel() throws Exception
	{
		File fileRoot=new File(inputExcelPath);
		File[] files=fileRoot.listFiles(new FileFilterExcel());
		for(File f : files)
		{
			String fileName=f.getName().split("\\.")[0];
			String absolutePath=f.getAbsolutePath();
			boolean isE2007=absolutePath.endsWith("xlsx");
			
			if(!f.canRead())
			{
				ProtoPacker.ShowMessage("文件是否正在被使用？" + f.getName(),true,true);
				continue;
			}
			
			FileInputStream input=new FileInputStream(absolutePath);
			
			Sheet sheet=WorkbookFactory.create(f).getSheetAt(0);
			
			//Sheet sheet=isE2007 ? new XSSFWorkbook(input).getSheetAt(0) : new HSSFWorkbook(input).getSheetAt(0);
			
			excelMap.put(fileName,sheet);
			input.close();
		}
	}
	
	private void writeProto() throws IOException
	{
		StringBuilder builder=new StringBuilder();
		builder.append("syntax = \"proto3\";\n");
		if(!packageName.isEmpty())
		{
			builder.append("package ").append(packageName).append(";\n");
		}
		for(String key : excelMap.keySet())
		{
			builder.append("import \"").append("Data" + key).append(".proto\";\n");
		}
		builder.append("message ").append(constFileName).append("\n");
		builder.append("{\n");
		int index=1;
		for(String key : excelMap.keySet())
		{
			String fieldName=getMasterFieldName(key);
			builder.append("\t").append("repeated ").append("Data" + key).append(" ").append(fieldName).append(" = ").append(index++).append(";\n");
		}
		builder.append("}");
		
		FileOutputStream out;
		String protoConstFilePath=outputProtoPath + File.separator + constFileName + ".proto";
		out=new FileOutputStream(protoConstFilePath);
		out.write(builder.toString().getBytes("utf-8"));
		out.close();
		
		for(String key : excelMap.keySet())
		{
			
			Sheet sheet=excelMap.get(key);
			String fileName="Data" + key;
			
			Row types=sheet.getRow(0);
			Row names=sheet.getRow(1);
			Row instructions=sheet.getRow(2);
			
			builder=new StringBuilder();
			builder.append("syntax = \"proto3\";\n");
			if(!packageName.isEmpty())
			{
				builder.append("package ").append(packageName).append(";\n");
			}
			builder.append("message ").append(fileName).append("\n");
			builder.append("{\n");
			
			for(int i=0;i<types.getPhysicalNumberOfCells();i++)
			{
				Cell typeCell=types.getCell(i);
				Cell nameCell=names.getCell(i);
				if(typeCell!=null && nameCell!=null)
				{
					String type=typeCell.getStringCellValue().trim();
					String name=nameCell.getStringCellValue().trim();
					String ins=instructions.getCell(i).getStringCellValue();
					if(name!=null && !name.isEmpty() && type!=null && !type.isEmpty())
					{
						builder.append(String.format("\t//%s\n\t%s %s = %s;\n",ins,type,name,i + 1));
					}
				}
			}
			builder.append("}");
			
			out=new FileOutputStream(outputProtoPath + File.separator + fileName + ".proto");
			out.write(builder.toString().getBytes("utf-8"));
			out.close();
		}
	}
	
	private void generateDesc() throws IOException
	{
		String cmdTemp="%s -I=%s --descriptor_set_out=%s %s";
		File rootFile=new File(outputProtoPath);
		File[] files=rootFile.listFiles(new FileFilterProto());
		for(File file : files)
		{
			String protoFullPath=file.getAbsolutePath();
			String protoName=file.getName();
			String desc=outputDescPath + File.separator + protoName.replace(".proto",".desc");
			String cmd=String.format(cmdTemp,pathProtoc,outputProtoPath,desc,protoFullPath);
			System.out.println(cmd);
			Runtime.getRuntime().exec(cmd);
		}
		
		//String constProtoFullPath=outputProtoPath + File.separator + constFileName + ".proto";
		//String constDescFullPath=outputDescPath + File.separator + constFileName + ".desc";
		//String cmd=String.format(cmdTemp,pathProtoc,outputProtoPath,constDescFullPath,constProtoFullPath);
		//System.out.println(cmd);
		//Runtime.getRuntime().exec(cmd);
	}
	
	private void writeBytes() throws Exception
	{
		HashMap<File,Descriptors.FileDescriptor> descMap=new HashMap<File,Descriptors.FileDescriptor>();
		File rootFile=new File(outputDescPath);
		File[] files=rootFile.listFiles(new FileFilterDesc());
		for(File curFile : files)
		{
			Descriptors.FileDescriptor desc=getDescriptorByPath(curFile.getAbsolutePath());
			descMap.put(curFile,desc);
		}
		
		Descriptors.FileDescriptor[] depends=new Descriptors.FileDescriptor[descMap.values().size()];
		String outConstDescPath=outputDescPath + File.separator + constFileName + ".desc";
		Descriptors.Descriptor rootDesc=getDescriptorByPath(outConstDescPath,descMap.values().toArray(depends)).getMessageTypes().get(0);
		DynamicMessage.Builder builder=DynamicMessage.newBuilder(rootDesc);
		
		for(File file : descMap.keySet())
		{
			String fileName=file.getName();
			fileName=fileName.split("\\.")[0];
			fileName=fileName.substring(4);
			Sheet sheet=excelMap.get(fileName);
			if(sheet==null)
			{
				System.out.println(fileName);
			}
			Row types=sheet.getRow(0);
			Row names=sheet.getRow(1);
			
			int maxRow=sheet.getPhysicalNumberOfRows();
			
			//          reference : https://blog.csdn.net/lufeng20/article/details/8736584
			Descriptors.Descriptor descriptor=descMap.get(file).getMessageTypes().get(0);
			DynamicMessage.Builder dynamicBuilder=DynamicMessage.newBuilder(descriptor);
			String mfieldName=getMasterFieldName(fileName);
			FieldDescriptor mfield=rootDesc.findFieldByName(mfieldName);
			if(mfield==null)
			{
				System.out.println("The constance field '" + mfieldName + "' can't be found.");
				break;
			}
			List<Integer> list=new ArrayList<Integer>();
			for(int row=3;row<maxRow;row++)
			{
				DynamicMessage msg=buildItem(descriptor,dynamicBuilder,types,names,sheet.getRow(row));
				if(msg!=null)
				{
					
					Map<FieldDescriptor,Object> map=dynamicBuilder.getAllFields();
					for(FieldDescriptor fd : map.keySet())
					{
						if(fd.getName().equals("id"))
						{
							Integer id=(Integer)map.get(fd);
							if(list.contains(id))
							{
								addMessage("重复的Id：" + id.toString());
							}
							else
							{
								builder.addRepeatedField(mfield,msg);
								list.add(id);
							}
						}
					}
					
				}
				else
				{
					addMessage("null message :: name=" + fileName + ",index=" + row);
				}
			}
		}
		
		DynamicMessage constance=builder.build();
		FileOutputStream out=new FileOutputStream(outputConstFilePath);
		out.write(constance.toByteArray());
		out.close();
		
		builder.clear();
	}
	
	private void generateCode() throws IOException
	{
		
		//proto源文件的存放目录
		String param1="-I=" + outputProtoPath;
		//生成后的代码存放目录
		String param2="--" + outputCodePath;
		//需要生成的proto文件目录
		String param3="";
		String path=outputProtoPath;
		File rootFile=new File(path);
		File[] files=rootFile.listFiles(new FileFilterProto());
		for(int i=0;i<files.length;i++)
		{
			param3+=files[i].getAbsolutePath();
			if(i<files.length - 1)
			{
				param3+=" ";
			}
		}
		String cmdTemp="%s %s %s %s";
		String cmd=String.format(cmdTemp,pathProtoc,param1,param2,param3);
		System.out.println(cmd);
		Runtime.getRuntime().exec(cmd);
	}
	
	
	private String getMasterFieldName(String key)
	{
		String fl=key.substring(0,1).toLowerCase();
		String keyName=fl + key.substring(1);
		return keyName + "List";
	}
	
	/**
	 * 把单个excel文件的一条数据构建成一条proto message
	 *
	 * @author lizhixiong
	 */
	private DynamicMessage buildItem(Descriptors.Descriptor desc,DynamicMessage.Builder builder,Row types,Row names,Row content)
	{
		
		builder.clear();
		List<FieldDescriptor> fields=desc.getFields();
		for(FieldDescriptor fieldDesc : fields)
		{
			
			String fieldName=fieldDesc.getName();
			String valueInString="";
			
			for(int j=0;j<types.getPhysicalNumberOfCells();j++)
			{
				
				Cell typeCell=types.getCell(j);
				Cell nameCell=names.getCell(j);
				
				if(typeCell!=null && nameCell!=null)
				{
					
					String type=typeCell.getStringCellValue().trim();
					String name=nameCell.getStringCellValue().trim();
					
					if(type!=null && !type.isEmpty() && name!=null && !name.isEmpty())
					{
						Cell contentCell=content.getCell(j);
						if(contentCell!=null)
						{
							if(contentCell.getCellTypeEnum()!=CellType.STRING)
							{
								contentCell.setCellType(CellType.STRING);
							}
							valueInString=contentCell.getStringCellValue().trim();
						}
						else
						{
							valueInString="";
						}
						if(fieldName.equals(name))
						{
							break;
						}
					}
				}
			}
			
			try
			{
				Object obj=getObject(valueInString,fieldDesc.getJavaType());
				builder.setField(fieldDesc,obj);
			}
			catch(Exception e)
			{
				System.out.println(fieldName);
				System.out.println(valueInString);
			}
			
		}
		return builder.build();
	}
	
	private DynamicMessage buildItem(Descriptors.Descriptor desc,DynamicMessage.Builder builder,Row temp,Sheet sheet,int row)
	{
		
		builder.clear();
		Row content=sheet.getRow(row);
		List<FieldDescriptor> fields=desc.getFields();
		
		for(FieldDescriptor fieldDesc : fields)
		{
			
			String fieldName=fieldDesc.getName();
			String propValue=null;
			String propName=null;
			for(int j=0;j<temp.getPhysicalNumberOfCells();j++)
			{
				
				Cell tcell=temp.getCell(j);
				if(tcell.getCellTypeEnum()!=CellType.STRING)
				{
					tcell.setCellType(CellType.STRING);
				}
				
				Cell ccell=content.getCell(j);
				if(ccell.getCellTypeEnum()!=CellType.STRING)
				{
					ccell.setCellType(CellType.STRING);
				}
				
				propName=tcell.getStringCellValue();
				if(fieldName.equals(propName))
				{
					propValue=ccell.getStringCellValue();
					break;
				}
			}
			
			if(propValue==null || propValue.isEmpty())
			{
				System.out.println(String.format("The field name '%s' can't be found in '%s',id is '%s'.",fieldName,desc.getFullName(),content.getRowNum() + 1));
				continue;
			}
			
			Descriptors.FieldDescriptor fdesc=desc.findFieldByName(fieldName);
			try
			{
				Object obj=getObject(propValue,fdesc.getJavaType());
				builder.setField(fdesc,obj);
			}
			catch(Exception e)
			{
				System.out.println(fieldName);
				System.out.println(propValue);
			}
			
		}
		return builder.build();
	}
	
	private static Object getObject(String rawString,JavaType type)
	{
		try
		{
			switch(type)
			{
				
				case INT:
					return Integer.valueOf(rawString);
				case LONG:
					return Long.valueOf(rawString);
				case FLOAT:
					if(!rawString.endsWith("f"))
					{
						rawString+="f";
					}
					return Float.valueOf(rawString);
				case DOUBLE:
					return Double.valueOf(rawString);
				case BOOLEAN:
					return Boolean.valueOf(rawString);
				case STRING:
					return rawString;
				default:
					// BYTE_STRING, ENUM, MESSAGE                     哈哈先支持以上这些啦
					return null;
			}
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	private Descriptors.FileDescriptor getDescriptorByPath(String path) throws Exception
	{
		
		return getDescriptorByPath(path,new Descriptors.FileDescriptor[]{});
	}
	
	private Descriptors.FileDescriptor getDescriptorByPath(String path,Descriptors.FileDescriptor[] depends) throws Exception
	{
		FileInputStream input=new FileInputStream(path);
		DescriptorProtos.FileDescriptorSet sets=DescriptorProtos.FileDescriptorSet.parseFrom(input);
		DescriptorProtos.FileDescriptorProto mfdp=sets.getFile(0);
		Descriptors.FileDescriptor result=Descriptors.FileDescriptor.buildFrom(mfdp,depends);
		//        Descriptor result = mfd.getMessageTypes().get(0);
		input.close();
		return result;
	}
	
	private void addMessage(String msg)
	{
		//log.append(msg).append("\n");
	}
}
