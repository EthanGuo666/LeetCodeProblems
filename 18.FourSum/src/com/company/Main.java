package com.company;

import java.util.*;

import static java.util.Collections.sort;

public class Main {
    public static List<Integer> addArray(int[] nums, int startIndex) {
        List<Integer> numList = new ArrayList<>();
        for (int i = startIndex; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        return numList;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // Put all integers in nums in numsArray, and sort them in ascending order.
        int numsArray[] = nums;
        Arrays.sort(numsArray);

        // Use these two to record the result.
        // resultSet is to confirm there are no redundance.
        // finalResult is to store the final answer.
        HashSet<List<Integer>> resultSet = new HashSet<List<Integer>>();
        List<List<Integer>> finalResult = new ArrayList<List<Integer>>();

        // Fist, select two numbers, nums[i] to be "a" and nums[j] to be "b".
        for (int i = 0; i < numsArray.length - 3; i++) {
            for (int j = i + 1; j < numsArray.length - 2; j++) {
                // newList is the numbers leftover, starting from nums[j+1].
                List<Integer> newList = addArray(numsArray, j + 1);

                // In newList, we need to find pairs of c and d whose sum is newTarget.
                int newTarget = target - numsArray[i] - numsArray[j];

                HashMap<Integer, Integer> map = new HashMap<>();
                Iterator<Integer> it = newList.iterator();
                while (it.hasNext()) {
                    int c = it.next();
                    if (map.containsKey(newTarget - c)) {
                        // Add a record in set
                        List<Integer> findOne = new ArrayList<>();
                        findOne.add(numsArray[i]);
                        findOne.add(numsArray[j]);
                        findOne.add(c);
                        findOne.add(newTarget-c);
                        sort(findOne);
                        if(!resultSet.contains(findOne)){
                            resultSet.add(findOne);
                            finalResult.add(findOne);
                        }
                    } else {
                        map.put(c, newTarget -c);
                    }
                }
            }
        }
        // System.out.println(finalResult);
        return finalResult;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        //System.out.println(result);
    }
}
