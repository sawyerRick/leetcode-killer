package cn.sawyer.leetcode.graph.cloneGraph;

import cn.sawyer.leetcode.graph.Node;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 克隆图，https://leetcode-cn.com/problems/clone-graph/
 * @author: sawyer
 * @create: 2020-01-08 15:26
 **/
public class Solution {
    // dfs
    public Node cloneGraph(Node node) {
        Map<Node, Node> lookup = new HashMap<>(); // 记录已访问的点
        return dfs(node, lookup);
    }

    private Node dfs(Node node, Map<Node,Node> lookup) {
        if (node == null) {
            return null;
        }
        if (lookup.containsKey(node)) {
            return lookup.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors){
            clone.neighbors.add(dfs(n,lookup));
        }
        return clone;
    }


    // bfs
    public Node cloneGraph2(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            for (Node nb : curr.neighbors) {
                if (!map.containsKey(nb)) {
                    map.put(nb, new Node(nb.val, new ArrayList<>()));
                    queue.add(nb);
                }
                map.get(curr).neighbors.add(map.get(nb));
            }
        }

        return clone;
    }
}
