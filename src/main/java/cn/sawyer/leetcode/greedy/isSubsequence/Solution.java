package cn.sawyer.leetcode.greedy.isSubsequence;

/**
 * @program: LeetCode
 * @description: 判断子序列, https://leetcode-cn.com/problems/is-subsequence/
 * @author: sawyer
 * @create: 2020-02-09 13:57
 **/
public class Solution {

    // 使用indexOf
    public boolean isSubsequence2(String s, String t) {

        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }

        return true;
    }


    public boolean isSubsequence(String s, String t) {

        int ps = 0;
        int pt = 0;


        while (ps < s.length() && pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }
            pt++;
        }

        return ps == s.length();
    }
}
