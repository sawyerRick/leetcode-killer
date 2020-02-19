package cn.sawyer.leetcode.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 快速排序，partition
 * @author: sawyer
 * @create: 2020-02-10 22:12
 **/
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    @Override
    public void sort(T[] nums) {
        // 防止最开始就是有序的，打乱数组
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l)
            return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }
}