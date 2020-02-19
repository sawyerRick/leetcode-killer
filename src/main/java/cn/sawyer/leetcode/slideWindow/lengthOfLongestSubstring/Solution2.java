package cn.sawyer.leetcode.slideWindow.lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 再写一遍
 * @author: sawyer
 * @create: 2020-02-06 15:32
 **/
public class Solution2 {
    // 滑动窗口

    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int l = 0;
        int r = 0;

        int max = 0;

        while (r < s.length()){
            char c = s.charAt(r);
            if (!window.contains(c)) {
                window.add(c);
                max = Math.max(r - l + 1, max);
                r++;
            } else {
                window.remove(s.charAt(l));
                l++;
            }
        }

        return max;
    }
}
