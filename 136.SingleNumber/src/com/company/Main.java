package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        //put all the numbers to a hashset
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //For each number(key), if it appears twice, remove it from hashset.
        //In the end, the one that left in the set is the single number
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                set.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }
        // return the selected
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 1, 4};
        System.out.println(singleNumber(nums));
    }
}
