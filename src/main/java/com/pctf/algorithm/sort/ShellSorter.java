package com.pctf.algorithm.sort;

public class ShellSorter implements Sorter {
    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        if(array == null) {
            return;
        }
        for(int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j;
                AnyType temp = array[i];
                for(j = i; j >= gap && temp.compareTo(array[j - gap]) < 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}
