package com.pctf.algorithm.swardtooffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class PermutationClass {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str !=null && str.length() > 0) {
            permutationHelp(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    private void permutationHelp(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            String str = new String(chars);
            if (!list.contains(str)) {
                list.add(str);
            }
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(i, j, chars);
                permutationHelp(chars, i + 1, list);
                swap(i, j, chars);
            }
        }
    }

    private void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
