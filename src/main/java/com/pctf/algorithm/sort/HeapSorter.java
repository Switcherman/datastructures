package com.pctf.algorithm.sort;

public class HeapSorter implements Sorter {

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType[] a, int i, int n) {
        int child;
        AnyType temp;
        for (temp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if(child != n-1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
            }
            if(temp.compareTo(a[child]) < 0) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = temp;
    }

    @Override
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percDown(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            //swap
        }
    }
}
