package cn.sawyer.leetcode.addBinary;

import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 36进制加法
 * @author: sawyer
 * @create: 2020-02-10 18:59
 **/
public class Solution2 {
    static Character[] nums = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
    static List<Character> list = Arrays.asList(nums);

    public String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int i1 = p1 >= 0 ? list.indexOf(num1.charAt(p1)) : 0;
            int i2 = p2 >= 0 ? list.indexOf(num2.charAt(p2)) : 0;
            int tmp = i1 + i2 + carry;
            carry = tmp / 36; // 进位 除法
            sb.append(list.get(tmp % 36)); // 结果 % 法
            p1--;
            p2--;
        }
        sb.append(carry == 0 ? "" : 1);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.add("9", "r"));
    }
}
