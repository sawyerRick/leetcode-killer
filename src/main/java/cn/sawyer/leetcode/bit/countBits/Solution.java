package cn.sawyer.leetcode.bit.countBits;

/**
 * @program: LeetCode
 * @description: 比特位计数，https://leetcode-cn.com/problems/counting-bits/
 * @author: sawyer
 * @create: 2020-01-10 15:00
 **/
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            int count = 0;
            int n = i;
            while (n != 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n = n >>> 1;
            }
            ans[i] = count;
        }


        return ans;
    }
}
