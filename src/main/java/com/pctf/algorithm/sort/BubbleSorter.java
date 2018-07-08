package com.pctf.algorithm.sort;


public class BubbleSorter implements Sorter {

    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        if(array == null) {
            return;
        }
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[j].compareTo(array[i]) < 0){
                    AnyType temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}
