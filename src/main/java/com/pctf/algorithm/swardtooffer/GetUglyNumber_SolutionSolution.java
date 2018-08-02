package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;

/**
 *把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 *例如6、8都是丑数，但14不是，因为它包含质因子7。
 *习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_SolutionSolution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while(list.size() < index) {
            int min = Math.min(2 * list.get(index2), Math.min(3 * list.get(index3), 5 * list.get(index5)));
            list.add(min);
            if(min == 2 * list.get(index2)) {
                index2++;
            } else if (min == 3 * list.get(index3)) {
                index3++;
            } else {
                index5++;
            }
        }
        return list.get(index - 1);
    }
}
