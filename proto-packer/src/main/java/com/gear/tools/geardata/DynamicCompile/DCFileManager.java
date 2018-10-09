/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gear.tools.geardata.DynamicCompile;

import java.io.IOException;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

/**
 *
 * @author lizhixiong
 */
public class DCFileManager extends ForwardingJavaFileManager<JavaFileManager> {

    protected DCFileManager(JavaFileManager fileManager) {
        super(fileManager);
    }

    @Override
    public JavaFileObject getJavaFileForInput(Location location, String className, JavaFileObject.Kind kind) throws IOException {
        JavaFileObject javaFileObject = DCHelper.getFileObjectByName(className);
        if (javaFileObject == null) {
            super.getJavaFileForInput(location, className, kind);
        }
        return javaFileObject;
    }

    @Override
    public JavaFileObject getJavaFileForOutput(Location location, String qualifiedClassName, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
        JavaFileObject javaFileObject = new DCFileObject(qualifiedClassName, kind);
        DCHelper.putFileObject(qualifiedClassName, javaFileObject);
        return javaFileObject;
    }
}
