package cn.sawyer.contest.contest179.generateTheString;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-08 10:44
 **/
public class Solution {

    public String generateTheString(int n) {

        if (n == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int len = n % 2 == 0? n - 1: n;

        for (int i = 0; i < len; i++) {
            sb.append("a");
        }

        if (len < n) {
            sb.append("x");
        }


        return sb.toString();
    }
}
