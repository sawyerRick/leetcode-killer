package cn.sawyer.leetcode.sort;

/**
 * @program: LeetCode
 * @description: 堆排序
 * @author: sawyer
 * @create: 2020-02-10 17:35
 **/
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    /**
     * 从1开始
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        // 从最后一个非叶子开始，从右到左，下沉
        for (int k = N / 2; k >= 1; k--)
            sink(nums, k, N);

        while (N > 1) {
            // 交换1和N，并切断N
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1))
                j++;
            if (!less(nums, k, j))
                break;
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        Comparable[] nums = new Comparable[]{-1, 4, 3, 1, 6, 7, 9, 4, 5, 0, 10, 5};
        heapSort.sort(nums);
        for (Comparable num : nums) {
            System.out.println(num);
        }
    }
}