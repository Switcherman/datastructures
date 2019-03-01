package com.pctf.algorithm.sort;

/**
 * 快排
 * 1.切分元素
 * 2.递归调用
 */
public class QuickSorter implements Sorter {

    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(array, start, end);
        quickSort(array, start, partition - 1);
        quickSort(array, partition + 1, end);
    }

    private <AnyType extends Comparable<? super AnyType>> int partition(AnyType[] array, int start, int end) {
        int i = start;
        int j = end + 1;
        AnyType v = array[start];
        while (true) {
            while (array[++i].compareTo(v) < 0) {
                if (i == end) break;
            }
            while (v.compareTo(array[--j]) < 0) {
                if (j == start) break;
            }
            if (i >= j) break;
            swap(array, i, j);
        }
        swap(array, start, j);
        return j;
    }

    private <AnyType extends Comparable<? super AnyType>> void swap(AnyType[] array, int i, int j) {
        AnyType temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
