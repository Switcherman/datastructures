package com.pctf.algorithm.swardtooffer;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * 复制
 * +2147483647
 *     1a33
 * 输出
 * 复制
 * 2147483647
 *     0
 */
public class StrToIntSolution {

    public int StrToInt(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        boolean negative = false;
        char[] chars = str.toCharArray();
        int index = 0;
        int len = chars.length;
        int result = 0;
        int digit = 0;
        // 判断第一位是否是符号位
        if (chars[0] < '0') {
            if ('-' == chars[0]) {
                negative = true;
            } else if ('+' != chars[0] || len == 1){
                return 0;
            }
            index++;
        }
        while (index < len) {
            char c = chars[index++];
            if (c < '0' || c > '9') {
                return 0;
            }
            digit = Character.digit(c, 10);
            result *= 10;
            result += digit;
        }
        return negative ? -result : result;
    }
}
