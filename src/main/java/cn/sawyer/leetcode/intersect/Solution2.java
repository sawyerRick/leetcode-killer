package cn.sawyer.leetcode.intersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 交集2，https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @author: sawyer
 * @create: 2020-02-27 11:18
 **/
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] == nums2[right]) {
                list.add(nums1[left]);
                left++;
                right++;
            } else if (nums1[left] < nums2[right]) {
                left++;
            } else {
                right++;
            }
        }

        while (left < nums1.length) {
            list.add(nums1[left++]);
        }

        while (right < nums2.length) {
            list.add(nums2[right++]);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}