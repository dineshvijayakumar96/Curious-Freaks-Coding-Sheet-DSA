package zoho_problems;

import java.util.ArrayList;
import java.util.List;

public class FrequenciesInALimitedArray {

    public static List<Integer> frequencyCount(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            if (arr[i] <= 0) {
                i++;
                continue;
            }
            int targetIndex = arr[i] - 1;
            if (targetIndex == i) {
                arr[i] = -1;
                i++;
            } else {
                if (arr[targetIndex] > 0) {
                    arr[i] = arr[targetIndex];
                    arr[targetIndex] = -1;
                } else {
                    arr[targetIndex]--;
                    arr[i] = 0;
                    i++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int k : arr) {
            result.add(Math.abs(k));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 3, 5 };
        System.out.println("Output: " + frequencyCount(arr));
    }
}
