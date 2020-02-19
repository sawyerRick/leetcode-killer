package cn.sawyer.leetcodeOffer.replaceSpace;

/**
 * @program: LeetCode
 * @description: 替换空格，https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @author: sawyer
 * @create: 2020-02-12 19:25
 **/
class Solution {
    public String replaceSpace(String s) {

        return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println("    ".replaceAll("\\s+", "1"));
    }
}