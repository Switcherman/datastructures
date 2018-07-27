package com.pctf.algorithm.swardtooffer;

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 思路: 两个栈,一个最小值栈,一个最小值
 */
public class ExtendStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private Integer min;

    public void push(int node) {
        if(min == null || node < min) {
            minStack.push(min);
            min = node;
        }
        stack.push(node);
    }

    public void pop() {
        Integer result = stack.pop();
        if(result.equals(min)) {
            min = minStack.pop();
        }
    }

    public int top() {
        Integer result = stack.pop();
        if(result.equals(min)) {
            min = minStack.pop();
        }
        return result;
    }

    public int min() {
        return min;
    }

}
