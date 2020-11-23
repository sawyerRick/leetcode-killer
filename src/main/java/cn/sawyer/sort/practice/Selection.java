package cn.sawyer.sort.practice;

/**
 * @program: LeetCode
 * @description: 选择排序
 * @author: sawyer
 * @create: 2020-03-18 14:58
 **/
public class Selection {

    public void sort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(nums, i, minIdx);
        }

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
