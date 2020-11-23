package cn.sawyer.sort.practice;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-18 09:54
 **/
public class Bubble {

    public void sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
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
