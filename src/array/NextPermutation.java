package array;

import java.util.Arrays;

public class NextPermutation {

    public static void permutation(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int index = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(arr, 0, arr.length - 1);
        } else {
            for (int j = arr.length - 1; j >= index; j--) {
                if (arr[j] > arr[index]) {
                    int temp = arr[index];
                    arr[index] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
            reverse(arr, index + 1, arr.length - 1);
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        permutation(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}
