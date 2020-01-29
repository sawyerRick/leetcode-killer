package cn.sawyer.leetcode.slideWindow.minWindow;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 最小覆盖子串，https://leetcode-cn.com/problems/minimum-window-substring/
 * @author: sawyer
 * @create: 2020-01-17 14:24
 **/
public class Solution {
    public String minWindow(String s, String t) {

        int start = 0;
        int minLen = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
            window.put(c, 0);
        }

        char[] chars = s.toCharArray();
        int match = 0;
        while (r < chars.length) {
            // 移动右
            char curr = chars[r];
            // 最右是需要的字符
            if (need.containsKey(curr)) {
                window.put(curr, window.get(curr) + 1);
                // 达到Need要求
                if (window.get(curr).equals(need.get(curr))) {
                    match++;
                }
            }
            r++;

            // 移动左
            // 每个都符合要求了
            while (match == need.size()) {
                char c = chars[l];
                if (r - l < minLen) {
                    minLen = r - l;
                    start = l;
                }
                if (need.containsKey(c)) {
                    window.put(c, window.get(c) - 1);
                    if (window.get(c) < need.get(c)) {
                        match--;
                    }
                }
                l++;
            }
        }
        System.out.println(minLen);

        return minLen == Integer.MAX_VALUE? "": s.substring(start, start + minLen);
    }
}