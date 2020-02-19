package cn.sawyer.leetcodeOffer.sumNums;

/**
 * @program: LeetCode
 * @description: 求1+到n,https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @author: sawyer
 * @create: 2020-02-15 16:25
 **/
public class Solution {

    public int sumNums(int n) {

        int ans = n;
        boolean b = n > 0 && (ans += sumNums(n - 1)) > 0;

        return ans;
    }
}
