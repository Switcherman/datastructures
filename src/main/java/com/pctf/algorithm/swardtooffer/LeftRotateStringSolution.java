package com.pctf.algorithm.swardtooffer;

/**
 *
 *汇编语言中有一种移位指令叫做循环左移（ROL），
 *现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 *请你把其循环左移K
 * 位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * 思路:三次翻转
 * 第一次,翻转前n个字符,
 * 第二次,翻转后n个字符
 * 第三次.全部翻转.
 */
public class LeftRotateStringSolution {
    public String LeftRotateString(String str, int n) {
        if(n > str.length() || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int begin, int end) {
        while(begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }
}
