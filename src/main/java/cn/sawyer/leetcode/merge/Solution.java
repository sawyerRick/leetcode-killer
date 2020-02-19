package cn.sawyer.leetcode.merge;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 合并有序数组，https://leetcode-cn.com/problems/merge-sorted-array/
 * @author: sawyer
 * @create: 2020-02-10 18:14
 **/
public class Solution {

    // 最优解，倒序开始，不使用额外空间。
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // num1指针
        int p2 = n - 1; // num2指针
        int p = m + n - 1;

        while ((p1 >= 0) && (p2 >= 0)) {
            // 比较num1/2把最大的加入p
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        // 如果2还有剩余，复制2到1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    // 排序合并
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // 额外空间
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                num[i++] = nums1[p1++];
            } else {
                num[i++] = nums2[p2++];
            }
        }
        while (p1 < m) {
            num[i++] = nums1[p1++];
        }
        while (p2 < n) {
            num[i++] = nums2[p2++];

        }
        for (i = 0; i < num.length; i++) {
            nums1[i] = num[i];
        }
    }
}
