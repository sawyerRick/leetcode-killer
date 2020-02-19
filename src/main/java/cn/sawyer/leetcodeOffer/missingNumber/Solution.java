package cn.sawyer.leetcodeOffer.missingNumber;

/**
 * @program: LeetCode
 * @description: 0~n-1中缺失的数字，https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * @author: sawyer
 * @create: 2020-02-15 15:39
 **/
public class Solution {


    // 二分查找，位置正确则无丢失
    public int missingNumber(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }


        return nums[l] == l? nums[l] + 1: nums[l] - 1;
    }
}
