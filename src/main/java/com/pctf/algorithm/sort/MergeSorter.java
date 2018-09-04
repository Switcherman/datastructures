package com.pctf.algorithm.sort;

/**
 * 归并排序
 */
public class MergeSorter implements Sorter {

    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        if (array == null) {
            return;
        }
        AnyType[] tempArr = (AnyType[]) new Comparable[array.length];
        mergeSort(0, array.length - 1, array, tempArr);
    }

    private <AnyType extends Comparable<? super AnyType>> void mergeSort(int left, int right, AnyType[] array, AnyType[] tempArr) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle, array, tempArr);
            mergeSort(middle + 1, right, array, tempArr);
            merge(left, middle + 1, right, array, tempArr);
        }
    }


    private <AnyType extends Comparable<? super AnyType>> void merge(int leftPos, int rightPos, int rightEnd, AnyType[] array, AnyType[] tempArr) {
        int elements = rightEnd - leftPos + 1;
        int tempPos = leftPos;
        int leftEnd = rightPos - 1;
        // 归并排序
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos].compareTo(array[rightPos]) <= 0) {
                tempArr[tempPos++] = array[leftPos++];
            } else {
                tempArr[tempPos++] = array[rightPos++];
            }
        }
        // 剩余元素填到临时数组
        while (leftPos <= leftEnd) {
            tempArr[tempPos++] = array[leftPos++];
        }
        // 剩余元素填到临时数组
        while (rightPos <= rightEnd) {
            tempArr[tempPos++] = array[rightPos++];
        }
        // 排序好的临时数组元素回填原数组
        for (int i = 0; i < elements; i++, rightEnd--) {
            array[rightEnd] = tempArr[rightEnd];
        }
    }
}
