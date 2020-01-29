package cn.sawyer.leetcode.findMedianSortedArrays;

/**
 * @program: LeetCode
 * @description: 寻找两个有序数组的中位数，https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author: sawyer
 * @create: 2020-01-29 17:17
 **/
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int mid = 0;
        if ((nums1.length + nums2.length) % 2 == 0) {
            mid = (nums1.length + nums2.length) / 2;
        }

        return 1;
    }
}
