package cn.sawyer.leetcodeOffer.strToInt;

/**
 * @program: LeetCode
 * @description: 字符串转整数，https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * @author: sawyer
 * @create: 2020-02-27 12:43
 **/
public class Solution {
    int sign = 1;
    // 清理字符
    public int strToInt(String str) {

        int p = 0;
        // 找到开头
        while (p < str.length()) {
            char c = str.charAt(p);
            // 开头可以是空格，-，数字，不能是字母
            if (c == ' ') {
                p++;
            } else if (c == '+' || c == '-' || (c - '0' >= 0 && c - '0' <= 9)) {
                if (c == '-') {
                    p++;
                    sign = -1;
                } else if (c == '+') {
                    p++;
                }
                break;
            } else {
                return 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        // 从开头遍历
        while (p < str.length()) {
            char c = str.charAt(p);
            if (c - '0' >= 0 && c - '0' <= 9) {
                sb.append(c);
                p++;
            } else {
                break;
            }
        }


        return s2i(sb.toString());
    }

    // 转换
    Integer s2i(String s) {
        System.out.println(s);
        long sum = 0;
        int digit;
        // 倒序，不断*10
        for (int i = 0; i < s.length(); i++) {
            digit = s.charAt(i) - '0';
            sum *= 10;
            sum += digit;
            if (sum * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sum * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int)(sum * sign);
    }
}
