package cn.sawyer.nowcode.find;

import java.net.Socket;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-01-01 15:32
 **/
public class Solution {

    public boolean Find(int target, int [][] array) {

        for (int[] ints : array) {


            for (int i = 0; i < ints.length; i++) {
                int low = 0;
                int high = ints.length;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (target == ints[i]) {
                        return true;
                    } else if (target < ints[i]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        boolean ans = s.Find(5, new int[][]{{1}, {1}});
        System.out.println(ans);
    }
}
