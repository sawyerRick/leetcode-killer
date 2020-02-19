package cn.sawyer.leetcodeOffer.maxSlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: LeetCode
 * @description: 双向队列解法
 * @author: sawyer
 * @create: 2020-02-15 20:48
 **/
class Solution2 {
    Deque<Integer> dq = new ArrayDeque<>();
    int[] nums;

    // 保持队首最大，并且队首要在队列中。
    void cleanDq(int index, int windowSize) {
        // 最大值（队首）已经滑出窗口，删除
        if (!dq.isEmpty() && dq.getFirst() == index - windowSize) {
            dq.removeFirst();
        }

        // 删除比当前小的
        while (!dq.isEmpty() && nums[dq.getLast()] < nums[index]) {
            dq.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        this.nums = nums;
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            cleanDq(i, k);
            dq.addLast(i);
        }
        ans[0] = nums[dq.getFirst()];

        for (int i = k; i < nums.length; i++) {
            cleanDq(i, k);
            dq.addLast(i);
            ans[i - k + 1] = nums[dq.getFirst()];
        }

        return ans;
    }

}