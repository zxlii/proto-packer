/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gear.tools.geardata.DynamicCompile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

/**
 *
 * @author lizhixiong
 */
public class DCFileObject extends SimpleJavaFileObject {

    private String source;
    private ByteArrayOutputStream outPutStream;

    public DCFileObject(String name, String source) {
        super(URI.create("String:///" + name + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
        this.source = source;
    }

    public DCFileObject(String name, JavaFileObject.Kind kind) {
        super(URI.create("String:///" + name + kind.extension), kind);
        source = null;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        return source;
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        outPutStream = new ByteArrayOutputStream();
        return outPutStream;
    }

    public byte[] getCompiledBytes() {
        return outPutStream.toByteArray();
    }
}
