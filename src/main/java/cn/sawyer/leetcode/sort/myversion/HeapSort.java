package cn.sawyer.leetcode.sort.myversion;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-11 16:39
 **/

// 1. 构建大顶堆
// 2. 交换头尾，切断，下沉
public class HeapSort {

    public static void sort(int[] nums) {
        // 1. 从最后一个非叶子开始，右~左下沉
        int k = (nums.length - 1) / 2;
        while (k >= 1) {
            sink(nums, k--, nums.length - 1);
        }
        // 2. 交换头尾，切换，下沉
        int end = nums.length - 1;
        while (end >= 1) {
            swap(nums, 1, end--);
            sink(nums, 1, end);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void sink(int[] nums, int k, int end) {
        while (2 * k <= end) {
            int child = 2 * k;
            // 选较大的孩子
            // 细节判断，可能没有右孩子
            if (child < end && nums[child] < nums[child + 1]) {
                child++;
            }
            // 交换父子
            if (nums[k] < nums[child]) {
                swap(nums, k, child);
            }
            k = child;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 4, 3, 1, 6, 7, 9, 4, 5, 0, 10, 5};
        HeapSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
