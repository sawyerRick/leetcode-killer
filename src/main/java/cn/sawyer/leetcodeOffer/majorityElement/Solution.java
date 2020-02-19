package cn.sawyer.leetcodeOffer.majorityElement;


import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 数组中出现次数大于一半的数字，https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @author: sawyer
 * @create: 2020-02-15 15:20
 **/
public class Solution {


    // 投票法，众数为1，其他为0，加起来大于0
    public int majorityElement2(int[] nums) {

        int ans = 0;
        int curr = 0;
        for (int i : nums) {
            if (curr == 0) {
                ans = i;
            }
            curr += ans == i ? 1 : -1;
        }

        return ans;
    }


    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
