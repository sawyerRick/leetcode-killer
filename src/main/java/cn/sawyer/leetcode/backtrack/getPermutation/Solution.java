package cn.sawyer.leetcode.backtrack.getPermutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 第K个排列
 * @author: sawyer
 * @create: 2020-02-17 13:49
 **/
public class Solution {

    LinkedList<String> list = new LinkedList<>();
    StringBuilder curr = new StringBuilder();
    int k;
    int n;

    void backtrack() {
        if (curr.length() == n) {
            list.add(curr.toString());
            return;
        }

        if (list.size() == k) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (curr.indexOf(i + "") == -1) {
                curr.append(i);
                backtrack();
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;

        backtrack();

        return list.get(k - 1);
    }

}
