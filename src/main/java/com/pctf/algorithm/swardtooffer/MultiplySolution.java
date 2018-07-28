package com.pctf.algorithm.swardtooffer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * 思路:
 * 1, a1, a2,... an
 * a0,1 , a2,... an
 * a0,a1,1,a2... an
 * a0,a1,a2,1,... an-2,an-1,an
 * 以对角线分隔,先计算下半部分,再循环计算上半部分.乘积即为结果
 */
public class MultiplySolution {

    public int[] multiply(int[] A) {
        if(A == null ) {
            return null;
        }
        if(A.length == 1 || A.length == 0) {
            return A;
        }
        int[] b = new int[A.length];
        int length = A.length;
        b[0] = 1;
        for(int i = 1; i < length; i++) {
            b[i] = b[i - 1] * A [i - 1];
        }
        int temp = 1;
        for(int i = length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}
