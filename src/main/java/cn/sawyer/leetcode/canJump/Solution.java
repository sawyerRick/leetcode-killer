package cn.sawyer.leetcode.canJump;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-19 23:41
 **/
class Solution {
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        int good = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= good) {
                good = i;
            }
        }

        return good == 0;
    }



    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        List<Integer> terminals = new ArrayList<>();
        terminals.add(nums.length - 1);

        for (int i = nums.length - 2; i >= 0; i--) {
            int size = terminals.size();
            for (int j = 0; j < size; j++) {
                if (i + nums[i] >= terminals.get(j)) {
                    terminals.add(i);
                    break;
                }
            }
        }

        if (terminals.contains(0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2, 0}));
    }
}
