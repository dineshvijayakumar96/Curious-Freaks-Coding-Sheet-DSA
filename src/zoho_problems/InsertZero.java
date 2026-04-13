package zoho_problems;

import java.util.Arrays;

public class InsertZero {

    public static int[] insertZeros(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k == 0) return arr;
        int count = 0;
        int zeros = 0;
        for (int num : arr) {
            if (num == 0) {
                count = 0;
            } else {
                count++;
            }
            if (count == k) {
                zeros++;
                count = 0;
            }
        }
        int[] result = new int[n + zeros];
        int index = 0;
        count = 0;
        for (int num : arr) {
            result[index++] = num;
            if (num == 0) {
                count = 0;
            } else {
                count++;
            }
            if (count == k) {
                result[index++] = 0;
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 };
        int k = 2;
        System.out.println("Output: " + Arrays.toString(insertZeros(arr, k)));
    }
}
