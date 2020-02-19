package cn.sawyer.leetcode.sort.myversion;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-11 17:50
 **/
public class QuickSortMy {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static int partition(int[] nums, int l, int h) {
        int i = l + 1;
        int j = h;

        while (i <= j) {
            while (i <= j && nums[i] < nums[l]) {
                i++;
            }

            while (i <= j && nums[j] >= nums[l]) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
            }
        }
        swap(nums, l, j);

        return j;
    }

    private static void sort(int[] nums, int l, int h) {
        if (l >= h) {
            return;
        }

        int mid = partition(nums, l, h);
        sort(nums, l, mid - 1);
        sort(nums, mid + 1, h);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 4, 3, 1, 6, 7, 9, 4, 5, 0, 10, 5};
        QuickSortMy.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
