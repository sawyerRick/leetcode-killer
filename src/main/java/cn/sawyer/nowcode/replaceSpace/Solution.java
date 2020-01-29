package cn.sawyer.nowcode.replaceSpace;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-01-01 15:56
 **/
public class Solution {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }
}
