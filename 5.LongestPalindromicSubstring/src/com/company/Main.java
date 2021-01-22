package com.company;


public class Main {
    public static String update(String result, String s, int start, int end) {
        if (result.length() < end - start + 1) {
            result = s.substring(start, end + 1);
        }
        return result;
    }

    public static String longestPalindrome(String s) {
        char[] buffer = s.toCharArray();
        int len = s.length();
        if (len < 2)
            return s;
        if ((len == 2) && (buffer[0] == buffer[1]))
            return s;
        if ((len == 2) && (buffer[0] != buffer[1]))
            return s.substring(0,1);

        // 中心扩散法
        int start = 1;
        int center = 1;
        int end = 1;
        String result;
        if ((len > 2) && (buffer[0] == buffer[1])) {
            result = s.substring(0, 2); //s.substring(0,0);
        } else {
            result = "";
        }

        int maxResult = result.length();

        while (center <= len - 1) {
            start = end = center;
            while (start > -1 && end < len) {
                if (buffer[start] != buffer[end]) {
                    break;
                }
                start--;
                end++;
            }
            result = update(result, s, start + 1, end - 1);
            maxResult = result.length();

            start = center;
            end = center + 1;
            while (start > -1 && end < len) {
                if (buffer[start] != buffer[end]) {
                    break;
                }
                start--;
                end++;
            }
            result = update(result, s, start + 1, end - 1);
            maxResult = result.length();
            center++;
            start = end = center;
        }

        return result;
    }

    public static void main(String[] args) {
        // "xbxbbxd"  xbbx
        // "abbx"    bb
        // "abcccc"   cccc
        // "abdccd"   dccd
        // "aabcde" aa
        // "c" c
        //  a
        String s = "ac";
        String result = longestPalindrome(s);
        System.out.println(result);
    }
}
