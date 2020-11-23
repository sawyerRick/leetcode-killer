package cn.sawyer.sort.practice;

/**
 * @program: LeetCode
 * @description: 归并排序
 * @author: sawyer
 * @create: 2020-03-18 15:22
 **/

public class MergeSort {


    // 归并排序，用户接口
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    // 归并nums, l-h
    public void sort(int[] nums, int l, int h) {
        if (l == h) {
            return;
        }

        int m = (l + h) / 2;
        sort(nums, l, m); // 排序l ~ m
        sort(nums, m + 1, h); // 排序m+1 ~ h

        merge(nums, l, m, h);
    }

    // 合并有序数组
    public void merge(int[] nums, int low, int mid, int high) {
        int[] sup = new int[high - low + 1];

        int supIdx = 0;
        int arr1Idx = low;
        int arr2Idx = mid + 1;

        // 合并
        while (arr1Idx <= mid && arr2Idx <= high) {
            sup[supIdx++] = nums[arr1Idx] < nums[arr2Idx] ? nums[arr1Idx++] : nums[arr2Idx++];
        }

        // 补充
        while (arr1Idx <= mid) {
            sup[supIdx++] = nums[arr1Idx++];
        }

        while (arr2Idx <= high) {
            sup[supIdx++] = nums[arr2Idx++];
        }

        // 复制回原数组
        System.arraycopy(sup, 0, nums, low, high - low + 1);
    }

    public static void main(String[] args) {
        Insertion insertion = new Insertion();
        int[] nums = new int[]{3, 6, 3, 8, 9, 3, 1, 0, -1, -3, 5, 6};
        insertion.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
