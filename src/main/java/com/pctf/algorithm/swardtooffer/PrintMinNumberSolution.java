package com.pctf.algorithm.swardtooffer;

import java.util.*;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumberSolution {

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        List<Integer> list = new ArrayList<>();
        for(int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new FirstComparable());
        StringBuilder sb = new StringBuilder();
        list.forEach(i -> sb.append(i));
        return sb.toString();
    }

    private class FirstComparable implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 + "" + o2).compareTo(o2 + "" + o1);
        }
    }
}
