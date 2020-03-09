package cn.sawyer.leetcode.findRepeatedDnaSequences;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 重复的DNA序列，https://leetcode-cn.com/problems/repeated-dna-sequences/
 * @author: sawyer
 * @create: 2020-02-26 19:50
 **/
public class Solution {
    // 暴力哈希表
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= len - 10; i++) {
            String key = s.substring(i, i + 10);
            //之前是否存在
            if (set.contains(key)) {
                res.add(key);
            } else {
                set.add(key);
            }

        }
        return new ArrayList<>(res);
    }

}