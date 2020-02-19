package cn.sawyer.leetcode.sort.myversion;

/**
 * @program: LeetCode
 * @description: 快速排序
 * @author: sawyer
 * @create: 2020-02-11 17:10
 **/

// 1. partition
// 2. sort
public class QuickSort {
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static int partition(int[] nums, int l, int r) {
        // 从l开始partition
        int i = l + 1, j = r;
        while (i <= j) {
            // 从左往右找到第一个大于l的
            while (i <= j && nums[i] < nums[l]) {
                i++;
            }
            // 从右往左找到第一个小于l的
            while (i <= j && nums[j] >= nums[l]) {
                j--;
            }
            // 交换
            if (i <= j) {
                swap(nums, j, i);
            }
        }
        // 把l插入正确位置
        swap(nums, l, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = partition(nums, l, r);
        sort(nums, l, mid - 1);
        sort(nums, mid + 1, r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 4, 3, 1, 6, 7, 9, 4, 5, 0, 10, 5};
        QuickSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
