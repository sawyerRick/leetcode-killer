package cn.sawyer.leetcode.dynamicProgramming.longestPalindrome;

/**
 * @program: LeetCode
 * @description: 最长回文子串，https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author: sawyer
 * @create: 2020-02-06 15:39
 **/
public class Solution {

    // 方法2，dp
    // dp[i][j] ： s的i到j是回文
    // dp[i][j] = s.i == s.j && dp[i + 1][j - 1]
    public String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        String max = s.substring(0, 1);
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (j - i + 1 < 3) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > max.length()) {
                    max = s.substring(i, j + 1);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String i = solution.longestPalindrome2("aaaa");
        System.out.println("i = " + i);
    }

    // 方法1，暴力解法
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String max = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isValid(s, i, j)) {
                    if (j - i + 1 > max.length()) {
                        max = s.substring(i, j + 1);
                    }
                }
            }
        }

        return max;
    }

    private boolean isValid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    // 中心扩展法
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // 奇数中心
            int len2 = expandAroundCenter(s, i, i + 1); // 偶数中心

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // 返回中心扩展的总共n个匹配串
    public int expandAroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}
