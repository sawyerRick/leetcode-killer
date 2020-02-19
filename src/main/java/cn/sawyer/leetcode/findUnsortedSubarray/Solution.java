package cn.sawyer.leetcode.findUnsortedSubarray;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 最短无序子数组，https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * @author: sawyer
 * @create: 2020-01-31 16:29
 **/
public class Solution {

    // 单调栈
    public int findUnsortedSubarray2(int[] nums) {
        int l = nums.length;
        int r = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }

        return r - l > 0? r - l + 1: 0;
    }

    // 排序，比较排序后和排序前开始不一样的位置
    public int findUnsortedSubarray(int[] nums) {

        int[] copy = nums.clone();
        int start = 0;
        int end = nums.length - 1;

        Arrays.sort(copy);
        for (int i = 0; i < nums.length; i++) {
            if (copy[i] != nums[i]) {
                start = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (copy[i] != nums[i]) {
                end = i;
                break;
            }
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
    }
}
