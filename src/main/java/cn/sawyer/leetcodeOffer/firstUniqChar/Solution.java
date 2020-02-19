package cn.sawyer.leetcodeOffer.firstUniqChar;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 第一个只出现一次的字符，https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @author: sawyer
 * @create: 2020-02-12 21:14
 **/
public class Solution {
    public char firstUniqChar(String s) {

        for (char c : s.toCharArray()) {
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return c;
            }
        }

        return ' ';
    }
}
