package cn.sawyer.leetcode.repeatedNTimes;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-02 10:35
 **/
public class Solution {

    public int repeatedNTimes(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] == A[i + 1] || A[i] == A[i + 2]) {
                return A[i];
            }
        }


        return A[A.length - 1];
    }
}