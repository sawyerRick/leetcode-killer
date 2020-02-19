package cn.sawyer.leetcode.addStrings;

/**
 * @program: LeetCode
 * @description: 字符串相加
 * @author: sawyer
 * @create: 2020-01-30 15:32
 **/
public class Solution {

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
