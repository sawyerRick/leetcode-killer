package cn.sawyer.nowcode.minNumberInRotateArray;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-01-01 16:21
 **/
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }

        Arrays.sort(array);

        return array[0];
    }

    public int minNumberInRotateArray2(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] < array[i - 1]) {
                return array[i];
            }
        }

        return array[0];
    }
}
