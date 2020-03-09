package cn.sawyer.leetcode.lengthOfLongestSubstringKDistinct;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-26 18:24
 **/
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int l = 0;
        int h = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        while (h < s.length()) {
            char rChar = s.charAt(h);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            if (map.size() <= k) {
                max = Math.max(h - l + 1, max);
            }
            h++;
            if (map.size() > k){
                char lChar = s.charAt(l++);
                int num = map.get(lChar) - 1;
                if (num == 0) {
                    map.remove(lChar);
                } else {
                    map.put(lChar, num);
                }
            }

        }

        return max;
    }
}