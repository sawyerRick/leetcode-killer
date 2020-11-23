package cn.sawyer.leetcode.canThreePartsEqualSum;

/**
 * @program: LeetCode
 * @description: 将数组分为和相等的三个部分，https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * @author: sawyer
 * @create: 2020-03-11 19:13
 **/
public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }

        int count = 0;
        int subSum = 0;
        for (int i = 0; i < A.length; i++) {
            subSum += A[i];
            if (subSum == sum / 3) {
                subSum = 0;
                count++;
            }

            if (count == 3) {
                return true;
            }
        }

        return false;
    }
}
