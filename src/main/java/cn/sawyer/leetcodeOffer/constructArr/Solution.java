package cn.sawyer.leetcodeOffer.constructArr;

/**
 * @program: LeetCode
 * @description: 构建乘积数组，https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * @author: sawyer
 * @create: 2020-02-27 12:27
 **/
public class Solution {

    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }

        int[] leftSum = new int[a.length];
        int[] rightSum = new int[a.length];
        rightSum[a.length - 1] = 1;
        leftSum[0] = 1;
        for (int i = 1; i < a.length; i++) {
            leftSum[i] = leftSum[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] * a[i + 1];
        }

        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ans[i] = leftSum[i] * rightSum[i];
        }


        return ans;
    }
}