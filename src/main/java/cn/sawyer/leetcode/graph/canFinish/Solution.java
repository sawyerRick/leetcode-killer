package cn.sawyer.leetcode.graph.canFinish;

import java.time.Year;
import java.util.*;

/**
 * @program: LeetCode
 * @description: 课程表, https://leetcode-cn.com/problems/course-schedule/
 * @author: sawyer
 * @create: 2020-01-08 15:22
 **/

// 检测AOV网中是否存在环：进行拓扑排序，若所有顶点都在拓扑有序序列中，则不存在环。
// 拓扑排序：1.找出入度为0的顶点 2.删除该顶点和该顶点的边

    // 并查集检查无向环
    // 拓扑排序检查有向环
public class Solution {
    // 数据结构：边缘列表（边构成的列表）
    // 算法：拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];

        // 初始化入度
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
        }

        // bfs (一般需要一个队列)
        Queue<Integer> q = new LinkedList<>();
        // 初始化入度为0的顶点
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.remove();
            ans.add(curr);

            for (int[] p : prerequisites) {
                if (p[1] == curr) {
                    inDegree[p[0]]--;
                    // 检查入度为0
                    if (inDegree[p[0]] == 0) {
                        q.add(p[0]);
                    }
                }
            }
        }

        System.out.println("size:" + ans.size());

        return ans.size() == numCourses;
    }

    // 重写
    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        // 入度
        int[] inDegree = new int[numCourses];

        // 初始化入度
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        // 找到入度为0的顶点
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 拓扑排序
        while (!queue.isEmpty()) {
            int node = queue.remove();
            ans.add(node);
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == node) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return ans.size() == numCourses;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
