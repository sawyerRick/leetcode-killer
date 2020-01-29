package cn.sawyer.leetcode.bitOperation;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-09 13:30
 **/
public class Main {
    public static void main(String[] args) {

        // 交换两个数字
//        int a = 1, b = 2;
//        a ^= b;
//        b ^= a;
//        a ^= b;
//
//        System.out.println("a  = " + a);
//        System.out.println("b = " + b);
//
        System.out.println(abs(-99));

    }

    // 取绝对值
    public static int abs(int num) {
        // 取符号位
        int c = num >> 31;

        return c == 0 ? c : (~num + 1);
    }

    // 变换符号 取反加1
    public static int reverse(int num) {
        return (~num) + 1;
    }

    // 判断奇偶数(位运算取最后一位来操作)
    public static boolean checkOdd(int num) {
        if ((num & 1) == 1) {
            return true;
        }

        return false;
    }
}
