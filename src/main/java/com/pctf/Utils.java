package com.pctf;

import java.util.Random;

public class Utils {

    public static Integer[] createTestArray(int size) {
        Integer[] result = new Integer[size];
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            result[i] = random.nextInt(1000);
        }
        return result;
    }

    public static <T> void printArray(T[] array) {
        for(T item : array) {
            System.out.print(item.toString() + "\t");
        }
        System.out.println();
    }
}
