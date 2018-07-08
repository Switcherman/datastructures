package com.pctf.algorithm.sort;

import java.util.Arrays;

public class InsertionSort implements Sorter {
    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        if(array == null) {
            return;
        }
        for( int i=0; i<array.length-1; i++ ) {
            for( int j=i+1; j>0; j-- ) {
                if( array[j-1].compareTo(array[j]) < 0) {
                    break;
                }
                AnyType temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
            }
        }
    }
}
