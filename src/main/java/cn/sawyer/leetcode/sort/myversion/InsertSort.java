package cn.sawyer.leetcode.sort.myversion;

import java.util.Date;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-20 11:31
 **/
public class InsertSort {
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }
}
