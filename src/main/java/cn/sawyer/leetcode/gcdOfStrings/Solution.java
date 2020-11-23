package cn.sawyer.leetcode.gcdOfStrings;

/**
 * @program: LeetCode
 * @description: 字符串最大公因子，https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/solution/
 * @author: sawyer
 * @create: 2020-03-12 10:13
 **/
public class Solution {

    public String gcdOfStrings(String str1, String str2) {

        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}