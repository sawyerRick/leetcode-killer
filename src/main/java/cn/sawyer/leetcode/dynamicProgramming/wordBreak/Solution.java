package cn.sawyer.leetcode.dynamicProgramming.wordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: LeetCode
 * @description:单词拆分，https://leetcode-cn.com/problems/word-break/
 * @author: sawyer
 * @create: 2020-01-19 16:16
 **/
public class Solution {

    // 动态规划：dp[i] 表示s.substring(0,i) 可拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return s.isEmpty();
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // dp[j]：前半段，wordDict.contains(s.substring(j, i)：后半段
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
