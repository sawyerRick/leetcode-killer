package cn.sawyer.sort;

/**
 * @program: LeetCode
 * @description: 希尔排序，插入排序增强版本。
 * @author: sawyer
 * @create: 2020-02-10 20:30
 **/


// 分组的插入排序，分段：h
public class Shell<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {

        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                // j和j-h比较
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
