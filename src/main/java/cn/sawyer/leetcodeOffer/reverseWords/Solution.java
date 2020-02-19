package cn.sawyer.leetcodeOffer.reverseWords;

import java.util.Collection;
import java.util.Collections;

/**
 * @program: LeetCode
 * @description: 翻转单词，https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * @author: sawyer
 * @create: 2020-02-16 15:12
 **/
public class Solution {

    public String reverseWords(String s) {
        s = s.trim();
        String[] ans = s.split("\\s+");
        int l = 0;
        int h = ans.length - 1;
        while (l < h) {
            String tmp = ans[l];
            ans[l++] = ans[h];
            ans[h--] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (String an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));

        return sb.toString().substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("  hello      world!  "));
    }
}
