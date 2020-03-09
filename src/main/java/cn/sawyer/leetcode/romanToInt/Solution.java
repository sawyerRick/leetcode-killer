package cn.sawyer.leetcode.romanToInt;

/**
 * @program: LeetCode
 * @description: 罗马数字转整数，https://leetcode-cn.com/problems/roman-to-integer/
 * @author: sawyer
 * @create: 2020-02-27 10:33
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
 */
public class Solution {

    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }

//        "MCDLXXVI" 1476
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = map.get(s.charAt(i));

            if (i < s.length() - 1 && left < map.get(s.charAt(i + 1))) {
                sum -= left;
            } else {
                sum += left;
            }
        }

        return sum;
    }
}
