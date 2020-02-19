package cn.sawyer.leetcode.countPrimes;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 计算质数，https://leetcode-cn.com/problems/count-primes/
 * @author: sawyer
 * @create: 2020-02-07 18:50
 **/

// 筛选法
public class Solution {
    public int countPrimes(int n) {

        int count = 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {

            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
