package cn.sawyer.leetcode.graph;

import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-01-08 15:26
 **/
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};