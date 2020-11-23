package cn.sawyer.leetcode.dynamicProgramming.wordBreak;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-19 12:33
 **/
public class Solution3 {

    // 带备忘录的暴力回溯

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean wordBreak(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                if (wordBreak(s, wordDict, end, memo)) {
                    memo[start] = true;
                    return true;
                }
            }
        }
        memo[start] = false;

        return false;
    }
}
