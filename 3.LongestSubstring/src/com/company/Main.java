package com.company;

import java.util.HashMap;

public class Main {
    public static int lengthOfLongestSubstring(String s) {
        char str[] = s.toCharArray();
        // start of sliding window
        int start = 0;
        // end of sliding window
        int p = 0;
        // max length of sliding window
        int max = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (p < str.length) {
            // if map doesn't contain key str[p]
            if (!map.containsKey(str[p])) {
                map.put(str[p], p);
                result = p - start + 1;
                if (result > max) {
                    max = result;
                }
                p++;
            }
            // if map contains key str[p]
            else {

//                if (start <= map.get(str[p])) {
//                    start = map.get(str[p]) + 1;
//                    map.put(str[p], p);
//                    p = start;
//                }
//                // if sliding window doesn't contain character str[p], update map.
//                else {
//                    map.put(str[p], p);
//                    p++;
//                }
                if (p > map.get(str[p])) {
                    start = map.get(str[p]) + 1;
                    map.put(str[p],p);
                    p = start;
                }
                else {
                    result = p - start + 1;
                    if (result > max) {
                        max = result;
                    }
                    p++;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String testStr = "nfpdmpi";
        int result = lengthOfLongestSubstring(testStr);
        System.out.println(result);
    }
}
