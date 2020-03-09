package cn.sawyer.contest.contest178.rankTeam;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 通过投票对团队排名，https://leetcode-cn.com/problems/rank-teams-by-votes/
 * @author: sawyer
 * @create: 2020-03-01 14:05
 **/

// List写法
public class Solution {

    // 思路排序
    public String rankTeams(String[] votes) {

        Map<Character, List<Integer>> map = new HashMap<>();

        // 初始化map
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char c = vote.charAt(i);
                if (map.get(c) == null) {
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(i);
            }
        }

        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            Collections.sort(map.get(entry.getKey()));
        }

        // 排序
        List<Map.Entry<Character, List<Integer>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> {
            int ai = 0;
            int bi = 0;
            while (ai < a.getValue().size() && bi < b.getValue().size()) {
                if (!a.getValue().get(ai).equals(b.getValue().get(bi))) {
                    return a.getValue().get(ai) - b.getValue().get(bi);
                }
                ai++;
                bi++;
            }
            return a.getKey() - b.getKey();
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, List<Integer>> listEntry : list) {
            sb.append(listEntry.getKey());
        }

        return sb.toString();
    }
}