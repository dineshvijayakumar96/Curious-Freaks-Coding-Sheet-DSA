package sorting_Algorithm;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        sort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}
