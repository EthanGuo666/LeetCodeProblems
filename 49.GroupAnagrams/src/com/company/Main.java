package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // K is the String after sorted, V is in which group the string is in the final result.
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            // Change the string into a sorted string.
            char[] chArray = strs[i].toCharArray();
            Arrays.sort(chArray);
            String sortedStr = String.valueOf(chArray);
            if(map.containsKey(sortedStr)){
                int num = map.get(sortedStr);
                // Todo: add sortedStr to ArrayList .
                result
            }
        }

    }

    public static void main(String[] args) {
        String[] strs = {"abc", "bca", "eat", "eta", "hello"};

    }
}
