package cn.sawyer.leetcodeOffer.exchange;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description: 调整顺序使得奇数位于偶数前面，https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @author: sawyer
 * @create: 2020-02-28 11:30
 **/
public class Solution {

    // 快排思想，双指针partition。
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            while (l < r && nums[l] % 2 != 0) {
                l++;
            }
            while (l < r && nums[r] % 2 == 0) {
                r--;
            }
            swap(nums, l, r);
        }

        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 暴力双向队列
    public int[] exchange2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                deque.addLast(num);
            } else {
                deque.addFirst(num);
            }
        }

        int[] ans = new int[deque.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = deque.poll();
        }

        return ans;
    }

}
