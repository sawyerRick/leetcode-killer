package cn.sawyer.leetcodeOffer.getLeastNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 最小的K个数，https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @author: sawyer
 * @create: 2020-02-16 14:14
 **/
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        int[] ans = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, ans, 0, k);

        return ans;
    }
}
