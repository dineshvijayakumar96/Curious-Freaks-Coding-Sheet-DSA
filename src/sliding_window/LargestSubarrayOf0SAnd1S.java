package sliding_window;

import java.util.HashMap;

public class LargestSubarrayOf0SAnd1S {

    public static int maxLen(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }
            if (map.containsKey(sum)) {
                int previousIndex = map.get(sum);
                int currentLength = i - previousIndex;
                if (currentLength > length) {
                    length = currentLength;
                }
            } else {
                map.put(sum, i);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1, 1, 0, 0 };
        System.out.printf("Output: " + maxLen(arr));
    }
}
