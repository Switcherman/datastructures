package com.pctf.algorithm.swardtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 *在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingCharSolution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || "".equals(str)) {
            return -1;
        }
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : chars) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(int i = 0; i < chars.length; i++) {
            if(map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
