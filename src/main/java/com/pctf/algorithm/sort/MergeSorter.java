package com.pctf.algorithm.sort;



/**
 * 归并排序
 */
public class MergeSorter implements Sorter {

    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        if (array == null || array.length < 0) {
            return;
        }
        AnyType[] temp = (AnyType[]) new Comparable[array.length];
        mergeSort(0, array.length - 1, array, temp);
    }

    private <AnyType extends Comparable<? super AnyType>> void mergeSort(int start, int end, AnyType[] array, AnyType[] temp) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(start, middle, array, temp);
        mergeSort(middle + 1, end, array, temp);
        merge(start, middle, end, array, temp);
    }

    private <AnyType extends Comparable<? super AnyType>> void merge(int left, int leftEnd, int rightEnd, AnyType[] array, AnyType[] temp) {
        int index = left;
        int right = leftEnd + 1;
        int length = rightEnd - left;
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left].compareTo(array[right]) < 0) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }
        while (left <= leftEnd) {
            temp[index++] = array[left++];
        }
        while (right <= rightEnd) {
            temp[index++] = array[right++];
        }
        // 归并
        for (int i = length; i >= 0; i--, rightEnd--) {
            array[rightEnd] = temp[rightEnd];
        }
    }


}
