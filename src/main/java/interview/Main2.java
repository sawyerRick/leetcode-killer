package interview;

import java.util.Scanner;


public class Main2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num == 0) {
            System.out.println(0);
            return;
        }
        long[] dp = new long[num + 1];
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            if (i >= 4) {
                dp[i] = dp[i - 1] + dp[i - 4];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(dp[num]);
    }
}