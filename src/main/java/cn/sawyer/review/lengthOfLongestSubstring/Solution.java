package cn.sawyer.review.lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 无重复字符最长子串，https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author: sawyer
 * @create: 2020-03-12 10:21
 **/

// 思路：滑动窗口
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> window = new HashSet<>();
        int low = 0;
        int high = 0;
        int max = 0;

        while (low <= high && high < s.length()) {
            if (!window.contains(s.charAt(high))) {
                window.add(s.charAt(high));
                high++;
                max = Math.max(max, high - low);
            } else {
                window.remove(s.charAt(low));
                low++;
            }
        }

        return max;
    }


}