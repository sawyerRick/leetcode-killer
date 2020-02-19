package cn.sawyer.leetcode.DNS;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 设计一种数据结构，保存域名(类似www.nowcoder.com)， 可以快速检索
 * @author: sawyer
 * @create: 2020-02-05 01:05
 **/
public class Solution {
    public static void main(String[] args) {

    }

    class DnsStore {
        Map<String, DnsStore> map = new HashMap<>();
        String subName;

        public DnsStore(String subName) {
            this.subName = subName;
        }

        void add(String name) {
            String[] subNames = name.split(".");
            for (int i = subNames.length - 1; i >= 0; i--) {
                if (map.containsKey(subNames[i])) {
                    add(map.get(subNames[i]).subName);
                } else {
                    map.put(subNames[i], new DnsStore(subNames[i]));
                }
            }
        }

    }
}
