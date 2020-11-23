package cn.sawyer.leetcode.compressString;

import java.util.*;
/**
 * @program: LeetCode
 * @description: 字符串压缩，https://leetcode-cn.com/problems/compress-string-lcci/
 * @author: sawyer
 * @create: 2020-03-16 11:26
 **/
public class Solution {
    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        char ch = S.charAt(0);
        int count = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                sb.append(ch).append(count);
                count = 0;
            }
            ch = S.charAt(i);
        }
        sb.append(ch).append(count);

        return sb.toString().length() >= S.length() ? S : sb.toString();
    }
}