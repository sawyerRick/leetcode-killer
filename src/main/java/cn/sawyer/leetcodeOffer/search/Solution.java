package cn.sawyer.leetcodeOffer.search;

/**
 * @program: LeetCode
 * @description: 排序数组中查找数字，https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @author: sawyer
 * @create: 2020-02-28 16:40
 **/
public class Solution {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        int count = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                count++;
                int i = mid;
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                    count++;
                }
                i = mid;
                while (i > 0 && nums[i] == nums[i - 1]) {
                    i--;
                    count++;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return count;
    }
}