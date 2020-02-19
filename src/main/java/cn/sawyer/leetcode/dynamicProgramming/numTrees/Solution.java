package cn.sawyer.leetcode.dynamicProgramming.numTrees;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 不同的二叉搜索树1，https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @author: sawyer
 * @create: 2020-01-16 21:09
 **/
public class Solution {


//    G(n): 长度为n的序列的不同二叉搜索树个数。

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numTreesDP(3);
        System.out.println(i);
    }

    // 暴力递归 自顶向下
    public int numTreesRecur(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int left;
        int right;
        int subProb = 0;

        for (int i = 1; i <= n; i++) {
            left = numTreesRecur(i - 1);
            right = numTreesRecur(n - i);
            subProb += left * right;
        }

        return subProb;
    }

    // 备忘录的递归 自顶向下
    Map<Integer, Integer> memo = new HashMap<>();

    public int numTreesMemo(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int left = 0;
        int right = 0;
        int subProb = 0;

        for (int i = 1; i <= n; i++) {
            left = numTreesMemo(i - 1);
            right = numTreesMemo(n - i);
            subProb += left * right;
        }
        memo.put(n, subProb);
        return subProb;
    }

    // dp
    public int numTreesDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }


    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
