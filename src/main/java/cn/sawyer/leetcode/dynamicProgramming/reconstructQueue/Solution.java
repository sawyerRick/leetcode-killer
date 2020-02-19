package cn.sawyer.leetcode.dynamicProgramming.reconstructQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 重建身高队列，https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @author: sawyer
 * @create: 2020-01-31 13:14
 **/
public class Solution {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }

        return output.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(0, 1);
        list.add(0, 2);
        System.out.println(list.size());
        System.out.println(list.get(1));
    }
}
