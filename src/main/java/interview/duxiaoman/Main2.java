package interview.duxiaoman;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-04-20 16:50
 **/
public class Main2 {

    int A, B, C, D;

    public Main2(int a, int b, int c, int d, int[] nums) {
        A = a;
        B = b;
        C = c;
        D = d;
        this.nums = nums;
    }

    static int min = Integer.MAX_VALUE;
    int[] nums;

    public void backtrack(int curr, int cost) {
        if (curr == 1) {
            min = Math.min(cost, min);
        }
        // 找到最近的绝对值
        int nowNext = nums[curr];
        // 最近可以去的点
        int m = Integer.MAX_VALUE;

    }

    // 贪心（从尾到头） + 回溯
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] nums = new int[N + 1];
        for (int i = 1; i <= nums.length; i++) {
            nums[i + 1] = sc.nextInt();
        }
        Main2 main2 = new Main2(A, B, C, B, nums);
        main2.backtrack(N, 0);
        System.out.println(min);
    }
}
