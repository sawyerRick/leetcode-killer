package cn.sawyer.leetcode.gcd;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-03 15:34
 **/
public class Solution {
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        System.out.println("p:" + p + " q:" + q + " r:" + r);


        return gcd(q, r);
    }


    public static void main(String[] args) {
        System.out.println(gcd(1111111, 1234567 ));
    }

}
