package cn.sawyer.leetcode.backtrack.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-20 16:48
 **/
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    private void backtrack(int n, int k, List<Integer> list, int f) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = f; i <= n; i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            backtrack(n, k, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, new ArrayList<>(), 1);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combine(4, 2);
        for (List<Integer> a : lists) {
            for (Integer integer : a) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
