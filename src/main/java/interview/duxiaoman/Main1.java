package interview.duxiaoman;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-04-20 16:34
 **/
public class Main1 {
    // 暴力滑动窗口

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = 0;
        int n = sc.nextInt(); // 行
        int m = sc.nextInt(); // 列
        int a = sc.nextInt(); // 行
        int b = sc.nextInt(); // 列

        int ans = 0;
        for (int i = 1; i <= n - a + 1; i++) {
            for (int j = 1; j <= m - b + 1; j++) {
                int max = 0;
                if (j == 1) {
                    for (int bi = j; bi <= b + m; bi++) {
                        for (int ai = i; ai <= a + n; ai++) {
                            int num = (ai * bi) % 10;
                            max = Math.max(num, max);
                        }
                    }
                } else {
                    // 优化，只需要遍历列
                    for (int k = a + i; k <= a + i + b; k++) {
                        int num = (k * j) % 10;
                        max = Math.max(num, max);
                    }
                }
                ans += max;
            }
        }
        System.out.println(ans);

    }
}
