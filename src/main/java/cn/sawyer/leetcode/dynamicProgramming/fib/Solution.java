package cn.sawyer.leetcode.dynamicProgramming.fib;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @program: LeetCode
 * @description: 动态规划经典解法，暴力递归-》备忘录递归-》dp缓存
 * 以经典的费波纳茨数列展示
 * @author: sawyer
 * @create: 2020-01-24 17:07
 **/
public class Solution {
    // 暴力递归，递归树里有非常多的重复子问题
    int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 带备忘录的递归
    HashMap<Integer, Integer> memo = new HashMap<>();
    int fib2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int r = fib2(n - 1) + fib2(n - 2);
        memo.put(n, r);

        return r;
    }

    // 把备忘录独立出来，叫做dp表
    int fib3(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long t0 = System.nanoTime();
        solution.fib(30);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println("time:" + millis + "ms");

        t0 = System.nanoTime();
        solution.fib2(10);
        t1 = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println("time:" + millis + "ms");


        System.out.println(solution.fib3(10));
    }
}
