package cn.sawyer.leetcode.reverseBits;

/**
 * @program: LeetCode
 * @description: 颠倒二进制数，https://leetcode-cn.com/problems/reverse-bits/
 * @author: sawyer
 * @create: 2020-02-01 14:55
 **/
public class Solution {

    public int reverseBits(int n) {

        int ans = 0;

        int oldIndex = 31;

        while (oldIndex >= 0) {
            int newIndex = 31 - oldIndex;
            int tmp = (n >> oldIndex) & 1;
            ans = ans | tmp << newIndex;
//            ans = ans | (((n >> oldIndex) & 1) << newIndex); 简化版本
            oldIndex--;
        }

        return ans;
    }

}
