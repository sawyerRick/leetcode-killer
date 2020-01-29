package cn.sawyer.leetcode.findKthLargest;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 数组中最大的第k个元素，https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @author: sawyer
 * @create: 2020-01-29 16:10
 **/
public class Solution {

    public static void main(String[] args) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(2, (a,b)-> b - a);
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        System.out.println(maxHeap.size());
    }

    // 思路5：手动固定容量的最小堆
    public int findKthLargest5(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k + 1, (a, b) -> a - b);

        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            maxHeap.poll();
        }

        return maxHeap.peek();
    }

    // 思路4：最大堆，也是用java优先队列
    public int findKthLargest4(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, (a,b)-> b - a);

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }

    // 思路3：最小堆，用java优先队列实现
    public int findKthLargest3(int[] nums, int k) {
        // 最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 默认是最小堆

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = 0; i < nums.length - k; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
    }



    // 思路2：partition 手写快排
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                for (int i = 0; i < nums.length; i++) {
                    System.out.println(nums[i]);
                }
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    /**
     * 在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的语义
     * 1、[left + 1, j] < nums[left]
     * 2、(j, i] >= nums[left]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    // 思路1：排序
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        int i = nums.length - 1;

        for (; i > 0; i--) {
            k--;
            if (k == 0) {
                break;
            }
        }

        return nums[i];
    }
}
