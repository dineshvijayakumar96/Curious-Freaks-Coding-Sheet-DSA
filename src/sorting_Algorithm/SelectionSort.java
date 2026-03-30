package sorting_Algorithm;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int indexMinValue = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMinValue]) {
                    indexMinValue = j;
                }
            }
            if (indexMinValue != i) {
                int temp = arr[indexMinValue];
                arr[indexMinValue] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        sort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}
