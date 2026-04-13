package zoho_problems;

import java.util.Arrays;

public class FormTheLargestNumber {

    public static String findLargest(int[] arr) {
        int n = arr.length;
        String[] stringArr = new String[n];
        for (int i = 0; i < n; i++) {
            stringArr[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(stringArr, (a, b) -> (b + a).compareTo(a + b));
        if (stringArr[0].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String str : stringArr) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] arr = { 3, 30, 34, 5, 9 };
        System.out.println("Output: " + findLargest(arr));
    }
}
