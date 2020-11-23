package cn.sawyer.review.longestPalindrome;

/**
 * @program: LeetCode
 * @description: 最长回文串，https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author: sawyer
 * @create: 2020-03-12 10:32
 **/

// 中心扩展法
public class Solution {

    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i + 1); // 偶数
            int len2 = expand(s, i, i); // 奇数

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}