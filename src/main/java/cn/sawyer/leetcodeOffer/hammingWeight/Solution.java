package cn.sawyer.leetcodeOffer.hammingWeight;

/**
 * @program: LeetCode
 * @description: 二进制中1的个数，https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @author: sawyer
 * @create: 2020-02-12 19:39
 **/
public class Solution {
    public int hammingWeight(int n) {

        int count = 0;

        int i = 32;
        while (i > 0) {
            n = n >>> 1;
            if ((n & 1) == 1) {
                count++;
            }
            i--;
        }

        return count;
    }
}
