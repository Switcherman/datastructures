package com.pctf.datastructures.tree;

import java.io.File;

public class FileSize {
    public static String path = "/Users/lucifer/Desktop";
    public static void main(String[] args){
        fileSize(new File(path), 0);
    }

    public static long fileSize(File file,int deep){
        long totalSize = file.getTotalSpace();
        if(file.isDirectory()){
            for(File f : file.listFiles()){
                totalSize += fileSize(f, deep + 1);
            }
        }
        for(int i = 0; i < deep; i++){
            System.out.print("\t");
        }
        System.out.println(file.getName() + "\t" + totalSize + "b");
        return totalSize;
    }
}
