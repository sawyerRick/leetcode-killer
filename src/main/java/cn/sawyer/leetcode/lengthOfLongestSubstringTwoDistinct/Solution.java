package cn.sawyer.leetcode.lengthOfLongestSubstringTwoDistinct;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 至多包含两个不同字符的最长子串，https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * @author: sawyer
 * @create: 2020-02-26 15:39
 **/
public class Solution {

    // 滑动窗口
    public int lengthOfLongestSubstringTwoDistinct(String s) {


        int l = 0;
        int h = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        while (h < s.length()) {
            if (map.size() <= 2) {
                char c = s.charAt(h++);

                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.size() <= 2) {
                    max = Math.max(calSum(map.entrySet()), max);

                }
            } else {
                char c = s.charAt(l++);
                System.out.println("remove :" + c + " h:" + h);
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.getOrDefault(c, 0) == 0) {
                    map.remove(c);
                }
            }
        }

        return max;
    }

    int calSum(Set<Map.Entry<Character, Integer>> entry) {
        int count = 0;
        for (Map.Entry<Character, Integer> en : entry) {
            count += en.getValue();
        }
        return count;
    }
}