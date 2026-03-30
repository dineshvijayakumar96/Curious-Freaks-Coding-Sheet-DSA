package sorting_Algorithm;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr, int l, int r) {
        int[] temp = new int[arr.length];
        sort(arr, temp, l, r);
    }

    private static void sort(int[] arr, int[] temp, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(arr, temp, l, mid);
        sort(arr, temp, mid + 1, r);
        merge(arr, temp, l, mid, r);
    }

    private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int index = low;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
                index++;
            } else {
                temp[index] = arr[right];
                right++;
                index++;
            }
        }
        while (left <= mid) {
            temp[index] = arr[left];
            left++;
            index++;
        }
        while (right <= high) {
            temp[index] = arr[right];
            right++;
            index++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int l = 0, r = arr.length - 1;
        mergeSort(arr, l, r);
        System.out.println(Arrays.toString(arr));
    }
}
