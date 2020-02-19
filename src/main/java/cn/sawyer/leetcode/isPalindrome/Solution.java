package cn.sawyer.leetcode.isPalindrome;

/**
 * @program: LeetCode
 * @description: 判断回文，https://leetcode-cn.com/problems/valid-palindrome/
 * @author: sawyer
 * @create: 2020-02-01 14:25
 **/
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        System.out.println(s);

        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "`l;`` 1o1 ??;l`";
        System.out.println(s.replaceAll("[^a-zA-Z0-9]", ""));
    }
}