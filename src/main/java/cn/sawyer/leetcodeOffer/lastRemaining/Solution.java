package cn.sawyer.leetcodeOffer.lastRemaining;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 圆圈中最后剩下的数字，https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @author: sawyer
 * @create: 2020-02-12 21:27
 **/
public class Solution {

    // 数学归纳
    // f(i) = (f(i-1) + n ) % i
    public int lastRemaining2(int n, int m) {
        int count = 0;
        for (int i = 2; i < n + 1; i++) {
            count = (count + m) % i;
        }
        return count;
    }

    // 模拟
    public int lastRemaining(int n, int m) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int curr = -1;
        while (list.size() > 1) {
            curr += m;
            curr %= list.size();
            int c = list.remove(curr);
            System.out.println(c);
            curr--;
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.lastRemaining(5, 3);
    }
}
