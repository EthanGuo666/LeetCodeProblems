package com.company;
import java.util.*;

public class Main {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (dict.containsKey(diff)) {
                return new int[]{dict.get(diff), i};
            } else {
                dict.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    public static void main(String[] args) {
	    int num[] = {2, 7, 11, 15};
        int target = 9;
        int result[]= twoSum(num, target);
        for(int i =0;i< result.length;i++){
            System.out.println(result[i]);
        }
    }
}