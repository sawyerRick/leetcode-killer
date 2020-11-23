package interview.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-22 19:26
 **/
public class Solution3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        [
            [豹子号长度，顺子号长度, 下标]，
            [豹子号长度，顺子号长度, 下标]，
            ...
        ]
         */

        String line = sc.nextLine();
        String[] nums = line.split(",");
        int[][] numStatus = new int[line.length()][3];
        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            String num = nums[i];
//            System.out.println("curr:" + num);

            int maxSeq = 1;
            int seqCount = 1;

            int maxSame = 1;
            int sameCount = 1;
            char last = line.charAt(0);
            for (int j = 1; j < num.length(); j++) {
                char curr = num.charAt(j);
                if (last == curr) {
                    sameCount++;
                    maxSame = Math.max(maxSame, sameCount);
                } else {
                    sameCount = 1;
                }
                if (last - '0' == curr - '1' || last - '1' == curr - '0') {
                    seqCount++;
                    maxSeq = Math.max(maxSeq, seqCount);
                } else {
                    seqCount = 1;
                }

                last = curr;
            }
            if (maxSame >= 3 || maxSeq >= 3) {
//                System.out.println(maxSame + ", " + maxSeq + ", " + num);
                numStatus[len++] = new int[]{maxSame, maxSeq, i};
            }
        }

        if (len == 0) {
            System.out.println("null");
        } else {
            Arrays.sort(numStatus, (a, b) -> {
                int aMax = a[0] == a[1] ? a[0] : Math.max(a[0], a[1]);
                int bMax = b[0] == b[1] ? b[0] : Math.max(b[0], b[1]);

                // 豹子顺子长度一样
                if (aMax == bMax) {
                    // 长度一样，两个豹子，按原顺序
                    if (aMax == a[0] && bMax == b[0]) {
                        return a[2] - b[2];
                    }
                    // 长度一样，a为豹子，b顺子
                    if (aMax == a[0]) {
                        return -1;
                    } else {
                        // 长度一样，a顺子, b豹子
                        return 1;
                    }
                    // 15166667233,15112347234
                    // 15112347234,15166667233
                } else {
                    return bMax - aMax;
                }
            });

            for (int i = 0; i < len; i++) {
                System.out.print(nums[numStatus[i][2]]);
                if (i != len - 1) {
                    System.out.print(",");
                }
            }
        }
    }
}
