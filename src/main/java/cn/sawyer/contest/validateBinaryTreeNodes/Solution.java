package cn.sawyer.contest.validateBinaryTreeNodes;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-23 10:42
 **/
public class Solution {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        Set<Integer> seen = new HashSet<>();

        int edge = 0;
        int ref = 0;

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                edge++;
                ref++;
            }
            if (rightChild[i] != -1) {
                edge++;
                ref++;
            }

        }

        return edge == n - 1 && ref == n -1;
    }
}