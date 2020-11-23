package interview.jd;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-04-18 18:49
 **/

class Pair<A, B> {
    public final A fst;
    public final B snd;

    public Pair(A var1, B var2) {
        this.fst = var1;
        this.snd = var2;
    }

    public String toString() {
        return "Pair[" + this.fst + "," + this.snd + "]";
    }

    public boolean equals(Object var1) {
        return var1 instanceof Pair && Objects.equals(this.fst, ((Pair)var1).fst) && Objects.equals(this.snd, ((Pair)var1).snd);
    }

    public int hashCode() {
        if (this.fst == null) {
            return this.snd == null ? 0 : this.snd.hashCode() + 1;
        } else {
            return this.snd == null ? this.fst.hashCode() + 2 : this.fst.hashCode() * 17 + this.snd.hashCode();
        }
    }

    public static <A, B> Pair<A, B> of(A var0, B var1) {
        return new Pair(var0, var1);
    }
}


public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<Pair<Integer, Integer>, Integer> map = new HashMap<>(6);
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            Pair<Integer, Integer> pair;
            for (int j = 0; j < 6; j++) {
                int num1 = in.nextInt();
                int num2 = in.nextInt();
                if (num1 < num2) {
                    pair = new Pair<>(num1, num2);
                } else {
                    pair = new Pair<>(num2, num1);
                }
                list.add(pair);
            }

            for (Pair<Integer, Integer> p : list) {
                map.put(p, map.getOrDefault(p, 0) + 1);
            }

            int sum = 0;
            for (Map.Entry<Pair<Integer, Integer>, Integer> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + " :" + entry.getValue());
                if (entry.getValue() % 2 == 0) {
                    sum += entry.getValue();
                }
            }
            if (sum == 6) {
                ans.add("POSSIBLE");

            } else {
                ans.add("IMPOSSIBLE");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ans.get(i));
        }
    }
}
