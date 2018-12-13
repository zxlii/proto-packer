/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author lizhixiong
 */
public class FileFilterNotExcel implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        String filename = pathname.getName().toLowerCase();
        return (!filename.endsWith("xls")) && (!filename.endsWith("xlsx"));
    }
}
