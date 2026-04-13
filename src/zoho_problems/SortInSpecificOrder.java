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
//        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
            }
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int partition = partitioner(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
    }

    private static int partitioner(int[] arr, int left, int right) {
        int pivot = arr[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (arr[l] <= pivot && l < right) {
                l++;
            }
            while (arr[r] > pivot && r > left) {
                r--;
            }
            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, left, r);
        return r;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 4, 7, 10 };
        sortIt(arr);
        System.out.println(Arrays.toString(arr));
    }
}
