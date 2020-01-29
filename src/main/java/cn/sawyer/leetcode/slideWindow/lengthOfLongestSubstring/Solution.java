package cn.sawyer.leetcode.slideWindow.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 无重复字符的最长子串，https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author: sawyer
 * @create: 2020-01-17 17:20
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {

        int len = Integer.MIN_VALUE;

        int l = 0;
        int r = 0;

        char[] chars = s.toCharArray();
        Set<Character> window = new HashSet<>();

        while (r < s.length()) {
            if (!window.contains(chars[r])) {
                window.add(chars[r]);
                r++;
                len = Math.max(len, r - l);
            } else {
                window.remove(chars[l]);
                l++;
            }
        }

        return len;
    }
}
