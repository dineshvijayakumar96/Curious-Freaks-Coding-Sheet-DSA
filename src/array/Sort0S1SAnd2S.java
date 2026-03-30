package array;

import java.util.Arrays;

public class Sort0S1SAnd2S {

    public static int[] sortNumbers(int[] arr) {

        if (arr.length < 2) return arr;
        
        int low = 0, mid = 0, high = arr.length - 1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[mid] == 0 && mid <= high) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1 && mid <= high) {
                mid++;
            } else if (arr[mid] == 2 && mid <= high) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        System.out.println("Output: " + Arrays.toString(sortNumbers(arr)));
    }
}
