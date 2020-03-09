package cn.sawyer.leetcodeOffer.findContinuousSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-06 11:11
 **/

// 在写一遍
public class Solution2 {

    public int[][] findContinuousSequence(int target) {

        int low = 1;
        int high = 2;
        int sum = low + high;
        List<int[]> list = new ArrayList<>();

        while (low < high && high < target) {

            if (sum < target) {
                sum += ++high;
            } else if (sum > target) {
                sum -= low;
                low++;
            } else if (sum == target) {
                int[] subAns = new int[high - low + 1];
                int idx = 0;
                for (int i = low; i <= high; i++) {
                    subAns[idx++] = i;
                }
                list.add(subAns);
                sum += ++high;
            }
        }

        return list.toArray(new int[0][]);
    }
}