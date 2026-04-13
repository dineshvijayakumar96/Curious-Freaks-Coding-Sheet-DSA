package zoho_problems;

import java.util.Arrays;

public class MoveAllZeroesToEnd {

    public static int[] pushZerosToEnd(int[] arr) {
        if (arr.length == 0) return new int[0];
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] != 0) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                start++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 0, 4, 3, 0, 5, 0 };
        System.out.println("Output: " + Arrays.toString(pushZerosToEnd(arr)));
    }
}
