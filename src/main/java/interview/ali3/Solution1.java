package interview.ali3;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-26 21:41
 **/

// 思路：有对子打对子，有顺子打顺子，最后打单张
    // 10种牌
public class Solution1 {
    int min = Integer.MAX_VALUE;
    int[] nums;

    public static void main(String[] args) {
        int[] nums = {3,5,4,2,1,5,4,4,4,4};
        Solution1 solution1 = new Solution1();
        solution1.nums = nums;
        System.out.println(solution1.continueSum(0));

        System.out.println(solution1.start(nums));
    }

    public int start(int[] arr) {
        nums = arr;
        backtrack(0, 0);
        return min;
    }

    // n当前在第n张牌，count：出手次数
    public void backtrack(int n, int count) {
        // 最后一张牌了
        if (n >= 10) {
            min = Math.min(min, count);
            return;
        }
        if (nums[n] == 0) {
            backtrack(n + 1, count);
            return;
        }
        int one = continueSum(n); // 顺子标志
        int two = continuePairSum(n); // 连对标志
        // 顺子
        if (one > 0) {
            divide(n, 1, 5); // 出
            backtrack(n, count + 1);
            add(n, 1, 5); // 回溯
        }
        // 连对
        if (two > 0) {
            divide(n, 2, 3); // 出
            backtrack(n, count + 1);
            add(n, 2, 3); // 回溯
        }
        // 对子
        if (nums[n] >= 2) {
            nums[n] -= 2;
            backtrack(n, count + 1);
            nums[n] += 2;

            return;
        }
        // 单个
        nums[n]--;
        backtrack(n, count + 1);
        nums[n]++;
    }

    // 顺子判断
    public int continueSum(int n) {
        if (n + 1 > 6)
            return 0;
        int min = 5; // 一次只能出5张
        for (int i = n; i < n + 5; i++) {
            min = Math.min(min, nums[i]); // 如果有中断，则返回0
        }
        return min;
    }

    // 连对判断
    public int continuePairSum(int n) {
        // 从8开始，没连对了
        if (n + 1 > 8)
            return 0;
        int min = 5;
        for (int i = n; i < n + 3; i++) {
            min = Math.min(min, nums[i] / 2); // 中断，则0
        }
        return min;

    }

    // 出牌
    // 从n开始出牌，出count张，time次
    public void divide(int n, int count, int time) {
        for (int i = n; i < n + time; i++) {
            nums[i] = nums[i] - count;
        }
    }

    // 回溯加牌
    // 从n开始加牌，加count张，time次
    public void add(int n, int count, int time) {
        for (int i = n; i < n + time; i++) {
            nums[i] = nums[i] + count;
        }
    }
}