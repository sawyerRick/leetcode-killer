package cn.sawyer.leetcode.dynamicProgramming.numDecodings;

/**
 * @program: LeetCode
 * @description: 解码方法 https://leetcode-cn.com/problems/decode-ways/
 * @author: sawyer
 * @create: 2020-01-07 14:37
 **/
public class Solution {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (((s.charAt(i - 1) - '0') * 10 + s.charAt(i)) - '0' <= 26 && s.charAt(i) != '0' && s.charAt(i - 1) != '0') {
                if (i < s.length() - 1 && s.charAt(i + 1) != '0') {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1];
            }
            if (s.charAt(i) + s.charAt(i - 1) == '0' + '0') {
                return 0;
            }
        }


        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.numDecodings("226");
        System.out.println(1 + 'a');
        System.out.println("i = " + i);
    }

}
