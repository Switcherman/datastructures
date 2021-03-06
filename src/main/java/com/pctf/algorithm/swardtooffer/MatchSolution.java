package com.pctf.algorithm.swardtooffer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class MatchSolution {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int sIndex = 0;
        int pIndex = 0;
        while (sIndex < str.length && pIndex < pattern.length) {
            if (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.') { //单个匹配或匹配单个通配符
                sIndex++;
                pIndex++;
                continue;
            }
            if ('*' == pattern[pIndex]) { // 匹配*
                if (pIndex != 0 && pattern[pIndex - 1] == str[sIndex]) {
                    sIndex++;
                    continue;
                } else {
                    pIndex++;
                    continue;
                }
            }
            if (pIndex == pattern.length - 1 || pattern[pIndex + 1] != '*') {
                return false;
            } else {
                pIndex ++;
            }
        }

        return sIndex == str.length && pIndex == pattern.length;
    }

}
