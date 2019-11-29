/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-09-23 21:17
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(node));
    }
}
