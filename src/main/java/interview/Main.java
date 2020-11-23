package interview;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        double base = 0.01;
        double[] dp = new double[num + 1];
        dp[0] = 0;
        dp[1] = 0.01;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + base * i / 1000;
            System.out.println(dp[i]);
        }
        System.out.println(dp[num]);

    }
}