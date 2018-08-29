package com.pctf.algorithm.swardtooffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 思路: 利用短路的原理
 */
public class Sum_SolutionSolution {

    public int Sum_Solution(int n) {
        int sum = n;
        boolean stop = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }

}
