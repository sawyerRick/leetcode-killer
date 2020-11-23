package cn.sawyer.sort.myversion;

/**
 * @program: LeetCode
 * @description: 快速排序
 * @author: sawyer
 * @create: 2020-02-11 17:10
 **/

// 1. partition
// 2. sort
public class QuickSort {

    private static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = partition(nums, l, r);
        sort(nums, l, mid - 1);
        sort(nums, mid + 1, r);
    }

    private static int partition(int[] nums, int l, int r) {
        // pivot（基准点），partition使pivot左边的数字都小于pivot，右边的数字都大于pivot
        int pivot = l;
        int i = pivot + 1;
        int j = r;
        while (i <= j) {
            // 从左往右找到第一个大于pivot的
            while (i <= j && nums[i] <= nums[pivot]) {
                i++;
            }
            // 从右往左找到第一个小于pivot的
            while (i <= j && nums[j] > nums[pivot]) {
                j--;
            }
            // 交换
            if (i <= j) {
                swap(nums, j, i);
            }
        }
        // 把pivot插入到正确位置
        swap(nums, pivot, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 4, 3, 1, 6, 7, 9, 4, 5, 0, 10, 5};
        QuickSort.sort(nums,0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
