package cn.sawyer.sort.myversion;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-11 17:06
 **/
class MergeSort {
    int[] aux; // 辅助数组

    // 归并排序，用户接口
    public void sort(int[] nums) {
        aux = new int[nums.length];
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
    public void merge(int[] nums, int l, int m, int h) {
        aux = new int[h - l + 1];

        int ia = 0;
        int i1 = l;
        int i2 = m + 1;

        // 合并
        while (i1 <= m && i2 <= h) {
            aux[ia++] = nums[i1] < nums[i2] ? nums[i1++] : nums[i2++];
        }

        // 补充
        while (i1 <= m) {
            aux[ia++] = nums[i1++];
        }

        while (i2 <= h) {
            aux[ia++] = nums[i2++];
        }

        // 复制回原数组
        System.arraycopy(aux, 0, nums, l, h - l + 1);
    }
}
