package cn.sawyer.leetcode.isHappy;

/**
 * @program: LeetCode
 * @description: 快乐数，https://leetcode-cn.com/problems/happy-number/
 * @author: sawyer
 * @create: 2020-02-03 17:11
 **/

// 快慢指针判断循环
public class Solution {

    private int sqrtNum(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = sqrtNum(slow);
            fast = sqrtNum(fast);
            fast = sqrtNum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}
