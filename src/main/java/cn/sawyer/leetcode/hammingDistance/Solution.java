package cn.sawyer.leetcode.hammingDistance;

/**
 * @program: LeetCode
 * @description: 汉明距离，https://leetcode-cn.com/problems/hamming-distance/
 * @author: sawyer
 * @create: 2020-01-31 16:08
 **/
public class Solution {
    // 按位异或
    public int hammingDistance2(int x, int y) {

        int n = 32;
        int count = 0;

        while (n >= 0) {
            // x & 1：意为 取x最右
            if (((x & 1) ^ (y & 1)) == 1) {
                count++;
            }
            x >>= 1;
            y >>= 1;
            n--;
        }

        return count;
    }

    // 逐个比较
    public int hammingDistance(int x, int y) {

        String a = Integer.toBinaryString(x);
        String b = Integer.toBinaryString(y);

        int pa = a.length() - 1;
        int pb = b.length() - 1;

        int count = 0;

        for (; pa >= 0 || pb >= 0; pa--, pb--) {
            char ca = pa >= 0 ? a.charAt(pa) : '0';
            char cb = pa >= 0 ? b.charAt(pb) : '0';

            if (ca != cb) {
                count++;
            }
        }

        return count;
    }
}
