package cn.sawyer.leetcode.decodeString;

/**
 * @program: LeetCode
 * @description: 字符串解码，https://leetcode-cn.com/problems/decode-string/
 * @author: sawyer
 * @create: 2020-02-19 17:00
 **/

import java.util.LinkedList;

/**
 * 解法一
 *
 * 利用2个栈，一个数字栈numStack，一个字母栈strStack

 * **/
class Solution {

    public String decodeString(String s) {
        //初始化
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 数字
            if (c <= '9' && c >= '0') {
                num = num * 10 + c - '0';
            } else if ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')) {
                // 字母
                sb.append(c);
            } else if (c == '[') {
                // 入栈
                numStack.push(num);
                strStack.push(sb.toString());
                sb = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                // 出栈
                int times = numStack.pop();
                StringBuilder pre = new StringBuilder(strStack.pop());
                for (int j = 0; j < times; j++) {
                    pre.append(sb);
                }
                sb = pre;
            }
        }


        return sb.toString();
    }
}