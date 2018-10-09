/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gear.tools.geardata.FileFilters;

import com.gear.tools.geardata.Settings;
import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author lizhixiong
 */
public class FileFilterDesc implements FileFilter {
    
    @Override
    public boolean accept(File pathname) {
        String filename = pathname.getName().toLowerCase();
        return filename.endsWith(".desc") && (!filename.equals((Settings.CONSTANCE_FILE_NAME + ".desc").toLowerCase()));
    }
}
