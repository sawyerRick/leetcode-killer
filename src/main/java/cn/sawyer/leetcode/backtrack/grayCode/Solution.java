package cn.sawyer.leetcode.backtrack.grayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 格雷编码，https://leetcode-cn.com/problems/gray-code/
 * @author: sawyer
 * @create: 2020-01-30 15:00
 **/
public class Solution {



    // 格雷码公式：G(n) = B(n) xor B(n + 1) ; G(n)：格雷码第n位，B(n)：二进制表示的n
    public List<Integer> grayCode(int n) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, n); i++) {
            ans.add((i >> 1) ^ i);
            System.out.println(ans.get(ans.size() - 1));
        }


        return ans;
    }
}
