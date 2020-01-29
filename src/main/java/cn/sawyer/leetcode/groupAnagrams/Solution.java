package cn.sawyer.leetcode.groupAnagrams;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 异位词分组 url:https://leetcode-cn.com/problems/group-anagrams/
 * @author: sawyer
 * @create: 2020-01-01 13:16
 **/
public class Solution {

    // 解法1：排序字符串
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> ans = new HashMap<>();


        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            if (!ans.containsKey(String.valueOf(cs))) {
                ans.put(String.valueOf(cs), new ArrayList<>());
            }
            ans.get(String.valueOf(cs)).add(strs[i]);
        }

        return new ArrayList<>(ans.values());
    }

    // 解法2：按计数分类
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            Arrays.fill(count, 0);

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]).append("#");
            }

            if (!ans.containsKey(sb.toString())) {
                ans.put(sb.toString(), new ArrayList<>());
            }
            ans.get(sb.toString()).add(s);
        }


        return new ArrayList<>(ans.values());
    }
}
