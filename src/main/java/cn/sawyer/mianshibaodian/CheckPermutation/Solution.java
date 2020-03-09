package cn.sawyer.mianshibaodian.CheckPermutation;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 判断字符串能重排列，https://leetcode-cn.com/problems/check-permutation-lcci/
 * @author: sawyer
 * @create: 2020-03-05 15:50
 **/
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum += s1.charAt(i) - 'a';
            sum -= s2.charAt(i) - 'a';
        }


        return sum == 0;
    }
}