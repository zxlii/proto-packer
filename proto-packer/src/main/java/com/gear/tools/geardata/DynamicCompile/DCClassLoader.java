/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gear.tools.geardata.DynamicCompile;

import javax.tools.JavaFileObject;

/**
 *
 * @author lizhixiong
 */
public class DCClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        JavaFileObject fileObject = DCHelper.getFileObjectByName(name);
        if (fileObject != null) {
            byte[] bytes = ((DCFileObject) fileObject).getCompiledBytes();
            return defineClass(name, bytes, 0, bytes.length);
        }
        try {
            return ClassLoader.getSystemClassLoader().loadClass(name);
        } catch (Exception e) {
            return super.findClass(name);
        }
    }
}
