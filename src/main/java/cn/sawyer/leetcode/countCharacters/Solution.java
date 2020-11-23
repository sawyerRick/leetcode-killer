package cn.sawyer.leetcode.countCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 拼写单词，https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 * @author: sawyer
 * @create: 2020-03-17 10:10
 **/
public class Solution {

    // 暴力哈希表
    public int countCharacters(String[] words, String chars) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < words.length; i++) {

            Map<Character, Integer> subMap = new HashMap<>();
            for (char c: words[i].toCharArray()) {
                subMap.put(c, subMap.getOrDefault(c, 0) + 1);
            }

            boolean add = true;
            for (Map.Entry<Character, Integer> entry : subMap.entrySet()) {
                if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    System.out.println(map.getOrDefault(entry.getKey(), 0) + "," + entry.getValue());
                    add = false;
                }
            }
            count = add ? count + words[i].length() : count;
        }

        return count;
    }

    // 简单26字母散列
    public int countCharacters2(String[] words, String chars) {

        int[] map = new int[26];

        for (char c : chars.toCharArray()) {
            map[c - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < words.length; i++) {

            int[] subMap = new int[26];
            for (char c: words[i].toCharArray()) {
                subMap[c - 'a']++;
            }

            boolean add = true;
            for (int j = 0; j < subMap.length; j++) {
                if (map[j] < subMap[j]) {
                    add = false;
                }
            }
            count = add ? count + words[i].length() : count;
        }

        return count;
    }
}