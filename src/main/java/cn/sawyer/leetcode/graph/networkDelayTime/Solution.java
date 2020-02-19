package cn.sawyer.leetcode.graph.networkDelayTime;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 网络延迟时间，https://leetcode-cn.com/problems/network-delay-time/
 * @author: sawyer
 * @create: 2020-01-31 15:01
 **/
public class Solution {

    int[][] times;
    int[] fast;

    // dfs
    void dfs(int curr, int N, int t) {
        for (int i = 0; i < times.length; i++) {
            // 找转播点
            // 如果有跟快的到达过，就不需要传播了。
            if (times[i][0] == curr && times[i][2] < fast[times[i][1]]) {
                System.out.println("curr:" + curr + " dst:" + times[i][1] + " w:" + times[i][2]);
                fast[curr] = times[i][2] + t;
                dfs(times[i][1], N, t + times[i][2]);
            }
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        this.times = times;
        this.fast = new int[N + 1];
        Arrays.fill(fast, Integer.MAX_VALUE);

        dfs(K, N, 0);

        for (int i = 1; i <= N; i++) {
            System.out.println(fast[i]);
        }

        return 1;
    }
}
