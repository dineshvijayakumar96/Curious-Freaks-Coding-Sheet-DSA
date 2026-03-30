package array;

import java.util.HashMap;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int max = 0, value = 0;
        for (int num : map.keySet()) {
            if (map.get(num) > max) {
                max = map.get(num);
                value = num;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println("Output: " + majorityElement(nums));
    }
}
