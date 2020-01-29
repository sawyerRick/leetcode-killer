package cn.sawyer.leetcode.graph.findCircleNum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 朋友圈数量，https://leetcode-cn.com/problems/friend-circles/solution/peng-you-quan-by-leetcode/
 * @author: sawyer
 * @create: 2020-01-07 16:20
 **/

// 邻接矩阵：矩阵，
// 邻接表：顶点相邻的表，
// 边缘列表：边构成的表
public class Solution {

    // bfs 邻接矩阵
    public int findCircleNum3(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue< Integer > queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }


    // dfs 邻接矩阵
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    // 并查集
    int[] parent;
    int findRoot(int index) {
        if (parent[index] != -1) {
            index = findRoot(parent[index]);
        }

        return index;
    }

    void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        // 已经连通
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;
    }

    public int findCircleNum(int[][] M) {
        parent = new int[M.length];
        Arrays.fill(parent, -1);

        for (int i = 0; i < M.length; i++) {
            for (int j = i; j < M.length; j++) {
                if (i != j && M[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }

        return count;
    }


    public static void main(String[] args) {

        Solution s = new Solution();
        int i = s.findCircleNum(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 0}});
        System.out.println(i);
    }


}
