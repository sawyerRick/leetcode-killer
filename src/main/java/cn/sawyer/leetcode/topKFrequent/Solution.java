package cn.sawyer.leetcode.topKFrequent;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 前K个高频元素，https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @author: sawyer
 * @create: 2020-01-20 16:17
 **/
public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // 记录
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(list.get(i).getKey());
        }


        return ans;
    }
}
