package cn.sawyer.leetcode.jump;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-20 00:09
 **/
public class Solution {
    public int jump2(int[] nums) {
        int max = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (end == i) {
                step++;
                end = max;
            }
        }


        return step;
    }




















    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.jump2(new int[]{2, 0});
        System.out.println("i = " + i);
    }
}
