package cn.sawyer.leetcode.findPoisonedDuration;

/**
 * @program: LeetCode
 * @description: 提莫攻击，https://leetcode-cn.com/problems/teemo-attacking/
 * @author: sawyer
 * @create: 2020-01-07 14:03
 **/
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = timeSeries.length == 0 ? 0 : duration;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            int gap = timeSeries[i + 1] - timeSeries[i];
            if (gap < duration) {
                ans += gap;
            } else {
                ans += duration;
            }
        }

        System.out.println(ans);

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findPoisonedDuration(new int[]{1, 3, 6}, 2);
    }
}
