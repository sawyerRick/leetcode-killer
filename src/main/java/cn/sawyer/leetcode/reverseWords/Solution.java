package cn.sawyer.leetcode.reverseWords;

/**
 * @program: LeetCode
 * @description: 翻转字符串中的单词3，https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @author: sawyer
 * @create: 2020-02-17 14:51
 **/
public class Solution {

    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
}