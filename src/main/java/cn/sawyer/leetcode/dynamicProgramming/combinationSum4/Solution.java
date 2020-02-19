package cn.sawyer.leetcode.dynamicProgramming.combinationSum4;

/**
 * @program: LeetCode
 * @description: 组合总和4，https://leetcode-cn.com/problems/combination-sum-iv/
 * @author: sawyer
 * @create: 2020-02-03 15:02
 **/

// 背包01问题，和硬币题很像
public class Solution {

    // dp[i] target为i的时候的解
    public int combinationSum4(int[] candidates, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int c : candidates) {
                if (c <= i) {
                    dp[i] += dp[i - c];
                }
            }
        }

        return dp[target];
    }
}
