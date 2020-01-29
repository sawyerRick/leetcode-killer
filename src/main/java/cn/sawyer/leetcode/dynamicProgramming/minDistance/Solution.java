package cn.sawyer.leetcode.dynamicProgramming.minDistance;

/**
 * @program: LeetCode
 * @description: 编辑距离 url:https://leetcode-cn.com/problems/edit-distance/
 * @author: sawyer
 * @create: 2020-01-04 13:49
 **/
public class Solution {

    public int minDistance(String word1, String word2) {
        // 参考，https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/

        // dp[i][j] 表示 word1的前i个到word2的前i个的编辑距离
        // dp[i][j - 1] 表示插入操作
        // dp[i - 1][j] 表示删除操作
        // dp[i - 1][j - 1] 表示替换操作
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // 初始化第一行第一列
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }


        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }


        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println((char) 34);
    }
}
