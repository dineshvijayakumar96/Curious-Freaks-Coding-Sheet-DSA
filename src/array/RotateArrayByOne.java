package array;

import java.util.Arrays;

public class RotateArrayByOne {

    public static int[] rotate(int[] arr) {

        int lastDigit = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastDigit;
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {9, 8, 7, 6, 4, 2, 1, 3};
        System.out.println("Output: " + Arrays.toString(rotate(arr)));
    }
}
