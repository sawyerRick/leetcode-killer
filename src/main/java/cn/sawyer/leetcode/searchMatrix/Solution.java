package cn.sawyer.leetcode.searchMatrix;

/**
 * @program: LeetCode
 * @description: 搜索二维矩阵，1: https://leetcode-cn.com/problems/search-a-2d-matrix/, 2: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/description/
 * @author: sawyer
 * @create: 2020-01-14 18:53
 **/
public class Solution {
    // 矩阵搜索2 从左到右增大，从上到下增大
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 方法，一个指针指向左下角，然后收缩遍历
        int n = matrix.length;
        int m = matrix[0].length;

        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < m) {
            int curr = matrix[row][col];

            if (curr == target) {
                return true;
            } else if (target < curr) {
                row--;
            } else {
                col++;
            }
        }

        return false;
    }

    // 矩阵搜索1 左右到增大，行首大于前一行行尾
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        // 找到行
        int i = 0;
        int row = 0;
        while (i < n) {
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                row = i;
                break;
            }
            i++;
        }

        // 二分
        int l = 0;
        int r = m - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int t = matrix[row][mid];
            if (target == t) {
                return true;
            } else if (target < t) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }

    // 矩阵搜索1 一维和二维互相转换 公式：row = idx / m ， col = idx % m。n=>列数
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0;
        int r = n * m - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            int x = mid / m;
            int y = mid % m;
            System.out.println(x + "," + y);

            if (matrix[x][y] == target) {
                return true;
            } else if (target < matrix[x][y]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(10 % 3);
    }
}
