package cn.sawyer.nowcode.NumberOf1;

/**
 * @program: LeetCode
 * @description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author: sawyer
 * @create: 2020-01-02 16:24
 **/
public class Solution {
    public int NumberOf1(int n) {
        System.out.println(-1 >>> 1);

        int ans = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans++;
            }
            n = n >>> 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.NumberOf1(-1);
        System.out.println(a);
    }
}
