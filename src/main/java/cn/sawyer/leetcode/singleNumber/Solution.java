package cn.sawyer.leetcode.singleNumber;

/**
 * @program: LeetCode
 * @description: 只出现一次的数字，https://leetcode-cn.com/problems/single-number/
 * @author: sawyer
 * @create: 2020-02-28 17:00
 **/


// 除一个数字外，其他数字都出现了两次！
public class Solution {

    // 异或运算
    public int singleNumber(int[] nums) {

        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Integer.toBinaryString(curr));
            curr ^= nums[i];
        }


        return curr;
    }
}