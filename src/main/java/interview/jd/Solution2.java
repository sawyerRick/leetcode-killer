package interview.jd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-04-18 20:03
 **/
public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
        }

        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);

        // 最少需要的座位
        int seat = 1;
        int maxSeat = 1;

        // 记录 下车站-下车人数 映射
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0][1], 1);
        for (int i = 1; i < nums.length; i++) {
            // 先下后上

            // 下车
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() <= nums[i][0]) {
                    // 该下车了
                    seat -= entry.getValue();
                    entry.setValue(0);
                }
            }

            // 上车
            // 记录下车站
            map.put(nums[i][1], map.getOrDefault(nums[i][1], 0) + 1);
            seat++;
//            System.out.println(" curr:" + nums[i][0] + " seats:" + seat);
            maxSeat = Math.max(seat, maxSeat);
        }

        for (int[] num : nums) {
            System.out.println(num[0] + " " + num[1]);
        }

        System.out.println(maxSeat);
    }
}
