package zoho_problems;

import java.util.ArrayList;

public class MaximumSubArray {

    public static ArrayList<Integer> findSubarray(int[] arr) {
        long maxSum = -1;
        long currentSum = 0;
        int start = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentLength = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                currentSum += arr[i];
                currentLength++;
                if (currentSum > maxSum || (currentSum == maxSum && currentLength > maxLength)) {
                    maxSum = currentSum;
                    maxStart = start;
                    maxEnd = i;
                    maxLength = currentLength;
                }
            } else {
                currentSum = 0;
                currentLength = 0;
                start = i + 1;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (maxStart == -1) {
            result.add(-1);
            return result;
        }
        for (int i = maxStart; i <= maxEnd; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, -7, 2, 6 };
        System.out.println("Output: " + findSubarray(arr));
    }
}
