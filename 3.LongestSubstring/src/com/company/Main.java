package com.company;

import java.util.HashMap;
import java.math.*;

public class Main {
    public static int lengthOfLongestSubstring(String s) {
        char str[] = s.toCharArray();
        // start of sliding window
        int start = 0;
        // end of sliding window
        int p = 0;
        // record the max length of sliding window
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (p < str.length) {
            if (map.containsKey(str[p])) {
                start = Math.max(map.get(str[p]) + 1, start);
            }
            result = Math.max(p - start + 1, result);
            map.put(str[p], p);
            p++;
        }
        return result;
    }

    public static void main(String[] args) {
        String testStr = "nfpdmpi";
        int result = lengthOfLongestSubstring(testStr);
        System.out.println(result);
    }
}
