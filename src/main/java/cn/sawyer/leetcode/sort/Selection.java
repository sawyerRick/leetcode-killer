package cn.sawyer.leetcode.sort;

/**
 * @program: LeetCode
 * @description: 选择排序，每次选第N个最小，插入位置N
 * @author: sawyer
 * @create: 2020-02-10 19:27
 **/


// 时间复杂度 O(n^2)
public class Selection<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }
}