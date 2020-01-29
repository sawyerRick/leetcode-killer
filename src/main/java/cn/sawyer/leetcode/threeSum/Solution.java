package cn.sawyer.leetcode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-17 14:29
 **/
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重

            if (nums[i] > 0) {
                return result;
            }

            while (l < r) {
                int target = nums[i] + nums[l] + nums[r];
                if (target == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                    l++;
                } else if (target > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{0,0,0,0});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }

    }

    // 去重问题未解决
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int target = 0 - nums[i] - nums[j];
                if (map.containsKey(target) && map.get(target) != i && map.get(target) != j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target);
                    result.add(list);
                }
            }
        }


        return result;
    }
}
