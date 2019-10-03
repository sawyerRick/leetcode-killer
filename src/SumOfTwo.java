import java.util.HashMap;
import java.util.Map;


// 两数之和
public class SumOfTwo {
    public static void main(String[] args) {
        int[] result = myTwoSum2(new int[] {3, 1, 3}, 6);
        System.out.println("result:");
        for (int i : result) {
            System.out.println(i);
        }
    }

    // 两遍哈希表
    public static int[] myTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int compelement = target - nums[i];
            System.out.println(i);
            if (map.containsKey(compelement) && map.get(compelement) != i) {
                return new int[] {i, map.get(compelement)};
            }
        }

        throw new NullPointerException("hhh");
    }

    // 一遍哈希表
    public static int[] myTwoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int compelement = target - nums[i];
            if (map.containsKey(compelement)) {
                return new int[] {i, map.get(compelement)};
            }
            map.put(nums[i], i);
        }
        throw new NullPointerException("hhh");
    }




























//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i) {
//                return new int[] { i, map.get(complement) };
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
}
