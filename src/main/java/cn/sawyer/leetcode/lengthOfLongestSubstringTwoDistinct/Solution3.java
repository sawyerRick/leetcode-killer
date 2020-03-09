package cn.sawyer.leetcode.lengthOfLongestSubstringTwoDistinct;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 保存下标的写法
 * @author: sawyer
 * @create: 2020-02-26 18:25
 **/
public class Solution3 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {

            if (map.size() < 3) {
                char cRight = s.charAt(right);
                map.put(cRight, right);
                right++;
            }

            if (map.size() == 3) {
                int lIdx = Collections.min(map.values());
                map.remove(s.charAt(lIdx));
                left = lIdx + 1;
            }
            max = Math.max(right - left, max);
        }


        return max;
    }
}
