package cn.sawyer.leetcode.search;

import java.net.ServerSocket;

/**
 * @program: LeetCode
 * @description: 寻找旋转排序数组，限制logN, url:https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @author: sawyer
 * @create: 2020-01-04 14:27
 **/

// 二分查找找旋转点，二分查找找target
public class Solution {
    int[] nums;

    // 找旋转点
    public int findRotate(int low, int high) {
        if (nums[low] < nums[high]) {
            return nums.length - 1;
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                if (nums[mid] < nums[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }

        return nums.length - 1;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return target;
        }

        this.nums = nums;
        int rotate = findRotate(0, nums.length - 1);
        System.out.println("rotate = " + rotate);

        int low;
        int high;
        if (target >= nums[0]) {
            low = 0;
            high = rotate;
        } else {
            high = nums.length - 1;
            low = rotate + 1;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.search(new int[]{4, 5, 1, 2, 3}, 1);
    }
}