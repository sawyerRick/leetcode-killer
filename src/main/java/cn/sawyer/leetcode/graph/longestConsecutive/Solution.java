package cn.sawyer.leetcode.graph.longestConsecutive;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 最长连续序列，https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @author: sawyer
 * @create: 2020-01-20 14:44
 **/
public class Solution {

    // O(n) 哈希表
    public int longestConsecutive3(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }



    // 排序
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int max = 1;
        int seq = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i - 1] == nums[i] - 1) {
                seq++;
            } else {
                max = Math.max(max, seq);
                seq = 1;
            }
        }
        max = Math.max(max, seq);

        return max;
    }



    // 并查集 超时，时间复杂度太高
    HashMap<Integer, Integer> parent;

    // find root
    int findRoot(int index) {

        if (parent.get(index) == Integer.MIN_VALUE) {
            return index;
        }

        return findRoot(parent.get(index));
    }

    // union
    void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);


        if (xRoot != yRoot) {
            // xRoot的parent是yRoot
//            System.out.println(xRoot + "的parent是" + yRoot);
            parent.put(xRoot, yRoot);
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        parent = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            parent.put(nums[i], Integer.MIN_VALUE);
        }

        for (int i = 0; i < nums.length; i++) {
            if (parent.containsKey(nums[i] - 1)) {

                union(nums[i], nums[i] - 1);
            }
        }

        int max = 1;

        for (int num : nums) {
            System.out.println(num - findRoot(num) + 1);
            max = Math.max(num - findRoot(num) + 1, max);
        }

        return max;
    }
}