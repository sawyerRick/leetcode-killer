package cn.sawyer.leetcode.dynamicProgramming.maxProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 乘积最大子序列，https://leetcode-cn.com/problems/maximum-product-subarray/
 * @author: sawyer
 * @create: 2020-01-16 21:34
 **/
public class Solution {


// 动态规划
    public int maxProduct(int[] nums) {

        int iMin = 1;
        int iMax = 1;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            // 交换最大最小
            if (nums[i] < 0) {
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }

            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);

            max = Math.max(iMax, max);
        }

        return max;

    }
}

class A {}
class B extends A {}
class C extends A {}
class D extends B {}