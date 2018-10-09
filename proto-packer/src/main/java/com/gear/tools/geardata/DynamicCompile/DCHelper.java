/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gear.tools.geardata.DynamicCompile;

import com.gear.tools.geardata.FileFilters.FileFilterJava;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

/**
 *
 * @author lizhixiong
 */
public class DCHelper {

    private static Map<String, JavaFileObject> map = new ConcurrentHashMap<>();
    private static JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    private static List<String> options = new ArrayList<>();

    private static List<String> getOptions() {
        if (options.isEmpty()) {
            options.add("-target");
            options.add("1.8");
        }
        return options;
    }

    public static void compile(String dir) {
        System.out.println("compilePaht=" + dir);
        try {
            File rootFile = new File(dir);
            File[] files = rootFile.listFiles(new FileFilterJava());

            DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<>();
            JavaFileManager fmanager = new DCFileManager(compiler.getStandardFileManager(collector, null, null));

            List<DCFileObject> compileUnits = new ArrayList<DCFileObject>();
            for (int i = 0; i < files.length; i++) {
                File f = files[i];
                String code = readStringFromFile(f.getAbsolutePath());

                String clsName = f.getName();
                clsName = clsName.replace(".java", "");
                DCFileObject fobj = new DCFileObject(clsName, code);
                compileUnits.add(fobj);
            }
            Boolean rst = compiler.getTask(null, fmanager, collector, options, null, compileUnits).call();
            System.out.println(rst ? "编译成功" : "编译失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Class<?> loadClass(String clsName) throws ClassNotFoundException {
        DCClassLoader loader = new DCClassLoader();
        Class cls = loader.findClass(clsName);
        return cls;
    }

    public static JavaFileObject getFileObjectByName(String name) {
        return map.get(name);
    }

    public static void putFileObject(String name, JavaFileObject obj) {
        map.put(name, obj);
    }

    private static String readStringFromFile(String filePath) throws Exception {
        FileInputStream fin = new FileInputStream(filePath);
        InputStreamReader ireader = new InputStreamReader(fin);
        BufferedReader breader = new BufferedReader(ireader);
        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = breader.readLine()) != null) {
            sb.append(line);
        }
        breader.close();
        ireader.close();
        fin.close();
        return sb.toString();
    }
}
