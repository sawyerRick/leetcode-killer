package cn.sawyer.leetcode.greedy.canPlaceFlowers;

/**
 * @program: LeetCode
 * @description: 种花问题，https://leetcode-cn.com/problems/can-place-flowers/
 * @author: sawyer
 * @create: 2020-02-08 18:31
 **/
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i = 0, count = 0;
        while (i < flowerbed.length) {
            // 当前0 && 第一个0/前一个0 && 最后一个0/后一个0
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

}
