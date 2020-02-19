package cn.sawyer.leetcode.hammingWeight;

/**
 * @program: LeetCode
 * @description: 位1的个数
 * @author: sawyer
 * @create: 2020-02-01 14:39
 **/
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        int i = 32;
        while (i > 0) {
            if (((n & 1) ^ 1) == 0) {
                count++;
            }
            n >>= 1;
            i--;
        }

        return count;
    }
}
