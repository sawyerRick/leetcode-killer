package cn.sawyer.leetcode.isIsomorphic;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 重构字符串，https://leetcode-cn.com/problems/isomorphic-strings/
 * @author: sawyer
 * @create: 2020-02-26 20:07
 **/
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (smap.containsKey(sc) && smap.get(sc) != tc) {
                return false;
            }
            if (tmap.containsKey(tc) && smap.get(tc) != sc) {
                return false;
            }
            smap.put(sc, tc);
            tmap.put(tc, sc);
        }


        return true;
    }
}