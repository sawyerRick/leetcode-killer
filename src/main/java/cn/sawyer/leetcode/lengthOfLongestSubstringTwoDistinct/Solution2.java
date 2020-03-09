package cn.sawyer.leetcode.lengthOfLongestSubstringTwoDistinct;

import java.util.Collections;
import java.util.HashMap;

/**
 * @program: LeetCode
 * @description: 更优雅的写法
 * @author: sawyer
 * @create: 2020-02-26 16:15
 **/
public class Solution2 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {


        int l = 0;
        int h = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        while (h < s.length()) {
            char rChar = s.charAt(h);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            if (map.size() <= 2) {
                max = Math.max(h - l + 1, max);
            }
            h++;
            if (map.size() > 2){
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

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.lengthOfLongestSubstringTwoDistinct("eceba");
    }

}
