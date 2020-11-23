package interview.mihayou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-13 19:41
 **/
public class Solution2 {
    /**
     * 返回两个数组中相同数字不相交的最大连线数
     * @param A int整型一维数组 整数集合A
     * @param B int整型一维数组 整数集合B
     * @return int整型
     */
    public int maxUncrossedLines (int[] A, int[] B) {
        // write code here

        List<int[]> list = new ArrayList<>();

        int[] matchA = new int[A.length];
        int[] matchB = new int[B.length];

        for (int i = 0; i < A.length; i++) {

        }

        for (int i = 0; i < A.length; i++) {
            list.add(new int[]{A[i], B[i]});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);


        return 1;
    }
}