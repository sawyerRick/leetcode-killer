package cn.sawyer.leetcode.compareVersion;

/**
 * @program: LeetCode
 * @description: 比较版本号，https://leetcode-cn.com/problems/compare-version-numbers/
 * @author: sawyer
 * @create: 2020-02-05 00:33
 **/
public class Solution {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int p1 = 0;
        int p2 = 0;
        while (p1 < v1.length || p2 < v2.length) {
            Integer i1 = p1 < v1.length ? Integer.parseInt(v1[p1]) : 0;
            Integer i2 = p2 < v2.length ? Integer.parseInt(v2[p2]) : 0;

            if (!i1.equals(i2)) {
                return i1.compareTo(i2);
            }
            p1++;
            p2++;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("00103"));
    }
}
