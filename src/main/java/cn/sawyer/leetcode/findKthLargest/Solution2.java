package cn.sawyer.leetcode.findKthLargest;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 再写一遍
 * @author: sawyer
 * @create: 2020-02-22 12:23
 **/
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(4);

        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            minHeap.add(nums[i]);
            minHeap.remove();
        }
        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
    }

}