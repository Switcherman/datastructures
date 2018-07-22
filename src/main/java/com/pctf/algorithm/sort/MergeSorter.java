package com.pctf.algorithm.sort;

public class MergeSorter implements Sorter {
    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        AnyType[] tempArray = (AnyType[]) new Comparable[array.length];

        mergeSort(array, tempArray, 0, array.length - 1);
    }

    private <AnyType extends Comparable<? super AnyType>> void
    mergeSort(AnyType[] array, AnyType[] tempArray, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, tempArray, left, middle);
            mergeSort(array, tempArray, middle + 1, right);
            merge(array, tempArray, left, middle + 1, right);
        }
    }

    private <AnyType extends Comparable<? super AnyType>> void
    merge(AnyType[] array, AnyType[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int tempPos = leftPos;
        int leftEnd = rightPos - 1;
        int elements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos].compareTo(array[rightPos]) <= 0) {
                tempArray[tempPos++] = array[leftPos++];
            } else {
                tempArray[tempPos++] = array[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {
            tempArray[tempPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tempArray[tempPos++] = array[rightPos++];
        }
        for (int i = 0; i < elements; i++, rightEnd--) {
            array[rightEnd] = tempArray[rightEnd];
        }
    }
}
