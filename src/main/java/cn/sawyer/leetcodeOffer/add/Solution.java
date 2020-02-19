package cn.sawyer.leetcodeOffer.add;

/**
 * @program: LeetCode
 * @description: 不用加减乘除做加法，https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @author: sawyer
 * @create: 2020-02-16 14:58
 **/
public class Solution {

    // 位运算
    public int add(int a, int b) {

        int carry;
        int tmp;
        do {
            carry = (a & b) << 1;
            tmp = a ^ b;
            a = carry;
            b = tmp;
        } while (carry != 0);

        return tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.add(342345, 3452345);
        System.out.println(a);
    }
}
