package cn.sawyer.leetcode.dynamicProgramming.isMatch;

/**
 * @program: LeetCode
 * @description: 通配符匹配，https://leetcode-cn.com/problems/wildcard-matching/
 * @author: sawyer
 * @create: 2020-01-25 15:30
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isMatch("ab", "a*b");
        System.out.println(res);
    }

    public boolean isMatch(String s, String p) {
        int is = 0;
        int ip = 0;

        while (is < s.length()) {
            char currS = s.charAt(is);
            char currP = p.charAt(ip);

            if (currP == '*') {
                is++;
            } else if (currP == '?') {
                // 遇到?
                ip++;
                is++;
            } else {
                if (currP != currS) {
                    return false;
                }
                ip++;
                is++;
            }
        }
        if (is == s.length()) {
            for (int i = 0; i < p.length() - ip; i++) {
                if (p.charAt(i + ip) != '*') {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
