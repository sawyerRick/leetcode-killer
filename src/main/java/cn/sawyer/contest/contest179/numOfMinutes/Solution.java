package cn.sawyer.contest.contest179.numOfMinutes;

/**
 * @program: LeetCode
 * @description: 通知所有员工需要的时间，https://leetcode-cn.com/problems/time-needed-to-inform-all-employees/
 * @author: sawyer
 * @create: 2020-03-08 13:50
 **/
public class Solution {

    // 自底向上
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        int ans = 0;

        // i：i号员工
        for (int i = 0; i < manager.length; i++) {

            // 从叶子开始
            if (informTime[i]  == 0) {
                int index = manager[i];
                int time = 0;
                while (index != -1) {
                    time += informTime[index];
                    index = manager[index];
                }
                ans = Math.max(ans, time);
            }
        }

        return ans;
    }
}