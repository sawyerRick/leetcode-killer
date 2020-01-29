package cn.sawyer.nowcode.Fibonacci;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-01-01 16:24
 **/
public class Solution {
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n < 2) {
            return 1;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(2));
    }
}
