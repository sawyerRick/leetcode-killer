package cn.sawyer.leetcode.backtrack.letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @program: LeetCode
 * @description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。url:https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @author: sawyer
 * @create: 2019-12-27 19:44
 **/
public class Solution {
    List<String> result = new ArrayList<>();
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            result.add(combination);
            return;
        }

        String chars = phone.get(next_digits.substring(0, 1));
        for (int i = 0; i < chars.length(); i++) {
            backtrack(combination + chars.substring(i, i + 1), next_digits.substring(1));
        }


    }

    public List<String> letterCombinations(String digits) {
        backtrack("", digits);

        return result;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String letterCombination : solution.letterCombinations("42344")) {
            System.out.println(letterCombination);
        }

    }
}
