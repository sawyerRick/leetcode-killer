package cn.sawyer.sort;

/**
 * @program: LeetCode
 * @description: 冒泡排序
 * @author: sawyer
 * @create: 2020-02-10 20:09
 **/
// 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
//
// 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
public class Bubble<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean isSorted = false;
        // 逆序
        for (int i = N - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            // 正序
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    isSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}