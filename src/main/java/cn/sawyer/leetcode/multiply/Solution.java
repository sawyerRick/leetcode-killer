package cn.sawyer.leetcode.multiply;

/**
 * @program: LeetCode
 * @description: 字符串相乘，https://leetcode-cn.com/problems/multiply-strings/
 * @author: sawyer
 * @create: 2020-01-30 15:27
 **/
public class Solution {
    // 模拟乘法
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int p2 = num2.length() - 1;
        String ans = "0";

        for (; p2 >= 0; p2--) {
            int i2 = num2.charAt(p2) - '0';

            int carry = 0;
            StringBuilder sub = new StringBuilder();
            for (int k = 0; k < num2.length() - 1 - p2; k++) {
                sub.append('0');
            }
            for (int p1 = num1.length() - 1; p1 >= 0 || carry != 0; p1--) {
                int i1 = p1 < 0 ? 0 : num1.charAt(p1) - '0';
                int product = (i1 * i2 + carry) % 10;
                sub.append(product);
                carry = (i1 * i2 + carry) / 10;
            }
            ans = addStrings(ans, sub.reverse().toString());
        }

        return ans;
    }

    // 模拟加法
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        int ac = 0;
        for (; p1 >= 0 || p2 >=0 ; p1--, p2--) {
            int i1 = p1 >= 0? num1.charAt(p1) - '0': 0;
            int i2 = p2 >= 0? num2.charAt(p2) - '0': 0;
            int tmp = ac + i1 + i2;
            ac = tmp / 10;
            sb.append(tmp % 10);
        }

        if (ac == 1) {
            sb.append(ac);
        }

        return sb.reverse().toString();
    }
}
