package cn.sawyer.leetcodeOffer.maxSlidingWindow;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 滑动窗口的最大值，https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * @author: sawyer
 * @create: 2020-02-13 14:04
 **/
public class Solution {


    // 暴力法
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return null;
        }

        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(nums[j], max);
            }
            ans[i] = max;
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
//        deque.stream().forEach(System.out::println);
    }
}
