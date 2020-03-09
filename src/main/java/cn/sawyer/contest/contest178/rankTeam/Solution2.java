package cn.sawyer.contest.contest178.rankTeam;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-01 14:31
 **/


// 数组写法
public class Solution2 {
    public String rankTeams(String[] votes) {
        //key是参赛团队，value是该团队每个排位获得的票数
        Map<Character, int[]> map = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char c = vote.charAt(i);
                int[] rankArr = map.getOrDefault(c, new int[26]);
                rankArr[i]++; // 映射字符x出现在i的次数
                map.put(c, rankArr);
            }
        }

        List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            int[] rankA = a.getValue();
            int[] rankB = b.getValue();

            for (int i = 0; i < rankA.length; i++) {
                if (rankA[i] != rankB[i]) {
                    return rankB[i] - rankA[i];
                }
            }

            return a.getKey() - b.getKey();
        });

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, int[]> entry : list) {
            sb.append(entry.getKey());
        }

        return sb.toString();
    }
}