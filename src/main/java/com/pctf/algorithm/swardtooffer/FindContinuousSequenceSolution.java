package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class FindContinuousSequenceSolution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum < 3) {
            return result;
        }
        int middle = sum / 2 + 1;
        out : for(int i = 1; i < middle; i++) {
            int temp = i;
            for(int j = i + 1; j <= middle; j++) {
                temp += j;
                if(temp == sum) {
                    addToList(i, j, result);
                } else if (temp > sum) {
                    continue out;
                }
            }
        }
        return result;
    }

    public void addToList(int start, int end, ArrayList<ArrayList<Integer>> list) {
        ArrayList<Integer> a = new ArrayList<>();
        while(start <= end) {
            a.add(start++);
        }
        list.add(a);
    }
}
