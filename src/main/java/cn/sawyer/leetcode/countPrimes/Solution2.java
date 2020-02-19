package cn.sawyer.leetcode.countPrimes;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 丑数，https://leetcode-cn.com/problems/ugly-number/
 * @author: sawyer
 * @create: 2020-02-07 18:58
 **/
public class Solution2 {

    public boolean isUgly(int num) {
        if(num == 0){
            return false;
        }
        while (num != 1){
            if(num % 2 == 0){
                num /= 2;
                continue;
            }
            if(num % 3 == 0){
                num /= 3;
                continue;
            }
            if(num % 5 == 0){
                num /= 5;
                continue;
            }
            return false;
        }

        return true;
    }
}
