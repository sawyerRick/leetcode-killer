package cn.sawyer.leetcode.slideWindow.findAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 找到字符串中所有字母异位词，https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @author: sawyer
 * @create: 2020-01-17 17:13
 **/
public class Solution {


    public List<Integer> findAnagrams(String s, String p) {
        int l = 0;
        int r = 0;

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        List<Integer> ans = new ArrayList<>();

        for (char c : p.toCharArray()) {
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
                if (r - l == p.length()) {
                    ans.add(l);
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

        return ans;
    }
}
