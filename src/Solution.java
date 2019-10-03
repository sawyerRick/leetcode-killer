import javafx.util.Pair;

import java.util.*;

/**
 **/
public class Solution {

    /**
     * 是否是2的幂次方
     * url: https://leetcode-cn.com/problems/power-of-two/
     */
    public boolean isPowerOfTwo(int n) {
//        log2N=logeN/loge2
//        Double ans = Math.log(n) / Math.log(2);
//        System.out.println(ans.intValue());

        // 位运算
        // 2的幂的二进制只有一位是1

        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * 爬楼梯
     * url: https://leetcode-cn.com/problems/climbing-stairs/
     */
    public int climbStairs(int n) {
        // 动态规划
        // n阶的方法数等于n-1的方法数加上n-2的方法数
        if (n == 1){
            return 1;
        }

        int[] ms = new int[n + 1];
        ms[1] = 1;
        ms[2] = 2;
        int i = 3;
        for (; i <= n; i++) {
            ms[i] = ms[i - 1] + ms[i - 2];
        }

        return ms[i - 1];
    }

    /**
     * 二叉树的最大深度
     * url: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 深度优先
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // 用栈实现深度优先
    // 思想 将当前节点出栈，子节点入栈
    public int maxDepth2(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        if (root != null) {
            stack.add(new Pair<>(root, 1));
        } else {
            return 0;
        }
        int maxDepth = 1;
        while (!stack.empty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            root = current.getKey();
            if (root != null) {
                maxDepth = Math.max(maxDepth, current.getValue());
                stack.add(new Pair<>(root.left, current.getValue() + 1));
                stack.add(new Pair<>(root.right, current.getValue() + 1));
            }
        }

        return maxDepth;
    }

    // 广度优先


    /**
     * 买股票的最佳时机
     * url: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/
     */
    // 暴力
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    profit = prices[j] - prices[i];
                }

                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }

    // 找到最小峰后的最大峰️
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    /**
     * 回文数
     * url : https://leetcode-cn.com/problems/palindrome-number/
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String y = Integer.toString(x);
        for (int i = 0, j = y.length() - 1; i < y.length() / 2; i++, j--) {
            if (y.charAt(i) != y.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断是否出现重复
     * url : https://leetcode-cn.com/problems/contains-duplicate/
     */
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }

        return false;
    }

    private boolean containDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }


    /**
     *
     * 盛水最多的容器
     * url : https://leetcode-cn.com/problems/container-with-most-water/
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {

                max = Math.max((j - i) * Math.min(height[i], height[j]), max);
                System.out.println(max);
            }
        }

        return max;
    }

    // 双指针法，短的指针向高的指针移动
    public int maxArea2(int[] height) {
        int max = 0;

        int p1 = 0;
        int p2 = height.length - 1;

        while (p1 < p2) {
            if (height[p1] < height[p2]) {
                max = Math.max(max, height[p1] * (p2 - p1));
                p1++;
            } else {
                max = Math.max(max, height[p2] * (p2 - p1));
                p2--;
            }
        }

        return max;
    }


    /**
     * 最长回文子串
     * url: https://leetcode-cn.com/problems/longest-palindromic-substring/
     */
    public String longestPalindrome(String s) {
        String reverseS = new StringBuilder(s).reverse().toString();
        System.out.println(reverseS);

        return null;
    }


    /**
     * 字符串转换成int
     * url: https://leetcode-cn.com/problems/string-to-integer-atoi/
     */
    public int myAtoi(String str) {
        str = str.replaceAll("[^0-9\\-]", "");
        if (str.equals("")) {
            return 0;
        }
        if ((int) str.charAt(0) < 48 || (int) str.charAt(0) > 57) {
            return 0;
        }
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
        return num;
    }


    /**
     * 合并两个有序链表
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode newList = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newList.next = new ListNode(l1.val);
                newList = newList.next;
                l1 = l1.next;
            } else {
                newList.next = new ListNode(l2.val);
                newList = newList.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            newList.next = new ListNode(l1.val);
            newList = newList.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            newList.next = new ListNode(l2.val);
            newList = newList.next;
            l2 = l2.next;
        }

        return head.next;
    }

    /**
     * 最大子序和
     * url: https://leetcode-cn.com/problems/maximum-subarray/
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }

        return max;
    }

}
