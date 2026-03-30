package binary_search;

import java.util.ArrayList;

public class FirstAndLastOccurrences {

    public static ArrayList<Integer> firstAndLast(int[] arr, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        int first = lowerBound(arr, x);
        int last = upperBound(arr, x) - 1;
        if (first == arr.length || arr[first] != x ) {
            result.add(-1);
            result.add(-1);
            return result;
        }
        result.add(first);
        result.add(last);
        return result;
    }

    public static int lowerBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 7, 8, 8, 8 };
        int x = 8;
        System.out.println("Output: " + firstAndLast(arr, x));
    }
}
