package cn.sawyer.leetcodeOffer.verifyPostorder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: LeetCode
 * @description: 二叉搜索树的后序遍历验证，https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @author: sawyer
 * @create: 2020-02-15 16:41
 **/
public class Solution {

    // 当前：end肯定为根节点
    public boolean verifyPostorder(int[] postorder) {

        return dfs(postorder, 0, postorder.length - 1);
    }

    boolean dfs(int[] tree, int start, int end) {
        if (start >= end) {
            return true;
        }

        int right = start;
        while (right < end) {
            // 找到右子树起点
            if (tree[right] > tree[end]) {
                break;
            }
            right++;
        }

        // 验证
        for (int i = right; i < end; i++) {
            if (tree[i] < tree[end]) {
                return false;
            }
        }

        return dfs(tree, start, right - 1) && dfs(tree, right + 1, end - 1);
    }
}
