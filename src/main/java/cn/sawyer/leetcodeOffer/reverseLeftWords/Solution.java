package cn.sawyer.leetcodeOffer.reverseLeftWords;

/**
 * @program: LeetCode
 * @description: 左旋转字符串，https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @author: sawyer
 * @create: 2020-03-07 15:18
 **/
public class Solution {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String ans = s.substring(n) + s.substring(0, n);

        return ans;
    }
}