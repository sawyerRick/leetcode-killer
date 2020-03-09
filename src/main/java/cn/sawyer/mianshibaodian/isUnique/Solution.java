package cn.sawyer.mianshibaodian.isUnique;

/**
 * @program: LeetCode
 * @description: 判断字符串唯一，https://leetcode-cn.com/problems/is-unique-lcci/
 * @author: sawyer
 * @create: 2020-03-05 15:32
 **/
public class Solution {
    public boolean isUnique(String astr) {

        int flag = 0;
        for (int i = 0; i < astr.length(); i++) {
            int index = astr.charAt(i) - 'a';
            if (((flag >>> index) & 1) == 1) {
                return false;
            } else {
                flag |= 1 << index;
            }
        }

        return true;
    }
}