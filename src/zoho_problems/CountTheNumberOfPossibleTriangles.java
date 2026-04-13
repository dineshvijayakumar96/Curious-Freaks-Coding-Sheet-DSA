package zoho_problems;

import java.util.Arrays;

public class CountTheNumberOfPossibleTriangles {

    public static int countTriangles(int[] arr) {
        if (arr.length < 3) return 0;
        int n = arr.length;
        int count = 0;
        Arrays.sort(arr);
        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 6, 3, 7 };
        System.out.println("Output: " + countTriangles(arr));
    }
}
