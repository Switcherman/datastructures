package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;

/**
 *把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 *例如6、8都是丑数，但14不是，因为它包含质因子7。
 *习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_SolutionSolution {
    public int GetUglyNumber_Solution(int index) {
        if(index < 7) {
            return index;
        }
        int[] arr = new int[index];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        arr[0] = 1;
        for(int i = 1; i < index; i++) {
            int min = Math.min(arr[i2] * 2, Math.min(arr[i3] * 3, arr[i5] * 5));
            arr[i] = min;
            if(min == arr[i2] * 2) {
                i2++;
            }
            if(min == arr[i3] * 3) {
                i3++;
            }
            if(min == arr[i5] * 5) {
                i5++;
            }
        }
        return arr[index - 1];
    }
}
