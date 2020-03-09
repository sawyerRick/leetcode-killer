package cn.sawyer.leetcodeOffer.twoSum;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: n个骰子的点数，https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 * @author: sawyer
 * @create: 2020-02-16 14:45
 **/
public class Solution2 {


    /*
    dp[i][j]: i个骰子，和为j的概率
     */
    public double[] twoSum(int n) {

        double[][] dp = new double[n + 1][6 * n + 1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1d / 6;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k < j; k++) {
                    System.out.println(dp[1][k]);
                    dp[i][j] += dp[i - 1][j - k] * dp[1][k];
                }
            }
        }

        return Arrays.copyOfRange(dp[n], n, n * 6 + 1);
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4};

        for (int i : Arrays.copyOfRange(list, 0, 4)) {
            System.out.println(i);
        }
    }
}
