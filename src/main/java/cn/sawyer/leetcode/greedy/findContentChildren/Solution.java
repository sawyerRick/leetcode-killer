package cn.sawyer.leetcode.greedy.findContentChildren;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-08 16:35
 **/
public class Solution {
    // 贪心
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int p1 = 0; // 孩子指针
        int p2 = 0; // 饼干指针
        while (p2 < s.length && p1 < g.length) {
            if (g[p1] <= s[p2]) {
                p1++;
            }
            p2++;
        }

        return p1;
    }
}
