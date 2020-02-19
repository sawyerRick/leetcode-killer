package cn.sawyer.leetcode.dynamicProgramming.candy;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-03 16:25
 **/
public class Solution {
    public int candy(int[] ratings) {

        int[] dp = new int[ratings.length];
        dp[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else if (ratings[i] == ratings[i - 1]) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] - 1;
            }
        }

        int sum = 0;
        for (int i : dp) {
            sum += i;
        }


        return sum;
    }
}
