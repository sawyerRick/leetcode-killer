package interview.wanmei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-17 19:50
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = in.nextInt();
        int[][] nums = new int[line][2];
        for (int i = 0; i < line; i++) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            if (n1 < n2) {
                nums[i][0] = n1;
                nums[i][1] = n2;
            } else {
                nums[i][0] = n2;
                nums[i][1] = n1;
            }
        }
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < line; i++) {
            System.out.println(nums[i][0] + "," + nums[i][1]);
        }
        int count = 1;
        int max = 0;
        for (int i = 1; i < line; i++) {
            if (nums[i][0] <= nums[i - 1][0] && nums[i][1] <= nums[i - 1][1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        System.out.println(max);
    }
}