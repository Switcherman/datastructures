package com.pctf.datastructures.tree;

import java.io.File;

public class ListFiles {
    public static String path = "/Users/lucifer/Desktop";

    public static void main(String[] args){
        File file = new File(path);
        listFiles(file, 0);
    }

    public static void listFiles(File file, int deep){
        for(int i = 0; i < deep; i++){
            System.out.print("\t");
        }
        System.out.println(file.getName());
        if(file.isDirectory()) {
            for (File f : file.listFiles()) {
                listFiles(f, deep + 1);
            }
        }
    }
}
