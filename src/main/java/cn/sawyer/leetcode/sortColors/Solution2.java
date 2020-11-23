package cn.sawyer.leetcode.sortColors;

/**
 * @program: LeetCode
 * @description: 再写一次
 * @author: sawyer
 * @create: 2020-03-11 19:57
 **/
public class Solution2 {
    public void sortColors(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int curr = 0;

        while (curr <= high) {

            if (nums[curr] == 0) {
                swap(nums, curr, low);
                low++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, high);
                high--;
            } else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}