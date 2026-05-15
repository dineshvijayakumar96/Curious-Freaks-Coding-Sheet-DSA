package zoho_problems;

import java.util.ArrayList;

public class IndexesOfSubarraySum {

    public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target && left < right) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                result.add(left + 1);
                result.add(right + 1);
                return result;
            }
        }
        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 7, 5 };
        int target = 12;
        System.out.println("Output: " + subarraySum(arr, target));
    }
}
