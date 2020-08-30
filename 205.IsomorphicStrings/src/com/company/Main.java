package com.company;

import java.util.HashMap;

public class Main {
    public static boolean isIsomorphic(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Built a one-to-one mapping relationship.
        HashMap<Character, Character> mapS = new HashMap<>(); // Mapping from s to t
        HashMap<Character, Character> mapT = new HashMap<>(); // Mapping from t to s
        for (int i = 0; i < sArray.length; i++) {
            if (mapS.containsKey(sArray[i])) {
                if (mapS.get(sArray[i]) != tArray[i]) {
                    return false;
                }
            } else {
                mapS.put(sArray[i], tArray[i]);
            }

            if (mapT.containsKey(tArray[i])) {
                if (mapT.get(tArray[i]) != sArray[i]) {
                    return false;
                }
            } else {
                mapT.put(tArray[i], sArray[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "see";
        String t = "tee";
        System.out.println(isIsomorphic(s, t));
    }
}
