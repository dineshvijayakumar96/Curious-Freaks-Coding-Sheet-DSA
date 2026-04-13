package zoho_problems;

import java.util.Arrays;

public class SortInSpecificOrder {

    public static void sortIt(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i] = -arr[i];
            }
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 4, 7, 10 };
        sortIt(arr);
        System.out.println(Arrays.toString(arr));
    }
}
