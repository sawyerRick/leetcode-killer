package cn.sawyer.leetcode.convertToBase7;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 七进制数，https://leetcode-cn.com/problems/base-7/
 * @author: sawyer
 * @create: 2020-01-17 17:48
 **/
public class Solution {

    // 十进制转二进制：
    // 正数：除二取余，然后倒序排列，高位补零。
    // 负数：正整数转换成二进制后，对二进制取反，然后对结果再加一
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int fin = Math.abs(num);
        int remain = 0; // 余数
        while (fin != 0) {
            remain = fin % 7;
            fin = fin / 7;
            sb.append(remain);
        }
        String ans = sb.reverse().toString();

        return num > 0?ans: "-" + ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(100));
    }
}
