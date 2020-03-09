package cn.sawyer.leetcode.backtrack.restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 复原IP地址，https://leetcode-cn.com/problems/restore-ip-addresses/
 * @author: sawyer
 * @create: 2020-01-20 19:03
 **/
public class Solution {

    // 暴力
    public List<String> restoreIpAddresses(String s) {

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        if (a + b + c + d == s.length()) {
                            int a1 = Integer.parseInt(s.substring(0, a));
                            int b1 = Integer.parseInt(s.substring(a, a + b));
                            int c1 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int d1 = Integer.parseInt(s.substring(a + b + c, a + b + c + d));

                            if (a1 < 256 && b1 < 256 && c1 < 256 && d1 < 256) {
                                sb.append(a1).append(".")
                                        .append(b1).append(".")
                                        .append(c1).append(".")
                                        .append(d1);
                                if (sb.length() == s.length() + 3) {
                                    list.add(sb.toString());
                                }
                                sb.delete(0, sb.length());
                            }
                        }
                    }
                }
            }
        }


        return list;
    }
}
