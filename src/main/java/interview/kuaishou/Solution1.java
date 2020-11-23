package interview.kuaishou;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-22 19:04
 **/
public class Solution1 {
    /**
     * 获取队中从前到后每个人与前方身高高于自己的人的最短距离
     * @param height int整型一维数组 队中从前到后每个人与前方身高高于自己的人的最短距离
     * @return int整型一维数组
     */
    public int[] DistanceToHigher (int[] height) {
        // write code here

        int[] ans = new int[height.length];

        for (int i = 0; i < height.length; i++) {

            int min = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > height[i]) {
                    min = i - j;
                    break;
                }
            }
            ans[i] = min == -1 ? 0 : min;
        }

        for (int an : ans) {
            System.out.println(an);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.DistanceToHigher(new int[]{175, 173, 174, 163, 182, 177});

    }
}