package cn.sawyer.leetcodeOffer.nthUglyNumber;

import java.util.PriorityQueue;

/**
 * @program: LeetCode
 * @description: 丑数，https://leetcode-cn.com/problems/chou-shu-lcof/
 * @author: sawyer
 * @create: 2020-02-12 20:11
 **/
public class Solution {

    public int nthUglyNumber2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            dp[i] = min;
            if (min == dp[i2] * 2) i2++;
            if (min == dp[i3] * 3) i3++;
            if (min == dp[i5] * 5) i5++;
            System.out.println(i2 + ", " + i3 + ", " + i5);
        }

        return dp[n - 1];
    }


    // 最小堆 (低效)
    public int nthUglyNumber(int n) {

        long curr = 1;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(curr);
        for (int i = 0; i < n; i++) {
            curr = queue.poll();
            System.out.println(curr);
            while (!queue.isEmpty() && curr == queue.peek()) {
                curr = queue.poll();
            }
            queue.add(curr * 2);
            queue.add(curr * 3);
            queue.add(curr * 5);
        }

        return (int) curr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.nthUglyNumber2(10);
        System.out.println(i);
    }
}
