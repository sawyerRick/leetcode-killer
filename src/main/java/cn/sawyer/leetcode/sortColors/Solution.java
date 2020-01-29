package cn.sawyer.leetcode.sortColors;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 颜色分类，https://leetcode-cn.com/problems/sort-colors/
 * @author: sawyer
 * @create: 2020-01-19 13:48
 **/
public class Solution {

    // 暴力排序
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    // 一次遍历
    // 三个指针：p1:指向0的最右边界， P2:指向2的最左边界，
    // curr移动，遇到0和p1交换，遇到2和p2交换
    public void sortColors2(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int curr = 0;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                int tmp = nums[curr];
                nums[curr] = nums[p1];
                nums[p1] = tmp;
                p1++;
            }

            if (nums[curr] == 2) {
                int tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2] = tmp;
                p2--;
                continue; //需要注意的是，交换2之后不需要移动curr
            }
            curr++;
        }
    }
}
