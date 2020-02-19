package cn.sawyer.leetcodeOffer.printNumbers;

/**
 * @program: LeetCode
 * @description: 打印数字，https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @author: sawyer
 * @create: 2020-02-15 17:04
 **/
public class Solution {

    public int[] printNumbers(int n) {

        int max = (int) Math.pow(10, n);
        int[] ans = new int[max - 1];
        for (int i = 1; i <= max - 1; i++) {
            ans[i - 1] = i;
        }

        return ans;
    }
}
