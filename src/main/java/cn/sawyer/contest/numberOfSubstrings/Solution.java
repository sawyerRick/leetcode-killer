package cn.sawyer.contest.numberOfSubstrings;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-22 22:44
 **/
public class Solution {

    // 暴力
    public int numberOfSubstrings2(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int sum = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                if (set.size() == 3) {
                    sum += s.length() - j;
                    break;
                }
            }
            set.clear();
        }

        return sum;
    }

    // 滑动窗口
    public int numberOfSubstrings(String s) {
        int sum = 0;

        int l = 0;
        int h = 0;
        int[] map = new int[3];


        while (h < s.length()) {
            int idx = s.charAt(h) - 'a';
            map[idx]++;
            while (map[0] >= 1
                    && map[1] >= 1
                    && map[2] >= 1) {
                sum += s.length() - h;
                System.out.println(s.charAt(l) - 'a');
                map[s.charAt(l) - 'a']--;
                l++;
            }
            h++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }
}
