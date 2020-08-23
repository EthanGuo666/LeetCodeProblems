package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static ArrayList<Integer> addArray(int[] nums, int startIndex) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = startIndex; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        return numList;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<Integer> numList = addArray(nums, 0);

        // Fist, select two numbers, a and b.
        for (int i = 0; i < numList.size() - 3; i++) {
            for (int j = i + 1; j < numList.size() - 2; j++) {
                // newList is the numbers leftover, starting from nums[j+1].
                // We need to choose c and d in the newList
                ArrayList<Integer> newList = addArray(nums, j + 1);
                //todo:
                int tempSum = nums[i] + nums[j];

            }
        }
        return new ArrayList<List<Integer>>();
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        //System.out.println(result);
    }
}
