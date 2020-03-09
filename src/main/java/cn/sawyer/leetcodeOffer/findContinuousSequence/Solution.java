package cn.sawyer.leetcodeOffer.findContinuousSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 和为s的连续正数序列，https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @author: sawyer
 * @create: 2020-02-27 11:32
 **/
public class Solution {
    // 滑动窗口
    public int[][] findContinuousSequence(int target) {

        List<int[]> list = new ArrayList<>();

        int low = 1;
        int high = 2;
        int sum = low + high;

        while (low < high && high < target) {

            if (sum < target) {
                sum += ++high;
            } else if (sum > target) {
                sum -= low++;
            } else {
                int[] sub = new int[high - low + 1];
                int idx = 0;
                for (int i = low; i <= high; i++) {
                    sub[idx++] = i;
                }
                list.add(sub);
                sum += ++high;
            }
        }


        return list.toArray(new int[0][]);
    }
}