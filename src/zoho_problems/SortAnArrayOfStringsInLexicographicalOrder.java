package zoho_problems;

import java.util.Arrays;

public class SortAnArrayOfStringsInLexicographicalOrder {

    public static String[] sortArray(String[] arr) {
        if (arr.length == 0) return arr;
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        return arr;
    }

    private static void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(String[] arr, int left, int mid, int right) {
        int n = mid - left + 1;
        int m = right - mid;
        String[] arrLeft = new String[n];
        String[] arrRight = new String[m];
        for (int i = 0; i < arrLeft.length; i++) {
            arrLeft[i] = arr[left + i];
        }
        for (int i = 0; i < arrRight.length; i++) {
            arrRight[i] = arr[mid + 1 + i];
        }
        int leftPart = 0, rightPart = 0, k = left;
        while (leftPart < n && rightPart < m) {
            if (arrLeft[leftPart].compareTo(arrRight[rightPart]) <= 0) {
                arr[k] = arrLeft[leftPart];
                leftPart++;
            } else {
                arr[k] = arrRight[rightPart];
                rightPart++;
            }
            k++;
        }
        while (leftPart < n) {
            arr[k] = arrLeft[leftPart];
            leftPart++;
            k++;
        }
        while (rightPart < m) {
            arr[k] = arrRight[rightPart];
            rightPart++;
            k++;
        }
    }

    public static void main(String[] args) {
        String[] arr = { "banana", "apple", "cherry" };
        System.out.println("Output: " + Arrays.toString(sortArray(arr)));
    }
}
