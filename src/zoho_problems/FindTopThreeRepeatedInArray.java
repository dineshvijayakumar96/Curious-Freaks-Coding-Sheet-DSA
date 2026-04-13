package zoho_problems;

import java.util.*;

public class FindTopThreeRepeatedInArray {

    public static int[] findTopThree(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] top3 = new int[3];
        int[] counts = new int[3];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();
            if (count > counts[0]) {
                counts[2] = counts[1]; top3[2] = top3[1];
                counts[1] = counts[0]; top3[1] = top3[0];
                counts[0] = count;     top3[0] = val;
            }
            else if (count > counts[1]) {
                counts[2] = counts[1]; top3[2] = top3[1];
                counts[1] = count;     top3[1] = val;
            }
            else if (count > counts[2]) {
                counts[2] = count;     top3[2] = val;
            }
        }
        int uniqueCount = Math.min(3, map.size());
        int[] result = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = top3[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3 };
        System.out.println("Output: " + Arrays.toString(findTopThree(arr)));
    }
}
