package com.pctf.algorithm.swardtooffer;

import java.util.HashMap;
import java.util.Map;

public class FindNumsAppearOnceSolution {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length ==0) {
            return;
        }
        if(array.length == 1) {
            num1[0] = array[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : array) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int[] a = new int[array.length];
        int i = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() == 1) {
                a[i++] = e.getKey();
            }
        }
        num1[0] = a[0];
        num2[0] = a[1];
    }
}
