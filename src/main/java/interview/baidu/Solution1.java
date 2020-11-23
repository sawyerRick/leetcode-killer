package interview.baidu;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-29 19:25
 **/
public class Solution1 {

    // 思路：其他数字+1等于n-1
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = 0;
        if (in.hasNext()) {
           n = in.nextInt();
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (in.hasNext()) {
                nums[i] = in.nextInt();
            }
        }

        in.close();

        int time = 0;

        // 遍历，每减一次，n-1
        while (true) {
            boolean into = false;
            for (int i = 0; i < n; i++) {
                // 需要减
                if (nums[i] >= n) {
                    nums[i] -= n;
                    n--; // 其他+1等于n-1
                    time++;
                    into = true;
                }
            }
            // 完成任务
            if (!into) {
                break;
            }
            // 未完成任务
            if (n <= 0) {
                break;
            }
        }
        System.out.println(time);
    }
}