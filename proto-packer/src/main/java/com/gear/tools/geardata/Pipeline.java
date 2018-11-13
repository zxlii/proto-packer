/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gear.tools.geardata;

import com.gear.tools.geardata.FileFilters.FileFilterDesc;
import com.gear.tools.geardata.FileFilters.FileFilterExcel;
import com.gear.tools.geardata.FileFilters.FileFilterProto;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author lizhixiong
 */
public class Pipeline {

    final private static String ProtoPropTemp = "\t//%s\n\t%s %s = %s;\n";
    final private HashMap<String, Sheet> map;
    final private Settings setting;

    public Pipeline(Settings setting) {
        this.setting = setting;
        map = new HashMap();
    }

    public void start() {
        try {

            readexcel();
            excel2proto2desc();

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    try {
                        exceldesc2bytes();
                        proto2code();
                        cancel();
                        MainPanel.GetInstance().onComplete();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            Timer timer = new Timer();
            timer.schedule(task, 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        map.clear();
    }

    /**
     * 利用poi库读取excel文件
     *
     * @author lizhixiong
     */
    private void readexcel() throws Exception {
        String fileFullPath = setting.getInputPath();
        File rootFile = new File(fileFullPath);
        File[] files = rootFile.listFiles(new FileFilterExcel());

        for (File f : files) {
            String fileName = f.getName().split("\\.")[0];
            String absolutePath = f.getAbsolutePath();
            boolean isE2007 = absolutePath.endsWith("xlsx");

            if (!f.canRead()) {
                JOptionPane.showMessageDialog(null, "文件是否正在被使用？" + absolutePath);
                System.exit(0);
                break;
            }

            FileInputStream input = new FileInputStream(absolutePath);

            Sheet sheet;
            if (isE2007) {
                sheet = new XSSFWorkbook(input).getSheetAt(0);
            } else {
                sheet = new HSSFWorkbook(input).getSheetAt(0);
            }
            map.put(fileName, sheet);
            input.close();
        }
    }

    /**
     * 把通过excel生成proto文件 然后调用protoc命令行生成desc文件
     *
     * @author lizhixiong
     */
    private void excel2proto2desc() throws Exception {
        String protoPath = setting.getProtoPath();
        String genPackageName = setting.getPackageName();

        //生成proto文件
        StringBuilder sb = new StringBuilder();
        sb.append("syntax = \"proto3\";\n");
        if (!genPackageName.isEmpty()) {
            sb.append("package ").append(genPackageName).append(";\n");
        }
        for (String key : map.keySet()) {
            sb.append("import \"").append("Data" + key).append(".proto\";\n");
        }
        sb.append("message ").append(Settings.CONSTANCE_FILE_NAME).append("\n");
        sb.append("{\n");
        int index = 1;
        for (String key : map.keySet()) {
            String fieldName = getMasterFieldName(key);
            sb.append("\t").append("repeated ").append("Data" + key).append(" ").append(fieldName).append(" = ").append(index++)
                    .append(";\n");
        }
        sb.append("}");

        FileOutputStream out;
        out = new FileOutputStream(setting.getProtoConstancePath());
        out.write(sb.toString().getBytes("utf-8"));
        out.close();

        for (String key : map.keySet()) {
            Sheet sheet = map.get(key);
            String fileName = "Data" + key;
            Row types = sheet.getRow(0);
            Row names = sheet.getRow(1);
            Row instructions = sheet.getRow(2);

            sb = new StringBuilder();
            sb.append("syntax = \"proto3\";\n");
            if (!genPackageName.isEmpty()) {
                sb.append("package ").append(genPackageName).append(";\n");
            }
            sb.append("message ").append(fileName).append("\n");
            sb.append("{\n");

            for (int i = 0; i < types.getPhysicalNumberOfCells(); i++) {
                String type = types.getCell(i).getStringCellValue();
                String name = names.getCell(i).getStringCellValue();
                String ins = instructions.getCell(i).getStringCellValue();
                if (name == null || name.isEmpty() || type == null || type.isEmpty()) {
                    continue;
                }
                sb.append(String.format(ProtoPropTemp, ins, type, name, i + 1));
            }
            sb.append("}");

            out = new FileOutputStream(protoPath + "/" + fileName + ".proto");
            out.write(sb.toString().getBytes("utf-8"));
            out.close();
        }

        //生成用来动态编译的proto desc文件
        String cmdTemp = "%s -I=%s --descriptor_set_out=%s %s";
        String protocPath = setting.getProtoEnvPath();
        String descPath = setting.getDescPath();
        File rootFile = new File(protoPath);
        File[] files = rootFile.listFiles(new FileFilterProto());
        for (File file : files) {
            String protoFullPath = file.getAbsolutePath();
            String protoName = file.getName();
            String desc = descPath + File.separator + protoName.replace(".proto", ".desc");
            String cmd = String.format(cmdTemp, protocPath, protoPath, desc, protoFullPath);
            Runtime.getRuntime().exec(cmd);
        }

        String protoFullPath = setting.getProtoConstancePath();
        String protoName = "Constance.proto";
        String desc = setting.getDescPath() + File.separator + protoName.replace(".proto", ".desc");
        String cmd = String.format(cmdTemp, protocPath, protoPath, desc, protoFullPath);
        Runtime.getRuntime().exec(cmd);
    }

    /**
     * 用protobuf提供的API动态编译desc，然后把excel中的数据填进去，最终生成.bytes二进制文件
     *
     * @author lizhixiong
     */
    private void exceldesc2bytes() throws Exception {

        HashMap<File, Descriptors.FileDescriptor> descMap = new HashMap<>();
        File rootFile = new File(setting.getDescPath());
        File[] files = rootFile.listFiles(new FileFilterDesc());
        for (File curFile : files) {
            Descriptors.FileDescriptor desc = getDescriptorByPath(curFile.getAbsolutePath());
            descMap.put(curFile, desc);
        }

        Descriptors.FileDescriptor[] depends = new Descriptors.FileDescriptor[descMap.values().size()];
        Descriptors.Descriptor rootDesc = getDescriptorByPath(setting.getDescConstancePath(), descMap.values().toArray(depends)).getMessageTypes().get(0);
        DynamicMessage.Builder builder = DynamicMessage.newBuilder(rootDesc);

        for (File file : descMap.keySet()) {

            String fileName = file.getName().replace("Data", "").split("\\.")[0];
            Sheet sheet = map.get(fileName);
            if (sheet == null) {
                System.out.println(fileName);
            }
            Row names = sheet.getRow(1);
            int maxRow = sheet.getPhysicalNumberOfRows();

//          reference : https://blog.csdn.net/lufeng20/article/details/8736584
            Descriptors.Descriptor descriptor = descMap.get(file).getMessageTypes().get(0);
            DynamicMessage.Builder dynamicBuilder = DynamicMessage.newBuilder(descriptor);
            String mfieldName = getMasterFieldName(fileName);
            Descriptors.FieldDescriptor mfield = rootDesc.findFieldByName(mfieldName);
            if (mfield == null) {
                System.out.println("The constance field '" + mfieldName + "' can't be found.");
                break;
            }

            for (int row = 3; row < maxRow; row++) {
                DynamicMessage msg = buildItem(descriptor, dynamicBuilder, names, sheet.getRow(row));
                if (msg != null) {
                    builder.addRepeatedField(mfield, msg);
                } else {
                    System.out.println("null message :: index=" + row);
                }
            }
        }

        DynamicMessage constance = builder.build();
        FileOutputStream out = new FileOutputStream(setting.getByteFileFullName());
        out.write(constance.toByteArray());
        out.close();

        builder.clear();
    }

    /**
     * 生成目标平台的代码
     *
     * @author lizhixiong
     */
    private void proto2code() throws Exception {
        String protocPath = setting.getProtoEnvPath();
        //proto源文件的存放目录
        String param1 = "-I=" + setting.getProtoPath();
        //生成后的代码存放目录
        String param2 = "--" + setting.getTargetPlatform() + "=" + setting.getOutputCodePath();
        //需要生成的proto文件目录
        String param3 = "";
        String path = setting.getProtoPath();
        File rootFile = new File(path);
        File[] files = rootFile.listFiles(new FileFilterProto());
        for (int i = 0; i < files.length; i++) {
            param3 += files[i].getAbsolutePath();
            if (i < files.length - 1) {
                param3 += " ";
            }
        }
        String cmdTemp = "%s %s %s %s";
        String cmd = String.format(cmdTemp, protocPath, param1, param2, param3);
        Runtime.getRuntime().exec(cmd);
    }

    /**
     * 把单个excel文件的一条数据构建成一条proto message
     *
     * @author lizhixiong
     */
    private DynamicMessage buildItem(Descriptors.Descriptor desc, DynamicMessage.Builder builder, Row temp, Row content) {

        builder.clear();
        List<Descriptors.FieldDescriptor> fields = desc.getFields();
        for (Descriptors.FieldDescriptor fieldDesc : fields) {

            String fieldName = fieldDesc.getName();
            String valueInString = null;
            for (int j = 0; j < temp.getPhysicalNumberOfCells(); j++) {
                Cell tcell = temp.getCell(j);
                Cell ccell = content.getCell(j);
                if (tcell.getCellTypeEnum() != CellType.STRING) {
                    tcell.setCellType(CellType.STRING);
                }
                if (ccell.getCellTypeEnum() != CellType.STRING) {
                    ccell.setCellType(CellType.STRING);
                }
                String varName = tcell.getStringCellValue();
                if (fieldName.equals(varName)) {
                    valueInString = ccell.getStringCellValue();
                    break;
                }
            }
            if (valueInString == null || valueInString.isEmpty()) {
                System.out.println(String.format("The field name '%s' can't be found in '%s',id is '%s'.", fieldName, desc.getFullName(), content.getRowNum() + 1));
            }
            Descriptors.FieldDescriptor fdesc = desc.findFieldByName(fieldName);
            try {
                Object obj = getObject(valueInString, fdesc.getJavaType());
                builder.setField(fdesc, obj);
            } catch (Exception e) {
                System.out.println(fieldName);
                System.out.println(valueInString);
            }

        }
        return builder.build();
    }

    private DynamicMessage buildItem(Descriptors.Descriptor desc, DynamicMessage.Builder builder, Row temp, Sheet sheet, int row) {

        builder.clear();
        Row content = sheet.getRow(row);
        List<Descriptors.FieldDescriptor> fields = desc.getFields();

        for (Descriptors.FieldDescriptor fieldDesc : fields) {

            String fieldName = fieldDesc.getName();
            String propValue = null;
            String propName = null;
            for (int j = 0; j < temp.getPhysicalNumberOfCells(); j++) {

                Cell tcell = temp.getCell(j);
                if (tcell.getCellTypeEnum() != CellType.STRING) {
                    tcell.setCellType(CellType.STRING);
                }

                Cell ccell = content.getCell(j);
                if (ccell.getCellTypeEnum() != CellType.STRING) {
                    ccell.setCellType(CellType.STRING);
                }

                propName = tcell.getStringCellValue();
                if (fieldName.equals(propName)) {
                    propValue = ccell.getStringCellValue();
                    break;
                }
            }

            if (propValue == null || propValue.isEmpty()) {
                System.out.println(String.format("The field name '%s' can't be found in '%s',id is '%s'.", fieldName, desc.getFullName(), content.getRowNum() + 1));
                continue;
            }

            Descriptors.FieldDescriptor fdesc = desc.findFieldByName(fieldName);
            try {
                Object obj = getObject(propValue, fdesc.getJavaType());
                builder.setField(fdesc, obj);
            } catch (Exception e) {
                System.out.println(fieldName);
                System.out.println(propValue);
            }

        }
        return builder.build();
    }

    private static Object getObject(String rawString, Descriptors.FieldDescriptor.JavaType type) {
        try {
            switch (type) {
                case INT:
                    return Integer.valueOf(rawString);
                case LONG:
                    return Long.valueOf(rawString);
                case FLOAT:
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
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getMasterFieldName(String key) {
        String fl = key.substring(0, 1).toLowerCase();
        String keyName = fl + key.substring(1);
        return keyName + "List";
    }

    private Descriptors.FileDescriptor getDescriptorByPath(String path) throws Exception {
        return getDescriptorByPath(path, new Descriptors.FileDescriptor[]{});
    }

    private Descriptors.FileDescriptor getDescriptorByPath(String path, Descriptors.FileDescriptor[] depends) throws Exception {
        FileInputStream input = new FileInputStream(path);
        DescriptorProtos.FileDescriptorSet sets = DescriptorProtos.FileDescriptorSet.parseFrom(input);
        DescriptorProtos.FileDescriptorProto mfdp = sets.getFile(0);
        Descriptors.FileDescriptor result = Descriptors.FileDescriptor.buildFrom(mfdp, depends);
//        Descriptor result = mfd.getMessageTypes().get(0);
        input.close();
        return result;
    }
}
