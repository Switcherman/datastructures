package com.pctf.algorithm.swardtooffer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

 思路: 奇偶数分别放到队列中.再取回数组
 */
public class OddBeforeEven {
    public void reOrderArray(int [] array) {
        Queue<Integer> oddQueue = new PriorityQueue<>();
        Queue<Integer> evenQueue = new PriorityQueue<>();
        for(int i : array) {
            if(i % 2 == 0) {
                evenQueue.add(i);
            } else {
                oddQueue.add(i);
            }
        }
        int i = 0;
        while (!oddQueue.isEmpty()){
            array[i++] = oddQueue.remove();
        }
        while (!evenQueue.isEmpty()){
            array[i++] = evenQueue.remove();
        }
    }
}
