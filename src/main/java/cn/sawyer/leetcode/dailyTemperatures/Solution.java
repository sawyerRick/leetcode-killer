package cn.sawyer.leetcode.dailyTemperatures;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 每日温度，https://leetcode-cn.com/problems/daily-temperatures/
 * @author: sawyer
 * @create: 2020-01-29 17:36
 **/
public class Solution {


    // 单调栈 逆序遍历
    public int[] dailyTemperatures2(int[] T) {

        Stack<Integer> stack = new Stack<>();
        stack.push(T.length - 1);

        int[] ans = new int[T.length];

        for (int i = T.length - 2; i >= 0; i--) {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            ans[i] = stack.isEmpty()? 0 :stack.peek()-i;
            // 当前元素进栈
            stack.push(i);
        }

        return ans;
    }


    // 暴力解法
    public int[] dailyTemperatures(int[] T) {

        int[] ans = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }

        return ans;
    }
}
