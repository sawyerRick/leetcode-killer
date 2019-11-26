import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.*;

public class Solution {

    public void nQueen() {
        SolutionNQueens queens = new SolutionNQueens();
        queens.solveNQueens(12);
    }

    // N皇后
    // url:https://leetcode-cn.com/problems/n-queens/
    // 同数独，约束编程+回溯
    class SolutionNQueens {
        private int n;
        private int[] columns;
        // 细节：对角线上的坐标相加或相减是一个常数
        private int[] hills;//正对角线 相减 ==》 常数
        private int[] dales;//负对角线 相加 ==》 常数
        private int[] queens;
        List<List<String>> out = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            this.columns = new int[n];
            this.dales = new int[2 * n - 1]; // c + r
            this.hills = new int[2 * n - 1]; // c - r + n - 1
            this.queens = new int[n];
            backTrace(0);

            return out;
        }

        private void pack() {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < queens.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < queens.length; j++) {
                    if (queens[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                l.add(sb.toString());
            }
            out.add(l);

//            for (String s : l) {
//                System.out.println(s);
//            }
//            System.out.println();
        }

        // 回溯
        private void backTrace(int r) {
            if (r >= n) {
                return;
            }
            // 按列逐个尝试, 全都不行就回溯
            for (int i = 0; i < n; i++) {
                if (couldPlace(r, i)) {
                    place(r, i);
                    // 下一行
                    backTrace(r + 1);
                    if (r + 1 == n) {
                        pack();
                    }
                    remove(r, i);
                }
            }
        }

        private void remove(int r, int c) {
            columns[c] = 0;
//            columns[c] = 0;
            dales[c + r] = 0;
            hills[c - r + n - 1] = 0;
            queens[r] = -1;
        }

        private void place(int r, int c) {
            columns[c] = 1;
//            columns[c] = 1;
            dales[c + r] = 1;
            hills[c - r + n - 1] = 1;
            queens[r] = c;
        }

        // 约束编程
        private boolean couldPlace(int r, int c) {
            // 不会出现行重复
            return columns[c] + dales[c + r] + hills[c - r + n - 1] == 0;
        }
    }

    // 两数相除
    // url: https://leetcode-cn.com/problems/divide-two-integers/
    // 将两数相除，要求不使用乘法、除法和 mod 运算符。

    public int myDivide(int dividend, int divisor) {
        // 判断符号
        boolean sign = (dividend > 0) ^ (divisor > 0);
        // 都变成负数运算
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int result = 0;

        while (dividend <= divisor) {
            int tmp_rst = -1;
            int tmp_divisor = divisor;
            while (dividend <= (tmp_divisor << 1)) {
                // 溢出判断
                if (tmp_divisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                tmp_rst = tmp_rst << 1;
                tmp_divisor = tmp_divisor << 1;
            }
            result += tmp_rst;
            dividend -= tmp_divisor;
        }

        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = -result;
        }

        return result;
    }


    public int divide(int dividend, int divisor) {
        // 异或运算 获得符号
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        // 都换成负数运算
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) {
            divisor = -divisor;
        }
        while(dividend <= divisor) {
            // 不断逼近被除数
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                // 判断溢出
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }


    //  组合总和
    // url:https://leetcode-cn.com/problems/combination-sum/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        return null;
    }

    // 报数
    // url:https://leetcode-cn.com/problems/count-and-say/
    // 外观数列
    public String countAndSay(int n) {
        StringBuilder[] list = new StringBuilder[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new StringBuilder();
        }
        list[0].append(1);

        for (int i = 0; i < n - 1; i++) {
            String curr = list[i].toString();

            int j;
            int count = 1;
            // 遍历前一个串，获取下一个串
            for (j = 0; j < curr.length(); j++) {
                // 取重复字段并计数
                int next = j + 1;
                char nextChar = '.';
                // 如果有下一个
                if (next < curr.length()) {
                    nextChar = list[i].charAt(j + 1);
                } else {
                    list[i + 1].append(count).append(list[i].charAt(j));
                    count = 1;
                    continue;
                }

                if (list[i].charAt(j) == nextChar) {
                    count++;
                } else {
                    list[i + 1].append(count).append(list[i].charAt(j));
                    count = 1;
                }
            }
        }

        return list[n - 1].toString();
    }

    // 解数独：
    // url:https://leetcode-cn.com/problems/sudoku-solver/solution/
    // 回溯+约束编程
    class SudoKuSolution {
        int n = 3;
        int N = n * n;

        boolean sudokuSolved = false;

        int[][] rows = new int[N][N + 1]; // N + 1为了方便直接表示下的数字
        int[][] columns = new int[N][N + 1];
        int[][] boxes = new int[N][N + 1];

        char[][] board;

        private void place(int d, int r, int c) {
            int idx = (r / n) * n + c / n;
            rows[r][d]++;
            columns[c][d]++;
            boxes[idx][d]++;
            board[r][c] = (char) (d + '0');
        }

        private void remove(int d, int r, int c) {
            int idx = (r / n) * n + c / n;
            rows[r][d]--;
            columns[c][d]--;
            boxes[idx][d]--;
            board[r][c] = '.';
        }

        private boolean couldPlace(int d, int r, int c) {
            int idx = (r / n) * n + c / n;

            return rows[r][d] + columns[c][d] + boxes[idx][d] == 0;
        }

        private void placeNext(int r, int c) {
            if (r == N - 1 && c == N - 1) {
                sudokuSolved = true;
            } else {
                if (c == N - 1) {
                    backTrace(r + 1, 0);
                } else {
                    backTrace(r, c + 1);
                }
            }
        }

        private void backTrace(int r, int c) {
            if (board[r][c] == '.') {
                // 尝试1-9
                for (int i = 1; i < 10; i++) {
                    if (couldPlace(i, r, c)) {
                        place(i, r, c);
                        placeNext(r, c);
                        if (!sudokuSolved) {
                            remove(i, r, c);
                        }
                    }
                }
            } else {
                placeNext(r, c);
            }
        }

        public void solveSudoku(char[][] board) {
            this.board = board;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] != '.') {
                        int d = Character.getNumericValue(board[i][j]);
                        place(d, i, j);
                    }
                }
            }

            backTrace(0, 0);
        }
    }


    // 有效的数独
    // url:https://leetcode-cn.com/problems/valid-sudoku/
    // 暴力解法，遍历三次
    public boolean isValidSudoku(char[][] board) {
        // 遍历行
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            // 遍历行内每个
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[i][j])) {
                    System.out.println("row");
                    return false;
                } else {
                    rowSet.add(board[i][j]);
                }
            }
        }

        // 遍历列
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> colSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (colSet.contains(board[j][i])) {
                    System.out.println("col");
                    return false;
                } else {
                    colSet.add(board[j][i]);
                }
            }
        }

        // 遍历九个九宫格
        int rowStart = 0;
        int colStart = 0;
        for (int i = 1; i <= board.length; i++) {
            HashSet<Character> set = new HashSet<>();
            // 遍历九宫格
            for (int j = rowStart; j < rowStart + 3; j++) {
                for (int k = colStart; k < colStart + 3; k++) {
                    if (board[j][k] == '.') {
                        continue;
                    }
                    if (set.contains(board[j][k])) {
                        return false;
                    } else {
                        set.add(board[j][k]);
                    }
                }
            }
            System.out.println(rowStart + "," + colStart);
            rowStart = i % 9 == 0? rowStart + 3: rowStart;
            colStart = colStart == 6? 0: colStart + 3;
        }
        
        return true;
    }

    // 优雅的解法，遍历一次
    public boolean isValidSudoku2(char[][] board) {
        HashMap<Character, Boolean>[] rows = new HashMap[9];
        HashMap<Character, Boolean>[] columns = new HashMap[9];
        HashMap<Character, Boolean>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int boxIndex = (i / 3) * 3 + j / 3;
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                if (rows[i].getOrDefault(c, false) || columns[j].getOrDefault(c, false) || boxes[boxIndex].getOrDefault(c, false)) {
                    return false;
                }

                rows[i].put(c, true);
                columns[j].put(c, true);
                boxes[boxIndex].put(c, true);
            }
        }

        return true;
    }

    // 整数转罗马数字
    // url:https://leetcode-cn.com/problems/integer-to-roman/
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
    public String intToRoman(int num) {
        // 用数组定义字典
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        //定义一个字符串
        StringBuilder res = new StringBuilder();

        for(int i = 0; i <values.length; i ++){
            int curr = num / values[i];
            if(curr == 0)continue;
            for(int j = curr; j > 0; j--)
                res.append(strs[i]);
            num -= (curr * values[i]);
            if(num == 0)break;
        }
        return res.toString();
    }

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
     * 买股票的最佳时机2
     * url: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
     */
    public int maxProfit3(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }

        int peak = 0;
        int valley = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length;) {
            int subProfit = 0;
            while (i < prices.length && i > 0 && prices[i] >= prices[i-1]) {
                peak = prices[i];
                subProfit = peak - valley;
                i++;
            }

            while (i < prices.length && i > 0 && prices[i] < prices[i-1]) {
                valley = prices[i];
                i++;
            }

            profit += subProfit;
        }

        // 改进
//        if (prices.length == 0 || prices == null) {
//            return 0;
//        }
//
//        int peak = prices[0];
//        int valley = prices[0];
//        int profit = 0;
//
//        for (int i = 1; i < prices.length;) {
//            while (i < prices.length && i > 0 && prices[i] < prices[i-1]) {
//                i++;
//            }
//            valley = prices[i-1];
//
//            while (i < prices.length && i > 0 && prices[i] >= prices[i-1]) {
//                i++;
//            }
//            peak = prices[i-1];
//            profit += peak - valley;
//        }
//
//        return profit;

        return profit;
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

    // 中心扩展法
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // 返回中心扩展的总共n个匹配串
    public int expandAroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
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

    /**
     * 三数之和
     * url : https://leetcode-cn.com/problems/3sum/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        if (nums.length < 3 || nums == null) {
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = nums.length - 1;

            while (L < R) {
                int sum = nums[L] + nums[R] + nums[i];

                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }

                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }

                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }

        return list;
    }


    /**
     * 最长公共前缀
     * url:https://leetcode-cn.com/problems/longest-common-prefix/
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j;
            for (j = 0; j < strs[i].length() && j < prefix.length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);

            if (prefix.equals("")) {
                return "";
            }
        }

        return prefix;
    }

    // 二叉树遍历
    // 前中后序遍历
    // 递归迭代深度优先遍历，共六种
    // 层次遍历

    // 递归前序遍历
    public void preOrderRecur(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preOrderRecur(node.left, list);
        preOrderRecur(node.right, list);
    }

    // 递归中序遍历
    public void middleOrderRecur(TreeNode node, List list) {
        if (node == null) {
            return;
        }

        middleOrderRecur(node.left, list);
        list.add(node.val);
        middleOrderRecur(node.right, list);

    }

    // 递归后续遍历
    public void postOrderRecur(TreeNode node, List list) {
        if (node == null) {
            return;
        }

        postOrderRecur(node.left, list);
        postOrderRecur(node.right, list);
        list.add(node.val);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderRecur(root, list);

        return list;
    }


    public List<Integer> middleOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        middleOrderRecur(root, list);

        return list;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderRecur(root, list);

        return list;
    }

    // 迭代前序遍历
    // 用栈实现，细节：先放右节点再放左节点
    public List<Integer> preOrderIter(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.add(node.val);

            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }

        }

        return output;
    }


    // 迭代中序遍历
    // 用栈实现

    public List<Integer> middleOrderIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
        }

        return output;
    }

    // 迭代后序遍历
    // 栈实现，和前序遍历相反，但是多个addFirst()

    public List<Integer> postOrderIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.addFirst(node.val);

            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }

        }

        return output;
    }

    // 二叉树的层次遍历
    // 队列实现
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> output = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return output;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            output.add(level);
        }
        return output;
    }

    // 不同路径
//    https://leetcode-cn.com/problems/unique-paths/

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int top = n - 1 ;
        int button = m + n - 1 - 1;

        return combination(top, button);
    }

    // 动态规划
//    我们令 dp[i][j] 是到达 i, j 最多路径
//    动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int combination(int top, int button) {
        BigDecimal result = BigDecimal.ONE;
        BigDecimal result2 = BigDecimal.ONE;
        long b = button;
        for (int i = 0; i < top; i++) {
            result = result.multiply(BigDecimal.valueOf(b--));
            System.out.println("result = " + result);;
        }

        for (int i = 1; i <= top; i++) {
            result2 = result2.multiply(BigDecimal.valueOf(i));
            System.out.println("result2 = " + result2);
        }

        return Integer.parseInt(result.divide(result2).toString());
    }

    // url:https://leetcode-cn.com/problems/fizz-buzz/
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
                continue;
            }

            if (i % 3 == 0) {
                list.add("Fizz");
                continue;
            }

            if (i % 5 == 0) {
                list.add("Buzz");
                continue;
            }

            list.add(i + "");
        }

        for (String s : list) {
            System.out.println(s);

        }

        return list;
    }

    // pow
    // 暴力法超时了。。。
    // url:https://leetcode-cn.com/problems/powx-n/
    public double myPow(double x, int n) {
//        Math.pow(x, n);
        if (n == 0) {
            return 1;
        }

        double result = x;
        for (int i = 1; i < Math.abs(n); i++) {
            result *= x;
        }

        if (n < 0) {
            result = 1 / result;
        }

        return result;
    }

    // 加一
    //https://leetcode-cn.com/problems/plus-one/
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }

        // 出现9999999之类数字时候
        digits = new int[digits.length + 1];
        digits[0] = 1;


        return digits;
    }

    //Z字形变换
    //url:https://leetcode-cn.com/problems/zigzag-conversion/solution/
    // 思路，从左右到右遍历字符串，把字符放到合适的位置
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        // 确定非空行
        int notNullRows = Math.min(numRows, s.length());
        for (int i = 0; i < notNullRows; i++) {
            rows.add(new StringBuilder());
        }

        int currRow = 0;
        boolean goingDown = true;

        for (char c : s.toCharArray()) {
            System.out.println("currRow = " + currRow);
            rows.get(currRow).append(c);

            currRow += goingDown? 1 : -1;
            // 到顶部或者底部要调头
            if (currRow == 0 || currRow == notNullRows - 1) {
                goingDown = !goingDown;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }

        return sb.toString();
    }

    // 正则匹配
    // url: https://leetcode-cn.com/problems/regular-expression-matching/
    public boolean isMatch(String s, String p) {
        char point = '.';
        char all = '*';
        char pre = s.charAt(0);

        int cur = 0;


        for (char c : s.toCharArray()) {
            if (c == point) {

            } else if (c == all) {

            } else {

            }
        }

        return true;
    }
}


/**
 * LRU页面置换算法
 * url: https://leetcode-cn.com/problems/lru-cache/
 */
class LRUCache {
    private int capacity;
    Map<Integer, Integer> map = new HashMap<>();
    LinkedList<Integer> flashList = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (flashList.contains(key)) {
            flashList.remove(key);
        } else {
            flashList.add(key);
        }

        int result;
        try {
            result = map.get(key);
        } catch (NullPointerException e) {
            result = -1;
        }
        return result;
    }


    public void put(int key, int value) {
        if (map.size() + 1 > capacity) {
            map.remove(flashList.get(0));
            flashList.remove(flashList.get(0));
        } else {
            flashList.add(key);
            map.put(key, value);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}