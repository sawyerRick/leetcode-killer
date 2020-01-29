
package cn.sawyer.leetcode.addBinary;

/**
 * @program: LeetCode
 * @description: 二进制求和，https://leetcode-cn.com/problems/add-binary/
 * @author: sawyer
 * @create: 2020-01-20 23:36
 **/

public class Solution {


    // 思路：对短的字符串补0使两字符串长度一致
    // 从末尾开始遍历计算结果
    // 计算时直接拼接字符串，最后翻转
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");

        return ans.reverse().toString();
    }
}
