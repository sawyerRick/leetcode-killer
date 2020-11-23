package interview.kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-22 19:15
 **/
public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[100000];
        int len = 0;

        while (sc.hasNext()) {
            nums[len++] = sc.nextInt();
            sc.nextByte();
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            int subCount = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    subCount++;
                }
            }
            if (subCount == 1) {
                list.add(i);
            }
        }

        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
        }


    }
}