package cn.sawyer.leetcode.subarraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-26 19:07
 **/


public class Solution {

    // 哈希表，记录所有的累积，累积发生的次数
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    // 暴力
    public int subarraySum2(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int subSum = 0;
            for (int j = i; j < nums.length; j++) {
                subSum += nums[j];
                if (subSum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}