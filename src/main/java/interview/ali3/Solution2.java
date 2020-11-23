package interview.ali3;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-26 21:57
 **/
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        // 旋律
        List<String> rhythm = new ArrayList<>();
        rhythm.add("abcd");
        rhythm.add("fgh");
        rhythm.add("yz");
        rhythm.add("xyz");

        // 转换数组
        String[] arr = new String[rhythm.size()];
        rhythm.toArray(arr);
        int ans = solution2.solution(arr);
//        System.out.println(ans);
    }

    // 动态规划
    // dp[i]: len - 1到i的最长旋律
    // dp[i] = i == j ? rhythm[i].length() :max(dp[i], rhythm[i].length() + dp[j])
    private int solution(String[] rhythm) {

        int[] dp = new int[rhythm.length];
        // i从后往前
        for (int i = rhythm.length - 1; i >= 0; i--) {
            // j从i往后
            for (int j = i; j < rhythm.length; j++) {
                if (j == i) {
                    dp[i] = rhythm[i].length();
                } else if (rhythm[i].charAt(rhythm[i].length() - 1) <= rhythm[j].charAt(0)) {
                    // i的尾 <= j的头
                    dp[i] = Math.max(dp[i], rhythm[i].length() + dp[j]);
                }
            }
        }

        return dp[0];
    }
}
