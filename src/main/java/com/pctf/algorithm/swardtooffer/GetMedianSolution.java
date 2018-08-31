package com.pctf.algorithm.swardtooffer;

import java.util.LinkedList;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 思路:利用链表存储数据流.存储时进行排序.
 */
public class GetMedianSolution {

    private LinkedList<Integer> list = new LinkedList<>();

    public void Insert(Integer num) {
        if (list.size() == 0) {
            list.add(num);
            return;
        }
        if (num <= list.getFirst()) {
            list.addFirst(num);
            return;
        }
        if (num > list.getLast()) {
            list.addLast(num);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (num > list.get(i) && num <= list.get(i + 1)) {
                list.add(i + 1, num);
            }
        }

    }

    public Double GetMedian() {
        if (list.size() % 2 != 0) {
            return Double.valueOf(list.get(list.size() / 2));
        } else {
            return Double.valueOf((list.get(list.size() / 2) + list.get(list.size() / 2 - 1))) / 2;
        }
    }

}
