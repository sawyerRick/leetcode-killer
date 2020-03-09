package cn.sawyer.leetcode.distributeCandies;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-05 14:30
 **/
public class Solution {

    public int[] distributeCandies(int candies, int num_people) {

        int[] ans = new int[num_people];
        int index = 0;
        int num = 1;
        while (candies > 0) {
            index = index % num_people;
            ans[index] += Math.min(candies, num);
            candies -= num;
            num++;
            index++;
        }


        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.distributeCandies(10, 3);
    }
}