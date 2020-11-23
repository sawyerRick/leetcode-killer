package cn.sawyer.sort;


/**
 * @program: LeetCode
 * @description: 归并排序，将两个有序列表合并成一个
 * @author: sawyer
 * @create: 2020-02-10 20:45
 **/
public class MergeSort {
    public static int[] mergeSort(int[] nums, int l, int h) {
        // 只剩一个
        if (l == h) {
            int one = nums[l];
            return new int[] { one };
        }

        int mid = (l + h) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;

        // 合并
        while (i < leftArr.length && j < rightArr.length) {
            // 小的放到newNum
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }

        // 补充 合并
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];

        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];

        return newNum;
    }
}

