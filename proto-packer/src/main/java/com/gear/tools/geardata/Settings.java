/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gear.tools.geardata;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author lizhixiong
 */
public class Settings {

    //默认存放配置信息的文件名
    private static String ConfigName = "config.properties";
    public static String CONSTANCE_FILE_NAME = "Constance";
    private String localPath;

    //目标语言，0代表java，1代表C#，2代表lua
    private int platform;

    //protoc.exe所在目录
    private String envPath;

    //包名
    private String classPath;

    //输入路径，也就是excel存放路径
    private String inPath;

    private String outPath;

    //是否记住配置，是：下次打开后自动设置，否：当前配置是什么下次还是什么。
    private boolean isAutoRemember;
    private Properties prop;

    public Settings() {
        localPath = System.getProperty("user.dir");
        Read();
    }

    private void Read() {
        prop = new Properties();
        try {
            File configFile = new File(localPath + File.separator + ConfigName);
            if (configFile.exists()) {
                InputStream in = new BufferedInputStream(new FileInputStream(ConfigName));
                prop.load(in);
                in.close();
            }

            if (prop.containsKey("platform")) {
                this.platform = Integer.parseInt(prop.getProperty("platform"));
            }
            if (prop.containsKey("envPath")) {
                this.envPath = prop.getProperty("envPath");
            }
            if (prop.containsKey("classPath")) {
                this.classPath = prop.getProperty("classPath");
            }
            if (prop.containsKey("inPath")) {
                this.inPath = prop.getProperty("inPath");
            }
            if (prop.containsKey("outPath")) {
                this.outPath = prop.getProperty("outPath");
            }
            if (prop.containsKey("isAutoRemember")) {
                this.isAutoRemember = Boolean.parseBoolean(prop.getProperty("isAutoRemember"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Save(MainPanel frame) {

        this.envPath = frame.getEnvironmentPath();
        this.classPath = frame.getClassPath();
        this.inPath = frame.getInputPath();
        this.outPath = frame.getOutPath();

        try {
            FileOutputStream out = new FileOutputStream(ConfigName);
            prop.setProperty("platform", Integer.toString(platform));
            prop.setProperty("envPath", envPath == null ? "" : envPath);
            prop.setProperty("classPath", classPath == null ? "" : classPath);
            prop.setProperty("inPath", inPath == null ? "" : inPath);
            prop.setProperty("outPath", outPath == null ? "" : outPath);
            prop.setProperty("isAutoRemember", Boolean.toString(isAutoRemember));
            prop.store(out, Long.toString(System.currentTimeMillis()));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setInputPath(String inpath) {
        inPath = inpath;
    }

    public String getClassPath() {
        return classPath;
    }

    public String getInputPath() {
        return inPath;
    }

    public String getOutputCodePath() {
        return this.outPath + File.separator + "code";
    }

    public String getOutPath() {
        return this.outPath;
    }

    //protoc.exe所在目录
    public String getProtoEnvPath() {
        return envPath;
    }

    public String getByteFileFullName() {
        return this.outPath + File.separator + CONSTANCE_FILE_NAME + ".bytes";
    }

    public String getDescPath() {
        return outPath + File.separator + "desc";
    }

    public String getDescConstancePath() {
        return getDescPath() + File.separator + CONSTANCE_FILE_NAME + ".desc";
    }

    //proto源文件的存放目录
    public String getProtoPath() {
        return outPath + File.separator + "proto";
    }

    public String getProtoConstancePath() {
        return getProtoPath() + File.separator + CONSTANCE_FILE_NAME + ".proto";
    }

    public int getPlatform() {
        return platform;
    }

    public boolean getAutoRemember() {
        return isAutoRemember;
    }

    public String getPackageName() {
        return classPath;
    }

    public String getTargetPlatform() {
        String result = "";
        switch (this.platform) {
            case 0:
                result = "java_out";
                break;
            case 1:
                result = "csharp_out";
                break;
            case 2:
                result = "lua_out";
                break;
        }
        return result;
    }

    public void setAutoRemember(boolean auto) {
        isAutoRemember = auto;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public void setEnvironmentPath(String envPath) {
        this.envPath = envPath;
    }

    public String getEnvironmentPath() {
        return this.envPath;
    }

    public boolean CheckAllPath() {
        //检查出入路径
        if (!CheckDir(inPath)) {
            return false;
        }

        //检查目标文件路径
        CheckDir(outPath, true, false);

        //检查本地文件路径，用于存放生成过程中的desc和proto文件
        CheckDir(getProtoPath(), true, false);
        CheckDir(getDescPath(), true, false);
        CheckDir(getOutputCodePath(), true, false);

        return true;
    }

    private Boolean CheckDir(String path) {
        return CheckDir(path, false);
    }

    private Boolean CheckDir(String path, Boolean isCreate) {
        return CheckDir(path, isCreate, false);
    }

    private Boolean CheckDir(String path, Boolean isCreate, Boolean isCleanAllFiles) {

        if (path.isEmpty()) {
            System.out.print("路径为空");
            return false;
        }

        Boolean result = true;
        File file = new File(path);
        if (isCreate) {
            if (!file.exists()) {
                file.mkdir();
            }
        } else {
            if (!file.exists()) {
                System.out.print("路径没有被创建->:" + path);
                result = false;
            }
        }

        if (result && isCleanAllFiles) {
            DeleteFilesOfDirectory(file, true);
        }
        return result;
    }

    //删除所有文件
    private void DeleteFilesOfDirectory(File file, Boolean recursive) {
        if (recursive) {
            DeleteFilesOfDirectoryRecursive(file);
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    f.delete();
                }
            }
        }
    }

    private void DeleteFilesOfDirectoryRecursive(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                DeleteFilesOfDirectoryRecursive(f);
            }
        } else if (file.isFile()) {
            file.delete();
        }
    }
}
