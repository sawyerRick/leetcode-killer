package cn.sawyer.leetcodeOffer.verifyPostorder;

/**
 * @program: LeetCode
 * @description: 二叉搜索树的后序遍历验证，https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @author: sawyer
 * @create: 2020-02-15 16:41
 **/
public class Solution {
    public boolean verifyPostorder(int[] postorder) {

        for (int i = 0; i < postorder.length - 2; i += 2) {
            if (postorder[i] > postorder[i + 1] || postorder[i + 1] > postorder[i + 2]) {
                return false;
            }
        }


        return true;
    }
}
