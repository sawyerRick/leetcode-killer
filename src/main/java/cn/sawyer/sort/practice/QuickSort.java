package cn.sawyer.sort.practice;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-18 15:00
 **/

public class QuickSort {

    // 切分
    private int partition(int[] nums, int pivot, int end) {
        int left = pivot + 1;
        while (left <= end) {
            // 从左往右找到第一个大于start的
            while (left <= end && nums[left] <= nums[end]) {
                left++;
            }
            // 从右往左找到第一个小于start的
            while (left <= end && nums[end] > nums[left]) {
                end--;
            }
            // 交换
            if (left <= end) {
                swap(nums, left, end);
            }
        }

        // 把start插入正确位置
        swap(nums, pivot, left);
        return end;
    }

    private void sortHelper(int[] nums, int start, int end) {

        int mid = partition(nums, start, end);
        sortHelper(nums, start, mid - 1);
        sortHelper(nums, mid, end + 1);
    }

    public void sort(int[] nums) {
        sortHelper(nums, 0, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
