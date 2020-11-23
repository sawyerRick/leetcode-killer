package interview.ali2;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-20 09:10
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        in.nextLine();
        int[][] verbs = new int[num][3];
        for (int i = 0; i < num; i++) {
            String vb = in.nextLine();
            verbs[i][0] = vb.charAt(0) - 'a';
            verbs[i][1] = vb.charAt(vb.length() - 1) - 'a';
            verbs[i][2] = vb.length();
        }

        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = verbs[0][2];
        for (int i = 2; i <= num; i++) {
            if (verbs[i - 1][0] >= verbs[i - 1 - 1][1]) {
                dp[i] = dp[i - 1] + verbs[i - 1][2];
            } else {
                dp[i] = Math.max(dp[i - 1], verbs[i - 1][2]);
            }
        }
        for (int i : dp) {
            System.out.println(i);
        }

        System.out.println(dp[num]);
    }
}
