package cn.sawyer.leetcode.twoSum;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 两数之和，数据结构设计，https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/
 * @author: sawyer
 * @create: 2020-02-20 10:32
 **/
public class TwoSum {

    HashMap<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TwoSum() {

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int target = value - entry.getKey();
            if (target != entry.getKey()) {
                if (map.containsKey(target)) {
                    return true;
                }
            } else {
                if (entry.getValue() > 1) {
                    return true;
                }
            }
        }

        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */