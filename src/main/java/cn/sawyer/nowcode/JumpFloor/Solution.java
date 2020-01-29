package cn.sawyer.nowcode.JumpFloor;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-01-01 16:30
 **/
public class Solution {
    public static int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        }

        if (target == 2) {
            return 2;
        }

        if (target == 1) {
            return 1;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(2));
    }
}
