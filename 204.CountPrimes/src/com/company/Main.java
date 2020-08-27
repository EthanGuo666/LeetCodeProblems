package com.company;

import java.util.Arrays;

public class Main {
    // This solution refered from the link below.
    // https://leetcode-cn.com/problems/count-primes/solution/ru-he-gao-xiao-pan-ding-shai-xuan-su-shu-by-labula/
    public static int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        // isPrime[x] is to record if number x is an prime.
        boolean isPrime[] = new boolean[n + 1];
        // Initialize all the integers are primes.
        Arrays.fill(isPrime, true);

        // Record the number of primes.
        int count = 0;

        // We are required to count how many primes are LESS THAN n.
        for (int i = 2; i < n; i++) {
            // if we find number i is a prime, update all its multiples to be non-prime.
            if (isPrime[i]) {
                count++;
                //System.out.println(i);
                for (int j = i * 2; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 99999;
        System.out.println("total:"+countPrimes(num));
    }
}
