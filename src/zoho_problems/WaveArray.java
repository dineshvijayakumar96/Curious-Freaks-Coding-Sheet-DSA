package zoho_problems;

import java.util.Arrays;

public class WaveArray {

    public static void sortInWave(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        sortInWave(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}
