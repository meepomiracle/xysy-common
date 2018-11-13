package com.xysy.common.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtil {

    public static void mergeSubDir(String rootPath) throws IOException {
        File rootDir = new File(rootPath);
        File mergeDir = new File(rootDir.getParentFile().getPath()+"\\merge");
        mergeDir.mkdirs();
        if(rootDir.isDirectory()){
            File[] subDirs=rootDir.listFiles();

            for(File subDir:subDirs){
                File[] files = subDir.listFiles();
                String subDirName=subDir.getName();
                for(File file:files){
                    String fileName = file.getName();
                    String newName= mergeDir.getPath()+ "\\" + subDirName+"-"+fileName;
                    File newFile = new File(newName);
//                    file.renameTo(newFile);
                    Files.copy(file.toPath(),newFile.toPath());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String rootPath="F:\\迅雷下载\\hm\\[3D]校園奴隸契約 1-72+番外篇[汉化]\\TT⒊一75\\[3D]校園奴隸契約 1-72+番外篇[汉化]\\1-72 [完結]";
        mergeSubDir(rootPath);
    }
}
