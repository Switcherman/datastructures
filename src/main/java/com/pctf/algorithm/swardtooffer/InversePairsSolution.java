package com.pctf.algorithm.swardtooffer;

/**
 *在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 思路:归并排序.交换数组位置的差即为逆序对的个数.
 */
public class InversePairsSolution {

    private int count = 0;

    public int InversePairs(int[] array) {
        if (array == null) {
            return 0;
        }
        int[] tempArr = new int[array.length];
        mergeCount(0, array.length - 1, tempArr, array);
        return count;
    }

    private void mergeCount(int left, int right, int[] tempArr, int[] array) {
        if(left < right) {
            int middle = (left + right) / 2;
            mergeCount(left, middle, tempArr, array);
            mergeCount(middle + 1, right, tempArr, array);
            merge(left, middle + 1, right, tempArr, array);
        }
    }

    private void merge(int leftPos, int rightPos, int rightEnd, int[] tempArr, int[] array) {
        int elements = rightEnd - leftPos + 1;
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos] <= array[rightPos]) {
                tempArr[tempPos++] = array[leftPos++];
            } else {
                tempArr[tempPos++] = array[rightPos++];
                count += leftEnd - leftPos + 1;
                count %= 1000000007;
            }
        }
        while (leftPos <= leftEnd) {
            tempArr[tempPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tempArr[tempPos++] = array[rightPos++];
        }
        for (int i = 0; i < elements; i++, rightEnd--) {
            array[rightEnd] = tempArr[rightEnd];
        }
    }
}
