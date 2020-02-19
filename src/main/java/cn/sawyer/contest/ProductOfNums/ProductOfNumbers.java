package cn.sawyer.contest.ProductOfNums;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-16 11:13
 **/


// 前缀和
class ProductOfNumbers {
    List<Integer> preResult = new ArrayList<>();
    int lastZero;

    public ProductOfNumbers() {
        preResult.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            lastZero = preResult.size();
            preResult.add(1);
        } else {
            preResult.add(preResult.get(preResult.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int r = preResult.size() - 1;
        int l = r - k;
        if (l < lastZero) return 0;
        return preResult.get(r) / preResult.get(l);
    }
}