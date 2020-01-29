package cn.sawyer.leetcode.climbStairs;

/**
 * @program: LeetCode
 * @description: 爬楼梯 url:https://leetcode-cn.com/problems/climbing-stairs/
 * @author: sawyer
 * @create: 2020-01-05 14:10
 **/
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] ans = new int[n];
        ans[0] = 1;
        ans[1] = 2;

        for (int i = 2; i < n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }


        return ans[n - 1];
    }
}
