package sliding_window;

import java.util.ArrayList;

public class IndexesOfSubarraySum {

    public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < arr.length) {
            sum += arr[right];
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                result.add(left + 1);
                result.add(right + 1);
                return result;
            }
            right++;
        }
        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 15;
        System.out.println("Output: " + subarraySum(arr, target));
    }
}
