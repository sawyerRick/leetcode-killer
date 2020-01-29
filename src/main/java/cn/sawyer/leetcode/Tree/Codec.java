package cn.sawyer.leetcode.Tree;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 二叉树序列化与反序列化，https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @author: sawyer
 * @create: 2020-01-10 15:08
 **/

// 序列化格式：bfs，dfs 显然，我们需要有顺序的序列，所以选择dfs;
public class Codec {

    public void dfs(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val).append(",");
            dfs(node.left, sb);
            dfs(node.right, sb);
        } else {
            sb.append("null").append(",");
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        System.out.println(sb.toString());

        return sb.toString();
    }

    // 反dfs
    public TreeNode rdfs(Queue<String> list) {
        String s = list.remove();
        if (s.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(s));

        node.left = rdfs(list);
        node.right = rdfs(list);

        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] chars = data.split(",");
        Queue<String> list = new LinkedList<>(Arrays.asList(chars));

        return rdfs(list);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.serialize(null));
    }


}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
