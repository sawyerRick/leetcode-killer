package cn.sawyer.leetcode.dynamicProgramming.wordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-19 12:32
 **/
public class Solution2 {

    // 暴力递归
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), 0);
    }

    public boolean dfs(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                if (dfs(s, wordDict, end)) {
                    return true;
                }
            }
        }
        return false;
    }
}
