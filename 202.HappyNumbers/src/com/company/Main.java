package com.company;

import java.util.HashSet;

public class Main {
    public static int calculate(int n) {
        int table[] = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
        int digit = 0;
        int sum = 0;
        while (n > 0) {
            digit = n % 10;
            sum += table[digit];
            n = n / 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        int result = n;
        HashSet<Integer> numSet = new HashSet<>();
        while (result != 1) {
            if(numSet.contains(result)){
                return false;
            }
            numSet.add(result);
            result = calculate(result);
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 19;
        System.out.println(isHappy(num));
    }
}
