package cn.sawyer.leetcode.dynamicProgramming.wordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-19 12:39
 **/

// 再写
public class Solution4 {
    Object object;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return s.isEmpty();
        }
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // dp[j]：前半段，wordDict.contains(s.substring(j, i)：后半段
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}